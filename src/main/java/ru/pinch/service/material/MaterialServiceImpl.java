package ru.pinch.service.material;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pinch.dao.constmaterials.MaterialDAO;
import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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

    public void deleteAllMaterials(List<Material> result) {
        shopDataBase.deleteMaterials(result);
    }

    public void deleteMaterial(String id) {
        shopDataBase.deleteMaterial(id);
    }

    public boolean addPhoto(MaterialsPictures materialsPictures) {
        return shopDataBase.addPhoto(materialsPictures);
    }

    public List<MaterialsPictures> getAllPhotos() {
        return shopDataBase.getPhotos();
    }

    public void deletePhoto(String id) {
        shopDataBase.deleteMaterial(id);
    }

    public Material getMaterials(String productID) {
        return shopDataBase.getMaterialsByID(productID);
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

    public void getPDFWithMaterialsData(List<Material> materialList) {
        String RESULT
                = COMPUPER_PATH+"test.pdf";

        Document document = new Document(PageSize.A4.rotate());
        document.open();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(RESULT));
            System.out.println(new FileOutputStream(RESULT));
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

            for (int i = 0; i < materialList.size(); i++) {
                table.addCell(materialList.get(i).getProductId());
                table.addCell(String.valueOf(materialList.get(i).getPrice()));
                table.addCell(String.valueOf(materialList.get(i).getLength()));
                table.addCell(String.valueOf(materialList.get(i).getWeight()));
                table.addCell(materialList.get(i).getType());
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
            }
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        document.close();
    }

    public List<Material> getListMaterialsOnPage(List<Material> materialListOld, int pageNumber, int amountOnThePage) {
        List<Material> materialListOnPage = new ArrayList<Material>();
        for (int i = pageNumber *amountOnThePage-amountOnThePage; i < pageNumber * amountOnThePage; i++) {
            try {
                if (materialListOld.get(i) != null) {
                    materialListOnPage.add(materialListOld.get(i));
                }
            }
            catch (Exception e){
                System.err.println("Обработка исключений в getListMaterialsOnPage:" + i);
            }
        }
        return materialListOnPage;
    }

    public Integer getNumberPages(List<Material> materialListOld, int amountOnThePage) {
        int sizeBase = materialListOld.size();
        int numberOfPages = sizeBase/amountOnThePage;
        if(sizeBase%amountOnThePage!=0){
            numberOfPages++;
        }
        return numberOfPages;
    }

    public List<Material> getSortListMaterials(int type_particleBoard, int type_plywood, int price_with, int price_before, int grade) {
        List<Material> materialList = shopDataBase.getSortListMaterials(price_with,price_before);
        materialList = sortMaterialsByType(materialList, type_particleBoard, type_plywood);
        materialList = sortMaterialsByGrade(materialList,grade);
        return materialList;
    }

    private List<Material> sortMaterialsByType(List<Material> materialListOld, int type_particleBoard, int type_plywood){
        List<Material> materialListNew = new ArrayList<Material>();
        for (int i = 0; i < materialListOld.size(); i++) {
            if(type_plywood==1  && type_particleBoard==1){
                if(materialListOld.get(i).getType().contains("lywood") || materialListOld.get(i).getType().contains("article")){
                    materialListNew.add(materialListOld.get(i));
                }
            }
            if(type_particleBoard==1 && materialListOld.get(i).getType().contains("article") && type_plywood==0) {
                materialListNew.add(materialListOld.get(i));
            }
            if(type_plywood==1 && materialListOld.get(i).getType().contains("lywood") && type_particleBoard==0){
                materialListNew.add(materialListOld.get(i));
            }
            if(type_plywood==0 && type_particleBoard==0){
                return materialListOld;
            }
        }
        return materialListNew;
    }

    private List<Material> sortMaterialsByGrade(List<Material> materialListOld, int grade){
        if(grade>0){
            List<Material> materialListNew = new ArrayList<Material>();
            for (int i = 0; i < materialListOld.size(); i++) {
                try {
                    if(Integer.parseInt(materialListOld.get(i).getGrade().substring(0,1))==grade){
                        materialListNew.add(materialListOld.get(i));
                    }
                }
                catch (Exception e){
                    System.err.println("В базе храниться сорт с ошибкой-" + materialListOld.get(i).getGrade());
                }
            }
            return materialListNew;
        }
        else return materialListOld;
    }
}
