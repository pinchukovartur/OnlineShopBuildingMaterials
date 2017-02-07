package ru.pinch.dao.products;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;
import ru.pinch.dao.HibernateUtil;
import ru.pinch.entity.products.Product;
import ru.pinch.entity.users.User;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsDAOImpl implements ProductsDAO {

    public void addProduct(Product product) {
        if (getProductByID(product.getProductId()) == null) {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(product);
                session.getTransaction().commit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "«Ошибка при вставке»", JOptionPane.OK_OPTION);
                System.out.println("addProduct exception:" + e.getMessage());
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
    }

    public List<Product> getProducts() {
        Session session = null;
        List products = new ArrayList<Product>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            products = session.createCriteria(Product.class).list();
        } catch (Exception e) {
            System.err.println("getProducts exception:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return products;
    }


    public void deleteProduct(String id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(session.get(Product.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("deleteProduct exception:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Product getProductByID(String productID) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Product" +
                    " where productId = :productId").setParameter("productId", productID);
            return (Product) query.list().get(0);
        } catch (Exception e) {
            System.err.println("getProductByID exception:" + e.getMessage());
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List getProductsByType(String type) {
        Session session = null;
        List products = new ArrayList<Product>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Product where productId = :type").setParameter("type", type);
            products = query.list();
        } catch (Exception e) {
            System.err.println("getProductsByType exception:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return products;
    }


    public List getProductsByPrice(double priceWith, double priceBefore) {
        Session session = null;
        List products = new ArrayList<Product>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        Query query;
        if (priceBefore == 0 && priceWith == 0) {
            products = getProducts();
        }
        if (priceBefore == 0) {
            query = session.createQuery("from Product where price > :priceWith").setParameter("priceWith", priceWith);
            products = query.list();
        }
        if (priceWith == 0) {
            query = session.createQuery("from Product where price < :priceBefore").setParameter("priceBefore", priceBefore);
            products = query.list();
        }
        query = session.createQuery("from Product where price <= :priceBefore and price >= :priceWith");
        query.setParameter("priceBefore", priceBefore);
        query.setParameter("priceWith", priceWith);
        products = query.list();
        } catch (Exception e) {
            System.err.println("getProductsByPrice exception:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return products;
    }
}
