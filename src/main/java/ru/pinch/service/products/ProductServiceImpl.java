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
import ru.pinch.entity.products.robots.Robot;

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

    private static final String COMPUTER_PATH = "E:\\Projects\\dataServer\\";

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

    public void savePhoto(Photo photo) {
        shopDataBase.savePhoto(photo);
    }

    public List getProductsByType(String type) {
        List<Product> products = shopDataBase.getProducts();
        List<Product> newProducts = new ArrayList<Product>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getType().equals(type)) {
                newProducts.add(products.get(i));
            }
        }
        return newProducts;
    }


    public boolean saveTheImageOnServer(String fileName, byte[] bytes) {
        try {
            /*String rootPath = System.getProperty("catalina.properties");*/

            File serverFile = new File(COMPUTER_PATH
                    + fileName);
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

    public List<Product> sortProductsByPrice(List<Product> oldProducts, int priceWith, int priceBefore) {
        List<Product> newProducts = new ArrayList<Product>();
        if (priceWith > 0 && priceBefore > 0) {
            for (Product oldProduct : oldProducts) {
                if(oldProduct.getPrice()!=null) {
                    int priceProduct = oldProduct.getPrice().intValue();
                    if (priceProduct >= priceWith && priceProduct <= priceBefore) {
                        newProducts.add(oldProduct);
                    }
                }
            }
            return newProducts;
        }
        if (priceWith > 0) {
            for (Product oldProduct : oldProducts) {
                if(oldProduct.getPrice()!=null) {
                    int priceProduct = oldProduct.getPrice().intValue();
                    if (priceProduct >= priceWith) {
                        newProducts.add(oldProduct);
                    }
                }
            }
            return newProducts;
        }
        if (priceBefore > 0) {
            for (Product oldProduct : oldProducts) {
                if(oldProduct.getPrice()!=null) {
                    int priceProduct = oldProduct.getPrice().intValue();
                    if (priceProduct <= priceBefore) {
                        newProducts.add(oldProduct);
                    }
                }
            }
            return newProducts;
        }
        return oldProducts;
    }

    public List<Robot> sortRobotsByProductionYear(List<Robot> oldList, int productionYear) {
        if(productionYear>1995) {
            List<Robot> newRobots = new ArrayList<Robot>();
            for (Robot anOldList : oldList) {
                if (anOldList.getProductionYear() == productionYear) {
                    newRobots.add(anOldList);
                }
            }
            return newRobots;
        }
        else return oldList;
    }

    public List<Robot> sortRobotsByMaxLoad(List<Robot> oldList, int maxLoad) {
        if(maxLoad>0) {
            List<Robot> newRobots = new ArrayList<Robot>();
            for (Robot anOldList : oldList) {
                if (anOldList.getMaxLoad() == maxLoad) {
                    newRobots.add(anOldList);
                }
            }
            return newRobots;
        }
        else return oldList;
    }

    public List<Robot> sortRobotsByReach(List<Robot> oldList, int reach) {
        if(reach>0) {
            List<Robot> newRobots = new ArrayList<Robot>();
            for (Robot anOldList : oldList) {
                if (anOldList.getReach() == reach) {
                    newRobots.add(anOldList);
                }
            }
            return newRobots;
        }
        else return oldList;
    }

    public List<Robot> sortRobotsByManufacturer(List<Robot> oldList, String manufacturer) {
        if(!manufacturer.equals("")) {
            List<Robot> newRobots = new ArrayList<Robot>();
            for (Robot anOldList : oldList) {
                if (anOldList.getManufacturer().equals(manufacturer)) {
                    newRobots.add(anOldList);
                }
            }
            return newRobots;
        }
        else return oldList;
    }

    public List<Plywood> sortPlywoodsBySanded(List<Plywood> oldList, int sanded) {
        List<Plywood> newList = new ArrayList<Plywood>();
        if(sanded>=0){
            for (Plywood anOldList : oldList) {
                if (anOldList.getSanded() == sanded) {
                    newList.add(anOldList);
                }
            }
            return newList;
        }
        else return oldList;
    }

    public List<Plywood> sortPlywoodsByWaterResistance(List<Plywood> oldList, int waterResistance) {
        List<Plywood> newList = new ArrayList<Plywood>();
        if(waterResistance>=0){
            for (Plywood anOldList : oldList) {
                if (anOldList.getWaterResistance() == waterResistance) {
                    newList.add(anOldList);
                }
            }
            return newList;
        }
        else return oldList;
    }

    public List<Plywood> sortPlywoodsByGrade(List<Plywood> oldList, int grade) {
        List<Plywood> newList = new ArrayList<Plywood>();
        if(grade>=0){
            for (Plywood anOldList : oldList) {
                try {
                    if (Integer.parseInt(anOldList.getGrade().substring(0, 1)) == grade) {
                        newList.add(anOldList);
                    }
                }
                catch (Exception e){
                    System.err.println("В Базе храниться сорт с ошибкой-"+anOldList.getGrade());
                }
            }
            return newList;
        }
        else return oldList;
    }

    public List<ParticleBoard> sortParticleBoardsByColor(List<ParticleBoard> oldList, String color) {
        List<ParticleBoard> newList = new ArrayList<ParticleBoard>();
        if(!color.equals("")){
            for (ParticleBoard anOldList : oldList) {
                if (anOldList.getColor().equals(color)) {
                    newList.add(anOldList);
                }
            }
            return newList;
        }
        else return oldList;
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
