package ru.pinch.dao.constmaterials;

import ru.pinch.model.ConstructionmaterialsEntity;
import ru.pinch.model.PhotoconstructionmaterialsEntity;

import java.util.List;

public interface BuildingOnlineShopDataBase {
    void addEntity(ConstructionmaterialsEntity constructionmaterialsEntity);
    List<ConstructionmaterialsEntity> listProducts();
    void deleteEntity(List<ConstructionmaterialsEntity> result);
    void deleteEntity(String id);


    boolean addPhoto(PhotoconstructionmaterialsEntity entity);
    List<PhotoconstructionmaterialsEntity> listPhoto();
    void deletePhoto(String id);
}
