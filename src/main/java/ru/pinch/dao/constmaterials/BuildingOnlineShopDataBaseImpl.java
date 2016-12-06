package ru.pinch.dao.constmaterials;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import ru.pinch.dao.HibernateUtil;
import ru.pinch.model.ConstructionmaterialsEntity;
import ru.pinch.model.PhotoconstructionmaterialsEntity;

import java.util.List;

public class BuildingOnlineShopDataBaseImpl implements BuildingOnlineShopDataBase{

    private Session session;

    public BuildingOnlineShopDataBaseImpl(){
        session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public void addEntity(ConstructionmaterialsEntity constructionmaterialsEntity) {
        session.save(constructionmaterialsEntity);
        session.getTransaction().commit();
    }

    public List<ConstructionmaterialsEntity> listProducts() {
        List result = session.createQuery("from ConstructionmaterialsEntity").list();
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


    /////////////////////////////////////////////////////////////////////////////

    public boolean addPhoto(PhotoconstructionmaterialsEntity entity) {
        if(entity.getProductId().equals("")){
            return false;
        }
        else {
            session.save(entity);
            session.getTransaction().commit();
            return true;
        }
    }

    public List<PhotoconstructionmaterialsEntity> listPhoto() {
        List result = session.createQuery("from PhotoconstructionmaterialsEntity ").list();
        session.getTransaction().commit();
        return result;
    }

    public void deletePhoto(String id) {
        session.delete(session.get(PhotoconstructionmaterialsEntity.class, id));
        session.getTransaction().commit();
    }
}
