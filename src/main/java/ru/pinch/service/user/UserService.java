package ru.pinch.service.user;

import ru.pinch.entity.Basket;
import ru.pinch.entity.Material;
import ru.pinch.entity.Role;
import ru.pinch.entity.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    List<User> getUsers();
    void deleteUser(String id);

    void addRole(Role role);
    Role getRoleByID(int id);
    void deleteRoleByID(int id);

    void addToBasket(String username, String productId);

    List<Material> getUserMaterials(String username);

    void buyMaterialsUser(User user, Material material);
}
