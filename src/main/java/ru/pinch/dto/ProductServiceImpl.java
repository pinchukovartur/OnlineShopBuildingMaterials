package ru.pinch.dto;


import ru.pinch.model.ConstructionmaterialsEntity;

import java.util.List;

public class ProductServiceImpl implements ProductService{

    private ru.pinch.dao.ProductServiceImpl shopDataBase;

    public ProductServiceImpl(){
        shopDataBase = new ru.pinch.dao.ProductServiceImpl();
    }

    public void addEntity(ConstructionmaterialsEntity constructionmaterialsEntity) {
        shopDataBase.addEntity(constructionmaterialsEntity);
    }

    public List<ConstructionmaterialsEntity> listProducts() {
        return shopDataBase.listProducts();
    }

    public void deleteEntity(List<ConstructionmaterialsEntity> result) {
        shopDataBase.deleteEntity(result);
    }

    public void deleteEntity(String id) {
        shopDataBase.deleteEntity(id);
    }
}
