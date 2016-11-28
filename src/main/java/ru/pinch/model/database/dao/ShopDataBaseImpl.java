package ru.pinch.model.database.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import ru.pinch.model.database.BuildingOnlineShopDataBase;
import ru.pinch.model.database.ConstructionmaterialsEntity;

import java.util.List;

public class ShopDataBaseImpl implements BuildingOnlineShopDataBase{

    Session session;

    public ShopDataBaseImpl(){
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
            System.out.println("Delete:"+p.getProductId());
            session.delete(p);
        }
        session.getTransaction().commit();
    }

    public void deleteEntity(Object o) {
        Transaction tx = session.beginTransaction();
        if(!tx.getStatus().equals(TransactionStatus.ACTIVE) ) {
            tx.commit();
        }
        session.delete(o);
        session.getTransaction().commit();
    }
}
