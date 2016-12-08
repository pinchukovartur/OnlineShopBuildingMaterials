package ru.pinch.dao.user.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.pinch.dao.HibernateUtil;
import ru.pinch.dao.user.UserDAO;
import ru.pinch.entity.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private Session session;

    private void openSession(){
        session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public boolean addUser(User user) {
        openSession();
        session.save(user);
        return true;
    }

    public List<User> getUsers() {
        openSession();
        List result = session.createQuery("from User ").list();
        return result;
    }

    public void deleteUser(String id) {
        openSession();
        session.delete(session.get(User.class, id));
    }
}