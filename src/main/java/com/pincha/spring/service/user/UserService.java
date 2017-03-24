package com.pincha.spring.service.user;

import com.pincha.spring.model.User;

public interface UserService {

    User findByUserName(String username);
    void save(User user);
    void updateUser(User user);

}