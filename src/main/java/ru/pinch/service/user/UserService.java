package ru.pinch.service.user;

import ru.pinch.entity.Basket;
import ru.pinch.entity.Material;
import ru.pinch.entity.Role;
import ru.pinch.entity.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    List<User> getUsers();
    User getUserByID(String username);
    void deleteUser(String id);

    void saveUser(String username, String password, String email);
    void addToBasket(String username, String productId);
    List<Material> getAllTheMaterialsOfThisUser(String username);
    void buyMaterialsUser(User user, Material material);
}
