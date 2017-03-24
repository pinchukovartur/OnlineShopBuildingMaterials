package com.pincha.spring.dao.user;

import com.pincha.spring.dao.AbstractDao;
import com.pincha.spring.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    public User findByUserName(String username) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        User entity = session.get(User.class, username);
        transaction.commit();
        session.close();
        return entity;
    }
}
