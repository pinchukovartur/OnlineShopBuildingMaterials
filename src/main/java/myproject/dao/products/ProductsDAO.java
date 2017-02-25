package myproject.dao.products;

import myproject.entity.products.Photo;
import myproject.entity.products.Product;

import java.util.List;


public interface ProductsDAO {

    void addProduct(Product product);
    List getProducts();
    void deleteProduct(String id);
    Product getProductByID(String productID);
    List getProductsByType(String type);
    List getProductsByPrice(double priceWith, double priceBefore);

    void savePhoto(Photo photo);
}
