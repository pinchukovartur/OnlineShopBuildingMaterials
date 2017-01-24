package ru.pinch.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pinch.dao.constmaterials.MaterialDAO;
import ru.pinch.dao.user.UserDAO;
import ru.pinch.entity.Basket;
import ru.pinch.entity.Role;
import ru.pinch.entity.User;
import ru.pinch.service.ApplicationMailer;

import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MaterialDAO materialDAO;

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

    public List<Material> getAllTheMaterialsOfThisUser(String username) {
        List<String> result = userDAO.getProductIDUsers(username);

        List<Material> materialsListUser = new ArrayList<Material>();
        for (int i = 0; i < result.size(); i++) {
            materialsListUser.add(materialDAO.getMaterialsByID(result.get(i)));
        }
        return materialsListUser;
    }

    public void buyMaterialsUser(User user, Material material){
        ApplicationMailer mailer = new ApplicationMailer();
        String message = "Вы заказали:" + material.getProductId() + material.getType()
                            + "Стоимость:" +  material.getPrice();
        mailer.send("Online Materials Shop", message,  user.getEmail());
    }
}
