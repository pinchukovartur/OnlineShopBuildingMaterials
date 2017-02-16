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
        try {
            Document document = new Document(PageSize.A4.rotate());
            document.open();
            PdfWriter.getInstance(document, new FileOutputStream(RESULT));
            document.open();
            if(product.getType().equals("Robot")) {
                PdfPTable table = new PdfPTable(13);
                BaseFont bf = BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Font font = new Font(bf);
                Robot robot = (Robot) product;
                table.addCell(new Paragraph("Наименование", font));
                table.addCell(new Paragraph("Цена", font));
                table.addCell(new Paragraph("Тип", font));
                table.addCell(new Paragraph("Описание", font));
                table.addCell(new Paragraph("Модель", font));
                table.addCell(new Paragraph("Производитель", font));
                table.addCell(new Paragraph("Год выпуска", font));
                table.addCell(new Paragraph("Ось", font));
                table.addCell(new Paragraph("Грузоподьемность", font));
                table.addCell(new Paragraph("Охват", font));
                table.addCell(new Paragraph("След", font));
                table.addCell(new Paragraph("Стабильность", font));
                table.addCell(new Paragraph("Состояние", font));
                table.addCell(robot.getProductId());
                table.addCell(String.valueOf(robot.getPrice()));
                table.addCell(robot.getType());
                table.addCell(robot.getDescription());
                table.addCell(robot.getModel());
                table.addCell(robot.getManufacturer());
                table.addCell(String.valueOf(robot.getProductionYear()));
                table.addCell(robot.getAxles());
                table.addCell(String.valueOf(robot.getMaxLoad()));
                table.addCell(String.valueOf(robot.getReach()));
                table.addCell(robot.getFootprint());
                table.addCell(robot.getRepeatability());
                table.addCell(robot.getCondition());
                document.add(table);
                document.close();
            }
            if(product.getType().equals("Plywood")) {
                PdfPTable table = new PdfPTable(11);
                BaseFont bf = BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Font font = new Font(bf);
                Plywood plywood = (Plywood) product;
                table.addCell(new Paragraph("Наименование", font));
                table.addCell(new Paragraph("Цена", font));
                table.addCell(new Paragraph("Тип", font));
                table.addCell(new Paragraph("Описание", font));
                table.addCell(new Paragraph("Длина", font));
                table.addCell(new Paragraph("Толщина", font));
                table.addCell(new Paragraph("Сорт", font));
                table.addCell(new Paragraph("Водонепронецаемый", font));
                table.addCell(new Paragraph("Шлифованный", font));
                table.addCell(new Paragraph("Кол-во листов в упаковке", font));
                table.addCell(new Paragraph("Кол-во упаковок", font));
                table.addCell(plywood.getProductId());
                table.addCell(String.valueOf(plywood.getPrice()));
                table.addCell(plywood.getType());
                table.addCell(plywood.getDescription());
                table.addCell(String.valueOf(plywood.getLength()));
                table.addCell(String.valueOf(plywood.getThickness()));
                table.addCell(plywood.getGrade());
                if(plywood.getWaterResistance()>0)table.addCell("+");
                else table.addCell("-");
                if(plywood.getSanded()>0)table.addCell("+");
                else table.addCell("-");
                table.addCell(String.valueOf(plywood.getNumberOfSheets()));
                table.addCell(String.valueOf(plywood.getNumberOfPackages()));
                document.add(table);
                document.close();
            }
            if(product.getType().equals("ParticleBoard")) {
                PdfPTable table = new PdfPTable(9);
                BaseFont bf = BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Font font = new Font(bf);
                ParticleBoard particleBoard = (ParticleBoard) product;
                table.addCell(new Paragraph("Наименование", font));
                table.addCell(new Paragraph("Цена", font));
                table.addCell(new Paragraph("Тип", font));
                table.addCell(new Paragraph("Описание", font));
                table.addCell(new Paragraph("Длина", font));
                table.addCell(new Paragraph("Толщина", font));
                table.addCell(new Paragraph("Цвет", font));
                table.addCell(new Paragraph("Кол-во листов в упаковке", font));
                table.addCell(new Paragraph("Кол-во упаковок", font));
                table.addCell(particleBoard.getProductId());
                table.addCell(String.valueOf(particleBoard.getPrice()));
                table.addCell(particleBoard.getType());
                table.addCell(particleBoard.getDescription());
                table.addCell(String.valueOf(particleBoard.getLength()));
                table.addCell(String.valueOf(particleBoard.getThickness()));
                table.addCell(particleBoard.getColor());
                table.addCell(String.valueOf(particleBoard.getNumberOfSheets()));
                table.addCell(String.valueOf(particleBoard.getNumberOfPackages()));
                document.add(table);
                document.close();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


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
            XSSFSheet myExcelSheet = myExcelBook.getSheet("Лист1");

            Robot robot = new Robot();

            robot.setProductId(myExcelSheet.getRow(0).getCell(1).getStringCellValue());
            robot.setType(myExcelSheet.getRow(1).getCell(1).getStringCellValue());
            robot.setModel(myExcelSheet.getRow(2).getCell(1).getStringCellValue());
            robot.setManufacturer(myExcelSheet.getRow(3).getCell(1).getStringCellValue());
            robot.setProductionYear((int) myExcelSheet.getRow(4).getCell(1).getNumericCellValue());
            robot.setCondition(myExcelSheet.getRow(5).getCell(1).getStringCellValue());
            robot.setAxles(String.valueOf(myExcelSheet.getRow(7).getCell(1).getNumericCellValue()));
            robot.setMaxLoad((int) myExcelSheet.getRow(8).getCell(1).getNumericCellValue());
            robot.setReach((int) myExcelSheet.getRow(9).getCell(1).getNumericCellValue());
            robot.setFootprint(myExcelSheet.getRow(10).getCell(1).getStringCellValue());
            robot.setRepeatability(myExcelSheet.getRow(11).getCell(1).getStringCellValue());
            robot.setWeight((int) myExcelSheet.getRow(12).getCell(1).getNumericCellValue());
            robot.setPrice(myExcelSheet.getRow(13).getCell(1).getNumericCellValue());
            robot.setDescription(myExcelSheet.getRow(17).getCell(1).getStringCellValue());
            addProduct(robot);
            myExcelBook.close();

           /* if(getProductByID(robot.getProductId())!=null){return "Такой робот уже есть в базе";}*/


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
