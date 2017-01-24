package ru.pinch.service.user;

import ru.pinch.entity.User;
import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;
import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsers();
    User getUserByID(String username);
    void deleteUser(String id);

    void saveUser(String username, String password, String email);
    void addToBasket(String username, String productId);
    List<Material> getAllTheMaterialsOfThisUser(String username);
    void buyMaterialsUser(User user, Material material);
}
