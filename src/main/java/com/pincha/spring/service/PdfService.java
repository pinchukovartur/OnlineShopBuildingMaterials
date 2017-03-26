package com.pincha.spring.service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.pincha.spring.model.Product;
import com.pincha.spring.model.Value;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Map;

public class PdfService extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Product product = (Product) map.get("product");
        if (product.getValues().size() != 0) {
            PdfPTable table = new PdfPTable(product.getValues().size() + 2);

            BaseFont bf = BaseFont.createFont(map.get("filePath") + File.separator + "mystyles" + File.separator + "fonts" +File.separator +"arial.ttf",
                    "cp1251", BaseFont.EMBEDDED);


            Font font = new Font(bf, 7);

            table.addCell(new Paragraph("Наименование", font));
            table.addCell(new Paragraph("Описание", font));

            for (Value value : product.getValues()) {
                table.addCell(new Paragraph(value.getAttribute().getAttributeName(), font));
            }

            table.addCell(product.getProductName());
            table.addCell(product.getDescription());

            for (Value value : product.getValues()) {
                table.addCell(value.getValue());
            }
            document.add(table);
        } else {
            PdfPTable table = new PdfPTable(2);
            BaseFont bf = BaseFont.createFont(map.get("filePath") + File.separator + "mystyles" + File.separator + "fonts" +File.separator +"arial.ttf",
                    "cp1251", BaseFont.EMBEDDED);
            Font font = new Font(bf, 15);
            table.addCell(new Paragraph("ProductName", font));
            table.addCell(new Paragraph("Описание", font));
            table.addCell(product.getProductName());
            table.addCell(product.getDescription());
            document.add(table);
        }
    }
}
