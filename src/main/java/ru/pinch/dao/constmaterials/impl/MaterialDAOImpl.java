package ru.pinch.dao.constmaterials.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
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

    private void openSession(){
        session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public void addMaterial(Material material) {
        openSession();
        session.save(material);
        session.getTransaction().commit();
    }

    public List<Material> getMaterials() {
        openSession();
        List result = session.createQuery("from Material").list();
        session.getTransaction().commit();
        return result;
    }

    public void deleteMaterials(List<Material> result) {
        openSession();
        Transaction tx = session.beginTransaction();
        if(!tx.getStatus().equals(TransactionStatus.ACTIVE) ) {
            tx.commit();
        }
        for(Material p : result) {
            session.delete(p);
        }
        session.getTransaction().commit();
    }

    public void deleteMaterial(String id) {
        openSession();
        session.delete(session.get(Material.class, id));
        session.getTransaction().commit();
    }


    public boolean addPhoto(MaterialsPictures entity) {
        openSession();
        if(entity.getProductId().equals("")){
            return false;
        }
        else {
            session.save(entity);
            session.getTransaction().commit();
            return true;
        }
    }

    public List<MaterialsPictures> getPhotos() {
        openSession();
        List result = session.createQuery("from MaterialsPictures ").list();
        session.getTransaction().commit();
        return result;
    }

    public void deletePhoto(String id) {
        openSession();
        session.delete(session.get(MaterialsPictures.class, id));
        session.getTransaction().commit();
    }
}
