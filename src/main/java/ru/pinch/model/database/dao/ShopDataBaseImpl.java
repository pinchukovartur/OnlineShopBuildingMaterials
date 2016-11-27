package ru.pinch.model.database.dao;

import org.hibernate.Session;
import ru.pinch.model.database.BuildingOnlineShopDataBase;
import ru.pinch.model.database.ConstructionmaterialsEntity;

import java.util.List;

public class ShopDataBaseImpl implements BuildingOnlineShopDataBase{
    public void addEntity(ConstructionmaterialsEntity constructionmaterialsEntity) {
                Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(constructionmaterialsEntity);
        session.getTransaction().commit();
        session.close();
    }

    public List<ConstructionmaterialsEntity> listProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<ConstructionmaterialsEntity> result = session.createQuery("from ConstructionmaterialsEntity").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void deleteEntity(List<ConstructionmaterialsEntity> result) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        for(ConstructionmaterialsEntity p : result) {
            System.out.println("Delete:"+p.getProductId());
            session.delete(p);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void deleteEntity(Object o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }
}
