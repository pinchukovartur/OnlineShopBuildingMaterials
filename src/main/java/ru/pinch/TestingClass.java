package ru.pinch;



import ru.pinch.model.database.ConstructionmaterialsEntity;
import ru.pinch.model.database.dao.ShopDataBaseImpl;

public class TestingClass {
    public static void main(String[] args) {
        ConstructionmaterialsEntity constructionmaterialsEntity = new ConstructionmaterialsEntity();
        constructionmaterialsEntity.setProductId("Test2");
        constructionmaterialsEntity.setType("bla bla bla");

        ShopDataBaseImpl shopDataBase = new ShopDataBaseImpl();
        //shopDataBase.addEntity(constructionmaterialsEntity);
        System.out.println(shopDataBase.listProducts());
    }
}
