package ru.pinch.dao.user;

import ru.pinch.entity.User;

import java.util.List;

public interface UserDAO {
    boolean addUser(User user);
    List<User> getUsers();
    void deleteUser(String id);
}
