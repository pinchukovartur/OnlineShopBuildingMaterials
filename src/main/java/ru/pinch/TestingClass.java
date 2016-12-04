package ru.pinch;



import ru.pinch.model.ConstructionmaterialsEntity;
import ru.pinch.dao.ProductServiceImpl;

public class TestingClass {
    public static void main(String[] args) {
        ConstructionmaterialsEntity constructionmaterialsEntity = new ConstructionmaterialsEntity();
        constructionmaterialsEntity.setProductId("1250x1250x15_sanded_FK_3");
        constructionmaterialsEntity.setType("Raw plywood");
        constructionmaterialsEntity.setLength(1250);
        constructionmaterialsEntity.setWeight(1250);
        constructionmaterialsEntity.setThickness(15);
        constructionmaterialsEntity.setGrade("1/1");
        constructionmaterialsEntity.setSanded(1);
        constructionmaterialsEntity.setWaterResistance(0);
        constructionmaterialsEntity.setPrice(20.2);
        constructionmaterialsEntity.setNumberOfSheets(40);
        constructionmaterialsEntity.setNumberOfPackages(9);
        constructionmaterialsEntity.setMachineDescription("very good");

        ConstructionmaterialsEntity constructionmaterialsEntity2 = new ConstructionmaterialsEntity();
        constructionmaterialsEntity2.setProductId("2750x1830x16_109");
        constructionmaterialsEntity2.setType("Laminated particle board");
        constructionmaterialsEntity2.setLength(2750);
        constructionmaterialsEntity2.setWeight(1830);
        constructionmaterialsEntity2.setThickness(16);
        constructionmaterialsEntity2.setColor("Book Bavarija 109");
        constructionmaterialsEntity2.setPrice(2.1);
        constructionmaterialsEntity2.setNumberOfSheets(40);
        constructionmaterialsEntity2.setNumberOfPackages(9);
        constructionmaterialsEntity2.setMachineDescription("very good");

        ProductServiceImpl shopDataBase = new ProductServiceImpl();
        /*shopDataBase.addEntity(constructionmaterialsEntity2);*/
        /*shopDataBase.deleteEntity(shopDataBase.listProducts());*/
        System.out.println(shopDataBase.listProducts());

        /*ConstructionmaterialsEntity entity = new ConstructionmaterialsEntity();
        entity.setProductId("test");
        shopDataBase.deleteEntity("test");*/
    }
}
