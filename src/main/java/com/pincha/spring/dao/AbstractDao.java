package com.pincha.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

@Repository
public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
         T entity = session.get(persistentClass, key);
        transaction.commit();
        session.close();
        return entity;
    }

    public void persist(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public void deleteByKey(PK key) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.load(persistentClass,key));
        transaction.commit();
        session.close();
    }

    public void update(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    public ArrayList<T> getAll(){
        return (ArrayList<T>) getSession().createQuery("from " + persistentClass.getName()).list();
    }
}