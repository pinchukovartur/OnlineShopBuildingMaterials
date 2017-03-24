package com.pincha.spring.dao.category;


import com.pincha.spring.dao.AbstractDao;
import com.pincha.spring.model.Category;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class CategoryDAOImpl extends AbstractDao<Integer, Category>{

    @Autowired
    private SessionFactory sessionFactory;

    public Category getByName(String name){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return (Category) session.createQuery("from Category where categoryName= :name")
                .setParameter("name", name).list().get(0);
    }
}
