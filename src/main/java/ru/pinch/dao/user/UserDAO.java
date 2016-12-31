package ru.pinch.dao.user;

import ru.pinch.entity.Basket;
import ru.pinch.entity.Material;
import ru.pinch.entity.Role;
import ru.pinch.entity.User;

import java.util.List;

public interface UserDAO {
    boolean addUser(User user);
    List<User> getUsers();
    void deleteUser(String id);

    void addRole(Role role);
    Role getRoleByID(int id);
    void deleteRoleByID(int id);

    void addToBasket(Basket basket);
    List<String> getProductIDUsers (String username);
}
