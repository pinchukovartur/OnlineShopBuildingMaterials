package ru.pinch.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pinch.dao.products.ProductsDAO;
import ru.pinch.dao.user.UserDAO;
import ru.pinch.entity.products.Product;
import ru.pinch.entity.products.plywoods.Plywood;
import ru.pinch.entity.users.Basket;
import ru.pinch.entity.users.Role;
import ru.pinch.entity.users.User;
import ru.pinch.service.ApplicationMailer;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ProductsDAO productsDAO;

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    public User getUserByID(String username) {
        return userDAO.getUserByID(username);
    }

    @Transactional
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
        userDAO.addRole(role);
        userDAO.addUser(user);
    }


   /* public void addRole(Role role) {
        userDAO.addRole(role);
    }

    public void deleteRoleByID(int id) {
        userDAO.deleteRoleByID(id);
    }*/

    public void addToBasket(String username, String productId) {
        Basket basket = new Basket();
        basket.setUsername(username);
        basket.setProductId(productId);
        userDAO.addToBasket(basket);
    }

    public List<Plywood> getAllTheMaterialsOfThisUser(String username) {
        List<String> result = userDAO.getProductIDUsers(username);

        List<Plywood> materialsListUser = new ArrayList<Plywood>();
        for (int i = 0; i < result.size(); i++) {
            materialsListUser.add(productsDAO.getMaterialsByID(result.get(i)));
        }
        return materialsListUser;
    }

    public void buyMaterialsUser(User user, Product plywood){
        ApplicationMailer mailer = new ApplicationMailer();
        String message = "Вы заказали:" + plywood.getProductId() + plywood.getType()
                            + "Стоимость:" +  plywood.getPrice();
        mailer.send("Online Materials Shop", message,  user.getEmail());
    }
}
