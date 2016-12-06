package ru.pinch.dto;

import ru.pinch.model.ConstructionmaterialsEntity;
import ru.pinch.model.PhotoconstructionmaterialsEntity;
import ru.pinch.model.UsersEntity;

import java.util.List;

public interface ProductService {
    void addEntity(ConstructionmaterialsEntity constructionmaterialsEntity);
    List<ConstructionmaterialsEntity> listProducts();
    void deleteEntity(List<ConstructionmaterialsEntity> result);
    void deleteEntity(String id);

    boolean addUser(UsersEntity usersEntity);
    List<UsersEntity> listUsers();
    void deleteUser(String id);

    boolean addPhoto(PhotoconstructionmaterialsEntity photoconstructionmaterialsEntity);
    List<PhotoconstructionmaterialsEntity> listPhoto();
    void deletePhoto(String id);

}
