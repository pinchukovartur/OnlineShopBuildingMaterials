package ru.pinch.dao.userbase;

import org.hibernate.Session;
import ru.pinch.dao.HibernateUtil;
import ru.pinch.model.PhotoconstructionmaterialsEntity;
import ru.pinch.model.UsersEntity;

import java.util.List;

public class UserDataBaseImpl implements UserDataBase {

    private Session session;

    public UserDataBaseImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    public boolean addUser(UsersEntity usersEntity) {
        session.save(usersEntity);
        session.getTransaction().commit();
        return true;
    }

    public List<UsersEntity> listUsers() {

        List result = session.createQuery("from UsersEntity ").list();
        session.getTransaction().commit();
        return result;
    }

    public void deleteUser(String id) {
        session.delete(session.get(UsersEntity.class, id));
        session.getTransaction().commit();
    }
}
