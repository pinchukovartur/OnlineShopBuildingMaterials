package ru.pinch.dao.user.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.internal.QueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pinch.dao.HibernateUtil;
import ru.pinch.dao.constmaterials.MaterialDAO;
import ru.pinch.dao.user.UserDAO;
import ru.pinch.entity.Basket;
import ru.pinch.entity.Material;
import ru.pinch.entity.Role;
import ru.pinch.entity.User;

import java.util.ArrayList;
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
        session.getTransaction().commit();
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
        session.getTransaction().commit();
    }

    public void addRole(Role role) {
        openSession();
        session.save(role);
        session.getTransaction().commit();
    }

    public Role getRoleByID(int id) {
        openSession();
        Query query = session.createQuery("from Role where id = :id");
        query.setParameter("id", id);
        Role result = (Role) query.uniqueResult();
        return result;
    }

    public void deleteRoleByID(int id) {
        openSession();
        Query query = session.createQuery("delete Role where id = :id");
        query.setParameter("id", id);
        session.getTransaction().commit();
    }

    public void addToBasket(Basket basket) {
        openSession();
        session.save(basket);
        session.getTransaction().commit();
    }

    public List<String> getProductIDUsers(String username) {
        openSession();
        Query query = session.createQuery("select distinct productId from Basket where username = :username");
        query.setParameter("username", username);
        List<String> result = query.list();
        return result;
    }
}