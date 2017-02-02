package ru.pinch.dao.user;

import ru.pinch.entity.users.Basket;
import ru.pinch.entity.users.Role;
import ru.pinch.entity.users.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);
    List getUsers();
    User getUserByID(String username);
    void deleteUser(String id);

    void addRole(Role role);
    void deleteRoleByID(int id);

    void addToBasket(Basket basket);
    List<String> getProductIDUsers (String username);
}
