package ru.pinch.service.products;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.pinch.dao.products.ProductsDAO;
import ru.pinch.entity.products.Photo;
import ru.pinch.entity.products.Product;
import ru.pinch.entity.products.particleboards.ParticleBoard;
import ru.pinch.entity.products.plywoods.Plywood;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductsService {

    private static final String COMPUTER_PATH = "E:\\Projects\\OnlineShopBuildingMaterials\\web\\resources\\jpg\\";

    @Autowired
    private ProductsDAO shopDataBase;


    public void addProduct(Product product) {
            shopDataBase.addProduct(product);
    }

    public List getProducts() {
        return shopDataBase.getProducts();
    }

    public void deleteProduct(String id) {
        shopDataBase.deleteProduct(id);
    }

    public Product getProductByID(String productID) {
        return shopDataBase.getProductByID(productID);
    }

    public void savePhoto(Photo photo){
        shopDataBase.savePhoto(photo);
    }

    public List getProductsByType(String type) {
        List<Product> products = shopDataBase.getProducts();
        List<Product> newProducts = new ArrayList<Product>();
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getType().equals(type)){
               newProducts.add(products.get(i));
            }
        }
        return newProducts;
    }


    public boolean saveTheImageOnServer(String fileName, byte[] bytes) {
        try {
            /*String rootPath = System.getProperty("catalina.properties");*/

            File serverFile = new File(COMPUTER_PATH
                    + fileName + ".jpg");
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public FileInputStream getPDF(Product product) {
        String RESULT
                = COMPUTER_PATH + "test.pdf";

        Document document = new Document(PageSize.A4.rotate());
        document.open();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(RESULT));
            document.open();
            PdfPTable table = new PdfPTable(4);

            BaseFont bf = BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf);

            table.addCell(new Paragraph("Наименование", font));
            table.addCell(new Paragraph("Цена", font));
            table.addCell(new Paragraph("Тип", font));
            table.addCell(new Paragraph("Описание", font));

            table.addCell(product.getProductId());
            table.addCell(String.valueOf(product.getPrice()));
            table.addCell(product.getType());
            table.addCell(product.getDescription());

            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        document.close();

        FileInputStream pdfFile = null;
        try {
            pdfFile = new FileInputStream(COMPUTER_PATH + "test.pdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return pdfFile;
    }

    public String addProductsFromExcel(MultipartFile file) {
        try {
            File file1 = new File(COMPUTER_PATH + "test.xlsx");
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(file1));
            stream.write(file.getBytes());
            stream.close();

            XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(COMPUTER_PATH + "test.xlsx"));
            XSSFSheet myExcelSheet = myExcelBook.getSheet("Materials");

            Product product = new Product();

            XSSFRow row = myExcelSheet.getRow(0);
            product.setProductId(row.getCell(1).getStringCellValue());

            /*row = myExcelSheet.getRow(1);
            plywood.setType(row.getCell(1).getStringCellValue());*/

           /* row = myExcelSheet.getRow(2);
            product.setLength((int) row.getCell(1).getNumericCellValue());

            row = myExcelSheet.getRow(3);
            product.setWeight((int) row.getCell(1).getNumericCellValue());

            row = myExcelSheet.getRow(4);
            product.setThickness((int) row.getCell(1).getNumericCellValue());

            row = myExcelSheet.getRow(5);
            product.setGrade(row.getCell(1).getStringCellValue());*/

            row = myExcelSheet.getRow(6);
            product.setPrice(row.getCell(1).getNumericCellValue());

            addProduct(product);
            myExcelBook.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            return e.getMessage();
        }
        return "ok";
    }

    public List<Product> getProductsOnPage(List<Product> plywoodListOld, int pageNumber, int amountOnThePage) {
        List<Product> plywoodListOnPage = new ArrayList<Product>();
        for (int i = pageNumber * amountOnThePage - amountOnThePage; i < pageNumber * amountOnThePage; i++) {
            try {
                if (plywoodListOld.get(i) != null) {
                    plywoodListOnPage.add(plywoodListOld.get(i));
                }
            } catch (Exception e) {
                System.err.println("Обработка исключений в getProductsOnPage:" + i);
            }
        }
        return plywoodListOnPage;
    }

    public Integer getNumberPages(List<Product> plywoodListOld, int amountOnThePage) {
        int sizeBase = plywoodListOld.size();
        int numberOfPages = sizeBase / amountOnThePage;
        if (sizeBase % amountOnThePage != 0) {
            numberOfPages++;
        }
        return numberOfPages;
    }

    public List<Product> getProductsByPrice(int type_particleBoard, int type_plywood, int price_with, int price_before, int grade) {
        List<Product> productList = shopDataBase.getProductsByPrice(price_with, price_before);
        productList = sortMaterialsByType(productList, type_particleBoard, type_plywood);
        /*productList = sortMaterialsByGrade(productList, grade);*/
        return productList;
    }
    private List<Product> sortMaterialsByType(List<Product> plywoodListOld, int type_particleBoard, int type_plywood) {
        List<Product> plywoodListNew = new ArrayList<Product>();
        for (int i = 0; i < plywoodListOld.size(); i++) {
            if (type_plywood == 1 && type_particleBoard == 1) {
                if (plywoodListOld.get(i).getType().contains("lywood") || plywoodListOld.get(i).getType().contains("article")) {
                    plywoodListNew.add(plywoodListOld.get(i));
                }
            }
            if (type_particleBoard == 1 && plywoodListOld.get(i).getType().contains("article") && type_plywood == 0) {
                plywoodListNew.add(plywoodListOld.get(i));
            }
            if (type_plywood == 1 && plywoodListOld.get(i).getType().contains("lywood") && type_particleBoard == 0) {
                plywoodListNew.add(plywoodListOld.get(i));
            }
            if (type_plywood == 0 && type_particleBoard == 0) {
                return plywoodListOld;
            }
        }
        return plywoodListNew;
    }

    /*private List<Product> sortMaterialsByGrade(List<Product> plywoodListOld, int grade) {
        if (grade > 0) {
            List<Product> plywoodListNew = new ArrayList<Product>();
            for (int i = 0; i < plywoodListOld.size(); i++) {
                try {
                    if (Integer.parseInt(((Plywood)plywoodListOld.get(i)).getGrade().substring(0, 1)) == grade) {
                        plywoodListNew.add(plywoodListOld.get(i));
                    }
                } catch (Exception e) {
                    System.err.println("В базе храниться сорт с ошибкой-" + ((Plywood)plywoodListOld.get(i)).getGrade());
                }
            }
            return plywoodListNew;
        } else return plywoodListOld;
    }*/

/*




    private Product checkFirstColumnExcel(Product plywood, XSSFRow row) {
        if (row.getCell(0).getStringCellValue().contains("Product ID")) {
            plywood.setProductId(row.getCell(1).getStringCellValue());
        }
        if (row.getCell(0).getStringCellValue().contains("Type")) {
            plywood.setType(row.getCell(1).getStringCellValue());
        }
        *//*if(row.getCell(0).getStringCellValue().contains("Length")){
            plywood.setLength((int) row.getCell(1).getNumericCellValue());
        }*//*
        return plywood;
    }*/
}
