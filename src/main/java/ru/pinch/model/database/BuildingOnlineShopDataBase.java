package ru.pinch.model.database;

import java.util.List;

public interface BuildingOnlineShopDataBase {
    void addEntity(ConstructionmaterialsEntity constructionmaterialsEntity);
    List<ConstructionmaterialsEntity> listProducts();
    void deleteEntity(List<ConstructionmaterialsEntity> result);
    void deleteEntity(Object o);
}
