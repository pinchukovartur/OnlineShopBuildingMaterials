package ru.pinch.service.material;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pinch.dao.constmaterials.MaterialDAO;
import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialDAO shopDataBase;

    public MaterialServiceImpl() {
    }

    public void addMaterial(Material material) {
        shopDataBase.addMaterial(material);
    }

    public List<Material> getMaterials() {
        return shopDataBase.getMaterials();
    }

    public void deleteMaterials(List<Material> result) {
        shopDataBase.deleteMaterials(result);
    }

    public void deleteMaterial(String id) {
        shopDataBase.deleteMaterial(id);
    }

    public boolean addPhoto(MaterialsPictures materialsPictures) {
        return shopDataBase.addPhoto(materialsPictures);
    }

    public List<MaterialsPictures> getPhotos() {
        return shopDataBase.getPhotos();
    }

    public void deletePhoto(String id) {
        shopDataBase.deleteMaterial(id);
    }

}
