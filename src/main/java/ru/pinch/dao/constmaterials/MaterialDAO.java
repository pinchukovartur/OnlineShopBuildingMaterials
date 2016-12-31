package ru.pinch.dao.constmaterials;

import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;

import java.util.List;

public interface MaterialDAO {
    void addMaterial(Material material);
    List<Material> getMaterials();
    void deleteMaterials(List<Material> result);
    void deleteMaterial(String id);
    Material getMaterialsByID(String productID);


    boolean addPhoto(MaterialsPictures entity);
    List<MaterialsPictures> getPhotos();
    void deletePhoto(String id);
}
