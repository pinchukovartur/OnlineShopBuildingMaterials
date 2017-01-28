package ru.pinch.service.material;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.pinch.dao.constmaterials.MaterialDAO;
import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    public static final String COMPUPER_PATH = "E:\\Projects\\OnlineShopBuildingMaterials\\web\\resources\\jpg\\";
    @Autowired
    private MaterialDAO shopDataBase;


    public void addMaterial(Material material) {
        shopDataBase.addMaterial(material);
    }

    public List<Material> getAllMaterials() {
        return shopDataBase.getMaterials();
    }

    public void deleteMaterial(String id) {
        shopDataBase.deleteMaterial(id);
    }

    public Material getMaterial(String productID) {
        return shopDataBase.getMaterialsByID(productID);
    }

    public List<MaterialsPictures> getAllPhotoMaterials(Material material) {
        return shopDataBase.getMaterialsByID(material.getProductId()).getMaterialsPicturesList();
    }

    public void saveTheImageOnDataBase(MaterialsPictures materialsPictures) {
        shopDataBase.addPhoto(materialsPictures);
    }

    public boolean saveTheImageOnServer(String fileName, byte[] bytes) {
        try {
            /*String rootPath = System.getProperty("catalina.properties");*/

            File serverFile = new File(COMPUPER_PATH
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

    public FileInputStream  getPDFWithMaterialsData(Material material) {
        String RESULT
                = COMPUPER_PATH + "test.pdf";

        Document document = new Document(PageSize.A4.rotate());
        document.open();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(RESULT));
            document.open();
            PdfPTable table = new PdfPTable(5);

            //подключаем файл шрифта, который поддерживает кириллицу
            BaseFont bf = BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf);

            table.addCell(new Paragraph("Наименование", font));
            table.addCell(new Paragraph("Цена", font));
            table.addCell(new Paragraph("Высота", font));
            table.addCell(new Paragraph("Ширина", font));
            table.addCell(new Paragraph("Тип", font));

                table.addCell(material.getProductId());
                table.addCell(String.valueOf(material.getPrice()));
                table.addCell(String.valueOf(material.getLength()));
                table.addCell(String.valueOf(material.getWeight()));
                table.addCell(material.getType());
              /*table.addCell(materialList.get(i).getProductId());
                table.addCell(materialList.get(i).getProductId());
                table.addCell(materialList.get(i).getProductId());
                table.addCell(materialList.get(i).getProductId());
                table.addCell(materialList.get(i).getProductId());
                table.addCell(materialList.get(i).getProductId());
                table.addCell(materialList.get(i).getProductId());
                table.addCell(materialList.get(i).getProductId());
                table.addCell(materialList.get(i).getProductId());
                table.addCell(materialList.get(i).getProductId());*/
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        document.close();

        FileInputStream pdfFile = null;
        try {
            pdfFile = new FileInputStream(COMPUPER_PATH+"test.pdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return pdfFile;
    }

    public void addMaterialsFromExcel(MultipartFile file) {

        try {
            writeIntoExcel("test2.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File file1 = new File(COMPUPER_PATH + file.getOriginalFilename());
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(file1));
            stream.write(file.getBytes());
            stream.close();


            XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(COMPUPER_PATH+"test2.xlsx"));
            XSSFSheet myExcelSheet = myExcelBook.getSheet("Birthdays");
            XSSFRow row = myExcelSheet.getRow(0);

            if(row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING){
                String name = row.getCell(0).getStringCellValue();
                System.out.println("name : " + name);
            }

            if(row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                Date birthdate = row.getCell(1).getDateCellValue();
                System.out.println("birthdate :" + birthdate);
            }

            myExcelBook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Material> getListMaterialsOnPage(List<Material> materialListOld, int pageNumber, int amountOnThePage) {
        List<Material> materialListOnPage = new ArrayList<Material>();
        for (int i = pageNumber * amountOnThePage - amountOnThePage; i < pageNumber * amountOnThePage; i++) {
            try {
                if (materialListOld.get(i) != null) {
                    materialListOnPage.add(materialListOld.get(i));
                }
            } catch (Exception e) {
                System.err.println("Обработка исключений в getListMaterialsOnPage:" + i);
            }
        }
        return materialListOnPage;
    }

    public Integer getNumberPages(List<Material> materialListOld, int amountOnThePage) {
        int sizeBase = materialListOld.size();
        int numberOfPages = sizeBase / amountOnThePage;
        if (sizeBase % amountOnThePage != 0) {
            numberOfPages++;
        }
        return numberOfPages;
    }

    public List<Material> getSortListMaterials(int type_particleBoard, int type_plywood, int price_with, int price_before, int grade) {
        List<Material> materialList = shopDataBase.getSortListMaterials(price_with, price_before);
        materialList = sortMaterialsByType(materialList, type_particleBoard, type_plywood);
        materialList = sortMaterialsByGrade(materialList, grade);
        return materialList;
    }

    private List<Material> sortMaterialsByType(List<Material> materialListOld, int type_particleBoard, int type_plywood) {
        List<Material> materialListNew = new ArrayList<Material>();
        for (int i = 0; i < materialListOld.size(); i++) {
            if (type_plywood == 1 && type_particleBoard == 1) {
                if (materialListOld.get(i).getType().contains("lywood") || materialListOld.get(i).getType().contains("article")) {
                    materialListNew.add(materialListOld.get(i));
                }
            }
            if (type_particleBoard == 1 && materialListOld.get(i).getType().contains("article") && type_plywood == 0) {
                materialListNew.add(materialListOld.get(i));
            }
            if (type_plywood == 1 && materialListOld.get(i).getType().contains("lywood") && type_particleBoard == 0) {
                materialListNew.add(materialListOld.get(i));
            }
            if (type_plywood == 0 && type_particleBoard == 0) {
                return materialListOld;
            }
        }
        return materialListNew;
    }

    private List<Material> sortMaterialsByGrade(List<Material> materialListOld, int grade) {
        if (grade > 0) {
            List<Material> materialListNew = new ArrayList<Material>();
            for (int i = 0; i < materialListOld.size(); i++) {
                try {
                    if (Integer.parseInt(materialListOld.get(i).getGrade().substring(0, 1)) == grade) {
                        materialListNew.add(materialListOld.get(i));
                    }
                } catch (Exception e) {
                    System.err.println("В базе храниться сорт с ошибкой-" + materialListOld.get(i).getGrade());
                }
            }
            return materialListNew;
        } else return materialListOld;
    }

    @SuppressWarnings("deprecation")
    private static void writeIntoExcel(String file) throws FileNotFoundException, IOException{
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Birthdays");

        // Нумерация начинается с нуля
        Row row = sheet.createRow(0);

        // Мы запишем имя и дату в два столбца
        // имя будет String, а дата рождения --- Date,
        // формата dd.mm.yyyy
        Cell name = row.createCell(0);
        name.setCellValue("John");

        Cell birthdate = row.createCell(1);

        DataFormat format = book.createDataFormat();
        CellStyle dateStyle = book.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
        birthdate.setCellStyle(dateStyle);


        // Нумерация лет начинается с 1900-го
        birthdate.setCellValue(new Date(110, 10, 10));

        // Меняем размер столбца
        sheet.autoSizeColumn(1);

        // Записываем всё в файл
        book.write(new FileOutputStream(COMPUPER_PATH+file));
        book.close();
    }
}
