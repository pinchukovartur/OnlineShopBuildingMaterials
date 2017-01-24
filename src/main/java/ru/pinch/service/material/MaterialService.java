package ru.pinch.service.material;
import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;
import java.util.List;

public interface MaterialService {

    void addMaterial(Material material);
    List<Material> getAllMaterials();
    void deleteAllMaterials(List<Material> result);
    void deleteMaterial(String id);

    boolean addPhoto(MaterialsPictures materialsPictures);
    List<MaterialsPictures> getAllPhotos();
    void deletePhoto(String id);
    Material getMaterials(String productID);

    boolean saveTheImageOnServer(String filename, byte[] bytes);
    void saveTheImageOnDataBase(MaterialsPictures materialsPictures);
    void getPDFWithMaterialsData(List<Material> materialList);

    List<Material> getListMaterialsOnPage(List<Material> materialListOld,int pageNumber, int amountOnThePage);
    Integer getNumberPages(List<Material> materialListOld,int amountOnThePage);

    List<Material> getSortListMaterials(int type_particleBoard, int type_plywood, int price_with, int price_before, int grade);
}
