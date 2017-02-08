package ru.pinch.service.products;

import org.springframework.web.multipart.MultipartFile;
import ru.pinch.entity.products.Photo;
import ru.pinch.entity.products.Product;

import java.io.FileInputStream;
import java.util.List;

public interface ProductsService {

    void addProduct(Product product);
    List getProducts();
    void deleteProduct(String id);
    Product getProductByID(String productID);
    List getProductsByType(String type);

    String addProductsFromExcel(MultipartFile file);
    List getProductsOnPage(List<Product> plywoodListOld, int pageNumber, int amountOnThePage);
    Integer getNumberPages(List<Product> plywoodListOld, int amountOnThePage);

    boolean saveTheImageOnServer(String fileName, byte[] bytes);
    void savePhoto(Photo photo);

    FileInputStream getPDF(Product plywood);

   /*



    List<Product> getProductsByPrice(int type_particleBoard,
                                       int type_plywood, int price_with,
                                       int price_before, int grade);*/
}
