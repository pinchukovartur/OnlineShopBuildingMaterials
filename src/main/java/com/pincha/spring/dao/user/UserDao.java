package com.pincha.spring.dao.user;

import com.pincha.spring.model.User;

public interface UserDao {

    User findByUserName(String username);
}

