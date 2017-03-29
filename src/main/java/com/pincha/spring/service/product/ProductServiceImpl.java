package com.pincha.spring.service.product;


import com.pincha.spring.dao.catalog.CatalogDAOImpl;
import com.pincha.spring.dao.category.CategoryDAOImpl;
import com.pincha.spring.dao.product.ProductDAOImpl;
import com.pincha.spring.dao.value.ValueDAOImpl;
import com.pincha.spring.model.Attribute;
import com.pincha.spring.model.Catalog;
import com.pincha.spring.model.Category;
import com.pincha.spring.model.Product;
import com.pincha.spring.model.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    @Autowired
    private ValueDAOImpl valueDAO;

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

   public void saveProduct(Map<String,String> product, int categoryId){
        Category category = categoryDAO.getByKey(categoryId);

       Product newProduct = new Product();
       newProduct.setCategory(category);
       newProduct.setDescription("des");
       newProduct.setPrice("awd");
       newProduct.setProductName("newProduct");
       /*productDAO.save(newProduct);*/

       Set<Attribute> attributes = category.getAttributes();
       Set<Value> values = new HashSet<>();
       for(Map.Entry entry: product.entrySet()){
           for (Attribute attribute: attributes){
               if (entry.getKey().equals(attribute.getAttributeName())){

                   Value value = new Value();
                   value.setAttribute(attribute);
                   value.setValue((String) entry.getValue());
                   value.setProduct(newProduct);

                   valueDAO.save(value);

                    values.add(value);
               }
           }
       }
   }
}
