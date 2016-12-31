package ru.pinch.service.material;

import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;

import java.util.List;

public interface MaterialService {

    void addMaterial(Material material);

    List<Material> getMaterials();

    void deleteMaterials(List<Material> result);

    void deleteMaterial(String id);

    boolean addPhoto(MaterialsPictures materialsPictures);

    List<MaterialsPictures> getPhotos();

    void deletePhoto(String id);

    Material getMaterialsByID(String productID);

}
