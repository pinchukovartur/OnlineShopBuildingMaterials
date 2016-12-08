package ru.pinch.service.user;

import ru.pinch.entity.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);

    List<User> getUsers();

    void deleteUser(String id);
}
