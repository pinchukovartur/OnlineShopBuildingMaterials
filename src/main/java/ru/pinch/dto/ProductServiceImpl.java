package ru.pinch.dto;


import ru.pinch.dao.constmaterials.BuildingOnlineShopDataBase;
import ru.pinch.dao.constmaterials.BuildingOnlineShopDataBaseImpl;
import ru.pinch.dao.userbase.UserDataBase;
import ru.pinch.dao.userbase.UserDataBaseImpl;
import ru.pinch.model.ConstructionmaterialsEntity;
import ru.pinch.model.PhotoconstructionmaterialsEntity;
import ru.pinch.model.UsersEntity;

import java.util.List;

public class ProductServiceImpl implements ProductService{

    private BuildingOnlineShopDataBase shopDataBase;
    private UserDataBase userDataBase;

    public ProductServiceImpl(){
        shopDataBase = new BuildingOnlineShopDataBaseImpl();
        userDataBase = new UserDataBaseImpl();
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


    //////////////////////////////////////////////////////////////////////////////////////////

    public boolean addUser(UsersEntity usersEntity) {
        return userDataBase.addUser(usersEntity);
    }

    public List<UsersEntity> listUsers() {
        return userDataBase.listUsers();
    }

    public void deleteUser(String id) {
        userDataBase.deleteUser(id);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////


    public boolean addPhoto(PhotoconstructionmaterialsEntity photoconstructionmaterialsEntity) {
        return shopDataBase.addPhoto(photoconstructionmaterialsEntity);
    }

    public List<PhotoconstructionmaterialsEntity> listPhoto() {
        return shopDataBase.listPhoto();
    }

    public void deletePhoto(String id) {
        shopDataBase.deleteEntity(id);
    }

}
