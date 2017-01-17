package ru.pinch.service.material;
import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;
import java.util.List;

public interface MaterialService {

    void addMaterialInDataBase(Material material);
    List<Material> getAllMaterialsOfTheDataBase();
    void deleteAllMaterialsOfTheDataBase(List<Material> result);
    void deleteMaterialByIDOfTheDataBase(String id);
    boolean addPhotoInDataBase(MaterialsPictures materialsPictures);
    List<MaterialsPictures> getAllPhotosOfTheDataBase();
    void deletePhotoByIDOfTheDataBase(String id);
    Material getMaterialsByIDOfTheDataBase(String productID);
    boolean saveTheImageOnServer(String filename, byte[] bytes);
    void saveTheImageOnDataBase(MaterialsPictures materialsPictures);
    void getPDFwithMaterialsData();

}
