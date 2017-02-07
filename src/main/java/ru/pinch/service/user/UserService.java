package ru.pinch.service.user;

import ru.pinch.entity.products.Product;
import ru.pinch.entity.products.plywoods.Plywood;
import ru.pinch.entity.users.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List getUsers();
    User getUserByID(String username);
    void deleteUser(String id);

    void saveUser(String username, String password, String email);
    void addToBasket(String username, String productId);
    List getAllTheMaterialsOfThisUser(String username);
    void buyMaterialsUser(User user, Product plywood);
}
