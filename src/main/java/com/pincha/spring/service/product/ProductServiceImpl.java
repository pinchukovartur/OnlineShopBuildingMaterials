package com.pincha.spring.service.product;


import com.pincha.spring.dao.catalog.CatalogDAOImpl;
import com.pincha.spring.dao.category.CategoryDAOImpl;
import com.pincha.spring.dao.product.ProductDAOImpl;
import com.pincha.spring.model.Attribute;
import com.pincha.spring.model.Catalog;
import com.pincha.spring.model.Category;
import com.pincha.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl {

    private ProductDAOImpl productDAO;
    private CategoryDAOImpl categoryDAO;
    private CatalogDAOImpl catalogDAO;

    @Autowired
    public ProductServiceImpl(ProductDAOImpl productDAO, CategoryDAOImpl categoryDAO, CatalogDAOImpl catalogDAO) {
        this.categoryDAO = categoryDAO;
        this.productDAO = productDAO;
        this.catalogDAO = catalogDAO;
    }

    public ArrayList<Catalog> getAllCatalogs() {
        return catalogDAO.getAll();
    }

    public ArrayList<Product> getAllProducts() {
        return productDAO.getAll();
    }

    public Category getCategoryByKey(int key) {
        return categoryDAO.getByKey(key);
    }

    public void deleteProductByKey(int key) {
        productDAO.deleteByKey(key);
    }

    public Product getProductByKey(int key) {
        return productDAO.getByKey(key);
    }

    public List<Attribute> getAttributeByCategory(int categoryId) {
        List<Attribute> attributes = new ArrayList<>();
        Category category = getCategoryByKey(categoryId);
        for (Attribute attribute : category.getAttributes()) {
            attributes.add(attribute);
        }
        return attributes;
    }
}
