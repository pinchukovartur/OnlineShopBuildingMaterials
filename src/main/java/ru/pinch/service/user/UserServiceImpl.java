package ru.pinch.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pinch.dao.products.ProductsDAO;
import ru.pinch.dao.user.UserDAO;
import ru.pinch.entity.Purchase;
import ru.pinch.entity.products.Product;
import ru.pinch.entity.users.Basket;
import ru.pinch.entity.users.Role;
import ru.pinch.entity.users.User;
import ru.pinch.service.ApplicationMailer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ProductsDAO productsDAO;

    public void addUser(User user) {
        userDAO.addUser(user);
    }
    public List<User> getUsers() {
        return userDAO.getUsers();
    }
    public User getUserByID(String username) {
        return userDAO.getUserByID(username);
    }
    public void deleteUser(String id) {
        userDAO.deleteUser(id);
    }
    public void saveUser(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setEnabled(1);
        Role role = new Role();
        role.setUsername(username);
        role.setAuthority("ROLE_USER");

        userDAO.addUser(user);
        userDAO.addRole(role);
    }

    public void addToBasket(String username, String productId) {
        Basket basket = new Basket();
        basket.setUsername(username);
        basket.setProductId(productId);
        userDAO.addToBasket(basket);
    }

    public void deleteProductInBasket(String username, String productId) {
        userDAO.deleteProductInBasket(username,productId);
    }

    public List<Product> getAllTheMaterialsOfThisUser(String username) {
        List<String> result = userDAO.getProductIDUsers(username);

        List<Product> materialsListUser = new ArrayList<Product>();
        for (int i = 0; i < result.size(); i++) {
            materialsListUser.add(productsDAO.getProductByID(result.get(i)));
        }
        return materialsListUser;
    }

    public void buyMaterialsUser(User user, Product product){
        ApplicationMailer mailer = new ApplicationMailer();
        String message = "Вы заказали:" + product.getProductId()
                            + "Стоимость:" +  product.getPrice();
        mailer.send("Online Materials Shop", message,  user.getEmail());
    }

    public void savePurchase(String username, String productID, int quantity) {
        Date date = new Date();
        Purchase purchase = new Purchase();
        purchase.setUsername(username);
        purchase.setEmail(userDAO.getUserByID(username).getEmail());
        purchase.setQuantity(quantity);
        purchase.setProductID(productID);
        purchase.setDate(date.toString());

        userDAO.savePurchase(purchase);
    }

    public List<Purchase> getPurchases() {
        return userDAO.getPurchases();
    }

    public void deletePurchaseByID(int id) {
        userDAO.deletePurchaseByID(id);
    }
}
