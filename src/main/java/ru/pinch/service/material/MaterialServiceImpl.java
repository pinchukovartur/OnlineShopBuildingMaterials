package ru.pinch.service.material;

import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pinch.dao.constmaterials.MaterialDAO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
    public boolean saveTheImageOnServer(String fileName, byte[] bytes) {
        try {
            String rootPath = System.getProperty("catalina.properties");

            File dir = new File(rootPath + File.separator + "tmpFiles");
            if (!dir.exists())
                dir.mkdirs();
            System.out.println(rootPath);
            File serverFile = new File("E:\\Projects\\OnlineShopBuildingMaterials\\web\\resources\\images\\"
                    + fileName + ".png");
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public void saveTheImageOnDataBase(MaterialsPictures materialsPictures){
        shopDataBase.addPhoto(materialsPictures);
    }
}
