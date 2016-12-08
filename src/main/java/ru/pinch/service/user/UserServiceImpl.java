package ru.pinch.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pinch.dao.user.UserDAO;
import ru.pinch.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

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
}
