package ru.pinch;



import ru.pinch.dao.userbase.UserDataBaseImpl;
import ru.pinch.model.ConstructionmaterialsEntity;
import ru.pinch.dao.constmaterials.BuildingOnlineShopDataBaseImpl;
import ru.pinch.model.UsersEntity;

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

        BuildingOnlineShopDataBaseImpl shopDataBase = new BuildingOnlineShopDataBaseImpl();

        System.out.println(shopDataBase.listProducts());
        /*shopDataBase.addEntity(constructionmaterialsEntity2);*/
        /*shopDataBase.deleteEntity(shopDataBase.listProducts());*/
        /*System.out.println(shopDataBase.listPhoto().get(0).getProductId());*/

        /*shopDataBase.addEntity(constructionmaterialsEntity);*/

        /*ConstructionmaterialsEntity entity = new ConstructionmaterialsEntity();
        entity.setProductId("test");
        shopDataBase.deleteEntity("test");*/

        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUsername("pinch2");
        usersEntity.setPassword("pinch2");
        usersEntity.setEnabled(1);
        usersEntity.setEmail("pinch2");
        usersEntity.setRole("ROLE_USER");



        UserDataBaseImpl userDataBase = new UserDataBaseImpl();
        /*userDataBase.addUser(usersEntity,authoritiesEntity);*/

        /*System.out.println(userDataBase.listUsers());*/
        /*System.out.println(userDataBase.listUsers());*/
        /*System.out.println(userDataBase.addUser(usersEntity));*/
    }
}
