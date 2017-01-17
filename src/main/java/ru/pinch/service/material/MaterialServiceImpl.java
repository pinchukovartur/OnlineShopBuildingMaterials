package ru.pinch.service.material;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
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
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialDAO shopDataBase;


    public void addMaterialInDataBase(Material material) {
        shopDataBase.addMaterial(material);
    }

    public List<Material> getAllMaterialsOfTheDataBase() {
        return shopDataBase.getMaterials();
    }

    public void deleteAllMaterialsOfTheDataBase(List<Material> result) {
        shopDataBase.deleteMaterials(result);
    }

    public void deleteMaterialByIDOfTheDataBase(String id) {
        shopDataBase.deleteMaterial(id);
    }

    public boolean addPhotoInDataBase(MaterialsPictures materialsPictures) {
        return shopDataBase.addPhoto(materialsPictures);
    }

    public List<MaterialsPictures> getAllPhotosOfTheDataBase() {
        return shopDataBase.getPhotos();
    }

    public void deletePhotoByIDOfTheDataBase(String id) {
        shopDataBase.deleteMaterial(id);
    }

    public Material getMaterialsByIDOfTheDataBase(String productID) {
        return shopDataBase.getMaterialsByID(productID);
    }

    public void saveTheImageOnDataBase(MaterialsPictures materialsPictures) {
        shopDataBase.addPhoto(materialsPictures);
    }

    public boolean saveTheImageOnServer(String fileName, byte[] bytes) {
        try {
            /*String rootPath = System.getProperty("catalina.properties");*/

            File serverFile = new File("E:\\Projects\\OnlineShopBuildingMaterials\\web\\resources\\images\\"
                    + fileName + ".png");
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
                = "E:\\Projects\\OnlineShopBuildingMaterials\\web\\resources\\test2.pdf";

        Document document = new Document(PageSize.A5.rotate());
        document.open();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(RESULT));
            document.open();
            /*// the cell object
            PdfPCell cell;
            // we add a cell with colspan 3
            cell = new PdfPCell(new Phrase("Cell with colspan 3"));
            cell.setColspan(3);
            table.addCell(cell);
            // now we add a cell with rowspan 2
            cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
            cell.setRowspan(2);*/
            /*table.addCell(cell);*/

            for (int i = 0; i < materialList.size(); i++) {
                document.newPage();
                PdfPTable table = new PdfPTable(5);

                table.addCell(materialList.get(i).getProductId());
                table.addCell(String.valueOf(materialList.get(i).getPrice()));
                table.addCell(String.valueOf(materialList.get(i).getLength()));
                table.addCell(String.valueOf(materialList.get(i).getWeight()));
                table.addCell(materialList.get(i).getType());
/*                table.addCell(materialList.get(i).getProductId());
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

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        document.close();
    }

}