package ru.pinch.service.material;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pinch.dao.constmaterials.MaterialDAO;
import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialDAO shopDataBase;

    @Transactional
    public void addMaterialInDataBase(Material material) {
        shopDataBase.addMaterial(material);
    }

    @Transactional
    public List<Material> getAllMaterialsOfTheDataBase() {
        return shopDataBase.getMaterials();
    }

    @Transactional
    public void deleteAllMaterialsOfTheDataBase(List<Material> result) {
        shopDataBase.deleteMaterials(result);
    }

    @Transactional
    public void deleteMaterialByIDOfTheDataBase(String id) {
        shopDataBase.deleteMaterial(id);
    }

    @Transactional
    public boolean addPhotoInDataBase(MaterialsPictures materialsPictures) {
        return shopDataBase.addPhoto(materialsPictures);
    }

    @Transactional
    public List<MaterialsPictures> getAllPhotosOfTheDataBase() {
        return shopDataBase.getPhotos();
    }

    @Transactional
    public void deletePhotoByIDOfTheDataBase(String id) {
        shopDataBase.deleteMaterial(id);
    }

    @Transactional
    public Material getMaterialsByIDOfTheDataBase(String productID) {
        return shopDataBase.getMaterialsByID(productID);
    }

    public boolean saveTheImageOnServer(String filename, byte[] bytes) {
        try {
            String rootPath = System.getProperty("catalina.properties");

            File dir = new File(rootPath + File.separator + "tmpFiles");
            if (!dir.exists())
                dir.mkdirs();
            File serverFile = new File("E:\\Projects\\OnlineShopBuildingMaterials\\web\\resources\\images"
                    +filename+ ".png");
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
}
