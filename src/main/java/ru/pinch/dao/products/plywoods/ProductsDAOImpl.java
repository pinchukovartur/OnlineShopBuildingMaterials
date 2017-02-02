package ru.pinch.dao.products.plywoods;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.pinch.dao.HibernateUtil;
import ru.pinch.dao.products.ProductsDAO;
import ru.pinch.entity.products.Product;
import ru.pinch.entity.products.plywoods.Plywood;

import java.util.List;

@Repository
public class ProductsDAOImpl implements ProductsDAO {

    private Session session;

    private void openSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public void addProduct(Product plywood) {
        openSession();
        session.save(plywood);
        session.getTransaction().commit();
        session.close();
    }

    public List<Product> getMaterials() {
        openSession();
        List result = session.createQuery("from Product").list();
        session.close();
        return result;
    }


    public void deleteMaterial(String id) {
        openSession();
        session.delete(session.get(Plywood.class, id));
        session.getTransaction().commit();
        session.close();
    }

    public Plywood getMaterialsByID(String productID) {
        openSession();
        try {
            Query query = session.createQuery("from Plywood where productId = :productId");
            query.setParameter("productId", productID);
            List<Plywood> result = query.list();
            session.close();
            return result.get(0);
        }
        catch (Exception e){
            return null;
        }

    }


    public List<Product> getSortListMaterials(double priceWith, double priceBefore) {
        openSession();
        Query query;
        if (priceBefore == 0 && priceWith == 0) {
            return getMaterials();
        }
        if (priceBefore == 0) {
            query = session.createQuery("from Product where price > :price_with");
            query.setParameter("price_with", priceWith);
            List<Product> result = query.list();
            session.close();
            return result;
        }
        if (priceWith == 0) {
            query = session.createQuery("from Product where price < :price_before");
            query.setParameter("price_before", priceBefore);
            List<Product> result = query.list();
            session.close();
            return result;
        }
        query = session.createQuery("from Product where price <= :price_before and price >= :price_with");
        query.setParameter("price_before", priceBefore);
        query.setParameter("price_with", priceWith);
        List<Product> result = query.list();
        session.close();
        return result;
    }
}
