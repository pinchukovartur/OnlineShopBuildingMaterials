package ru.pinch.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import ru.pinch.model.ConstructionmaterialsEntity;

import java.util.List;

public class ProductServiceImpl implements BuildingOnlineShopDataBase{

    Session session;

    public ProductServiceImpl(){
        session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public void addEntity(ConstructionmaterialsEntity constructionmaterialsEntity) {
        session.save(constructionmaterialsEntity);
        session.getTransaction().commit();
    }

    public List<ConstructionmaterialsEntity> listProducts() {
        List<ConstructionmaterialsEntity> result = session.createQuery("from ConstructionmaterialsEntity").list();
        session.getTransaction().commit();
        return result;
    }

    public void deleteEntity(List<ConstructionmaterialsEntity> result) {
        Transaction tx = session.beginTransaction();
        if(!tx.getStatus().equals(TransactionStatus.ACTIVE) ) {
            tx.commit();
        }
        for(ConstructionmaterialsEntity p : result) {
            session.delete(p);
        }
        session.getTransaction().commit();
    }

    public void deleteEntity(String id) {
        session.delete(session.get(ConstructionmaterialsEntity.class, id));
        session.getTransaction().commit();
    }
}
