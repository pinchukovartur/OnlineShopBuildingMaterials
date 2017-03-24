package com.pincha.spring.service.user;

import com.pincha.spring.dao.user.UserDaoImpl;
import com.pincha.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public void save(User user) {
        userDao.persist(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }


}
