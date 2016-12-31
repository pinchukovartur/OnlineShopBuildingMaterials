package ru.pinch.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pinch.dao.constmaterials.MaterialDAO;
import ru.pinch.dao.user.UserDAO;
import ru.pinch.entity.Basket;
import ru.pinch.entity.Material;
import ru.pinch.entity.Role;
import ru.pinch.entity.User;
import ru.pinch.service.ApplicationMailer;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MaterialDAO materialDAO;

    @Transactional
    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }

    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Transactional
    public void deleteUser(String id) {
        userDAO.deleteUser(id);
    }


    @Transactional
    public void addRole(Role role) {
        userDAO.addRole(role);
    }


    @Transactional
    public Role getRoleByID(int id) {
        return userDAO.getRoleByID(id);
    }


    @Transactional
    public void deleteRoleByID(int id) {
        userDAO.deleteRoleByID(id);
    }

    public void addToBasket(String username, String productId) {
        Basket basket = new Basket();
        basket.setUsername(username);
        basket.setProductId(productId);
        userDAO.addToBasket(basket);
    }

    public List<Material> getUserMaterials(String username) {
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
        mailer.send("Online Materials Shop", message, "pinchukovartur@gmail.com", "pinchukovartur@gmail.com");
    }
}
