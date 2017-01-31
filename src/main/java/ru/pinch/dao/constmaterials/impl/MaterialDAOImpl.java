package ru.pinch.dao.constmaterials.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.stereotype.Repository;
import ru.pinch.dao.HibernateUtil;
import ru.pinch.dao.constmaterials.MaterialDAO;
import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;

import java.util.List;

@Repository
public class MaterialDAOImpl implements MaterialDAO {

    private Session session;

    private void openSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public void addMaterial(Material material) {
        openSession();
        session.save(material);
        session.getTransaction().commit();
        session.close();
    }

    public List<Material> getMaterials() {
        openSession();
        List result = session.createQuery("from Material").list();
        session.close();
        return result;
    }

    public void deleteMaterials(List<Material> result) {
        openSession();
        Transaction tx = session.beginTransaction();
        if (!tx.getStatus().equals(TransactionStatus.ACTIVE)) {
            tx.commit();
        }
        for (Material p : result) {
            session.delete(p);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void deleteMaterial(String id) {
        openSession();
        session.delete(session.get(Material.class, id));
        session.getTransaction().commit();
        session.close();
    }

    public Material getMaterialsByID(String productID) {
        openSession();
        try {
            Query query = session.createQuery("from Material where productId = :productId");
            query.setParameter("productId", productID);
            List<Material> result = query.list();
            session.close();
            return result.get(0);
        }
        catch (Exception e){
            return null;
        }

    }


    public boolean addPhoto(MaterialsPictures entity) {
        openSession();
        if (entity.getPhoto().equals("")) {
            return false;
        } else {
            session.save(entity);
            session.getTransaction().commit();
            session.close();
            return true;
        }
    }

    public List<MaterialsPictures> getPhotos() {
        openSession();
        List result = session.createQuery("from MaterialsPictures ").list();
        session.close();
        return result;
    }

    public void deletePhoto(String id) {
        openSession();
        session.delete(session.get(MaterialsPictures.class, id));
        session.getTransaction().commit();
        session.close();
    }

    public List<Material> getSortListMaterials(double price_with, double price_before) {
        openSession();
        Query query;
        if (price_before == 0 && price_with == 0) {
            return getMaterials();
        }
        if (price_before == 0) {
            query = session.createQuery("from Material where price > :price_with");
            query.setParameter("price_with", price_with);
            List<Material> result = query.list();
            session.close();
            return result;
        }
        if (price_with == 0) {
            query = session.createQuery("from Material where price < :price_before");
            query.setParameter("price_before", price_before);
            List<Material> result = query.list();
            session.close();
            return result;
        }

        query = session.createQuery("from Material where price <= :price_before and price >= :price_with");
        query.setParameter("price_before", price_before);
        query.setParameter("price_with", price_with);
        List<Material> result = query.list();
        session.close();
        return result;

    }
}
