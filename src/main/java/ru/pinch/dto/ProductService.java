package ru.pinch.dto;

import ru.pinch.model.ConstructionmaterialsEntity;

import java.util.List;

public interface ProductService {
    void addEntity(ConstructionmaterialsEntity constructionmaterialsEntity);
    List<ConstructionmaterialsEntity> listProducts();
    void deleteEntity(List<ConstructionmaterialsEntity> result);
    void deleteEntity(String id);
}
