package ru.pinch.dao.userbase;

import ru.pinch.model.UsersEntity;

import java.util.List;

public interface UserDataBase {
    boolean addUser(UsersEntity usersEntity);
    List<UsersEntity> listUsers();
    void deleteUser(String id);
}
