package ru.pinch.dao.user;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.pinch.dao.HibernateUtil;
import ru.pinch.entity.products.Product;
import ru.pinch.entity.users.Basket;
import ru.pinch.entity.users.Role;
import ru.pinch.entity.users.User;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    public void addUser(User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "«Ошибка при вставке»", JOptionPane.OK_OPTION);
            System.out.println("addUser exception:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List getUsers() {
        Session session = null;
        List users = new ArrayList<User>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            users = session.createCriteria(User.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "«Ошибка при вставке»", JOptionPane.OK_OPTION);
            System.out.println("getUsers exception:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    public User getUserByID(String username) {
        Session session = null;
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            user = session.load(User.class, username);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "«Ошибка при вставке»", JOptionPane.OK_OPTION);
            System.out.println("getUsers exception:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    public void deleteUser(String id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(session.get(User.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "«Ошибка при вставке»", JOptionPane.OK_OPTION);
            System.out.println("deleteUser exception:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void addRole(Role role) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "«Ошибка при вставке»", JOptionPane.OK_OPTION);
            System.out.println("addRole exception:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public void deleteRoleByID(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(session.get(Role.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "«Ошибка при вставке»", JOptionPane.OK_OPTION);
            System.out.println("deleteRoleByID exception:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void addToBasket(Basket basket) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(basket);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "«Ошибка при вставке»", JOptionPane.OK_OPTION);
            System.out.println("addToBasket exception:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        }

    public List getProductIDUsers(String username) {
        Session session = null;
        List products = new ArrayList<Product>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("select distinct productId from Basket where username = :username");
            query.setParameter("username", username);
            products = query.list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "«Ошибка при вставке»", JOptionPane.OK_OPTION);
            System.out.println("addToBasket exception:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return products;
    }
}