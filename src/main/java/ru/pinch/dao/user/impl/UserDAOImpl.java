package ru.pinch.dao.user.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.pinch.dao.HibernateUtil;
import ru.pinch.dao.user.UserDAO;
import ru.pinch.entity.users.Basket;
import ru.pinch.entity.users.Role;
import ru.pinch.entity.users.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private Session session;

    private void openSession(){
        session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public void addUser(User user) {
        try {
            openSession();
            session.save(user);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e){
            System.err.println("ERROR ADD USER");
            session.close();
        }
    }

    public List<User> getUsers() {
        openSession();
        List result = session.createQuery("from User ").list();
        session.close();
        return result;
    }

    public User getUserByID(String username) {
        try {
            openSession();
            Query query = session.createQuery("from User where username = :username");
            query.setParameter("username", username);
            List<User> result = query.list();
            session.close();
            return result.get(0);
        }
        catch (Exception e){
            session.close();
            return null;
        }
    }

    public void deleteUser(String id) {
        openSession();
        session.delete(session.get(User.class, id));
        session.getTransaction().commit();
        session.close();
    }

    public void addRole(Role role) {
        try {
            openSession();
            session.save(role);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e){
            session.close();
        }
    }


    public void deleteRoleByID(int id) {
        openSession();
        Query query = session.createQuery("delete Role where id = :id");
        query.setParameter("id", id);
        session.getTransaction().commit();
        session.close();
    }

    public void addToBasket(Basket basket) {
        openSession();
        session.save(basket);
        session.getTransaction().commit();
        session.close();
    }

    public List<String> getProductIDUsers(String username) {
        openSession();
        Query query = session.createQuery("select distinct productId from Basket where username = :username");
        query.setParameter("username", username);
        List<String> result = query.list();
        session.close();
        return result;
    }
}