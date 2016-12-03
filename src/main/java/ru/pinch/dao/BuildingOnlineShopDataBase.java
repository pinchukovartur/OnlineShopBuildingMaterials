package ru.pinch.dao;

import ru.pinch.model.ConstructionmaterialsEntity;

import java.util.List;

public interface BuildingOnlineShopDataBase {
    void addEntity(ConstructionmaterialsEntity constructionmaterialsEntity);
    List<ConstructionmaterialsEntity> listProducts();
    void deleteEntity(List<ConstructionmaterialsEntity> result);
    void deleteEntity(String id);
}
