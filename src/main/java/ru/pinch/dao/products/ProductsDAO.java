package ru.pinch.dao.products;

import ru.pinch.entity.products.Product;
import ru.pinch.entity.products.plywoods.Plywood;

import java.util.List;


public interface ProductsDAO {

    void addProduct(Product product);
    List getProducts();
    void deleteProduct(String id);
    Product getProductByID(String productID);
    List getProductsByType(String type);
    List getProductsByPrice(double priceWith, double priceBefore);
}
