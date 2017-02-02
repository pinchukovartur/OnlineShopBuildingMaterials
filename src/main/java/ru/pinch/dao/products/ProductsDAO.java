package ru.pinch.dao.products;

import ru.pinch.entity.products.Product;
import ru.pinch.entity.products.plywoods.Plywood;

import java.util.List;


public interface ProductsDAO {

    void addProduct(Product product);
    List<Product> getMaterials();
    void deleteMaterial(String id);
    Plywood getMaterialsByID(String productID);


    List<Product> getSortListMaterials(double priceWith, double priceBefore);
}
