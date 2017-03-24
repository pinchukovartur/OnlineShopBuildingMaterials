package com.pincha.spring.dao.product;


import com.pincha.spring.dao.AbstractDao;
import com.pincha.spring.model.Category;
import com.pincha.spring.model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImpl extends AbstractDao<Integer, Product> implements ProductDAO {

}
