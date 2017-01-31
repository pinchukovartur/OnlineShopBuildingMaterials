package ru.pinch.service.material;
import org.springframework.web.multipart.MultipartFile;
import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public interface MaterialService {

    void addMaterial(Material material);
    List<Material> getAllMaterials();
    void deleteMaterial(String id);
    Material getMaterial(String productID);

    List<MaterialsPictures> getAllPhotoMaterials(Material material);

    boolean saveTheImageOnServer(String filename, byte[] bytes);
    void saveTheImageOnDataBase(MaterialsPictures materialsPictures);
    FileInputStream getPDFWithMaterialsData(Material material);

    String addMaterialsFromExcel(MultipartFile file);

    List<Material> getListMaterialsOnPage(List<Material> materialListOld,int pageNumber, int amountOnThePage);
    Integer getNumberPages(List<Material> materialListOld,int amountOnThePage);

    List<Material> getSortListMaterials(int type_particleBoard, int type_plywood, int price_with, int price_before, int grade);
}
