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
    void getPDFWithMaterialsData(List<Material> materialList);
    List<Material> getListMaterialsOnPage(int pageNumber, int amountOnThePage);
    Integer getNumberPages(int amountOnThePage);
    List<Material> getSortListMaterials(int type_particleBoard, int type_plywood, int price_with, int price_before, int grade);
}
