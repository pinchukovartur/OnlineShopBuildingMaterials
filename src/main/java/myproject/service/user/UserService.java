package myproject.service.user;

import myproject.entity.Purchase;
import myproject.entity.products.Product;
import myproject.entity.users.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List getUsers();
    User getUserByID(String username);
    void deleteUser(String id);

    void saveUser(String username, String password, String email);
    void addToBasket(String username, String productId);
    void deleteProductInBasket(String username, String productId);
    List getAllTheMaterialsOfThisUser(String username);
    void buyMaterialsUser(User user, Product plywood);

    void savePurchase(String username, String productID, int quantity);
    List<Purchase> getPurchases();
    void deletePurchaseByID(int id);
}
