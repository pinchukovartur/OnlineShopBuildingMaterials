package ru.pinch.service.products;

import org.springframework.web.multipart.MultipartFile;
import ru.pinch.entity.products.Product;
import ru.pinch.entity.products.plywoods.Plywood;

import java.io.FileInputStream;
import java.util.List;

public interface ProductsService {

    void addMaterial(Product plywood);

    List<Product> getAllMaterials();

    void deleteMaterial(String id);

    Product getMaterial(String productID);


    String addMaterialsFromExcel(MultipartFile file);

    List<Product> getListMaterialsOnPage(List<Product> plywoodListOld, int pageNumber, int amountOnThePage);

    Integer getNumberPages(List<Product> plywoodListOld, int amountOnThePage);

    FileInputStream getPDFWithMaterialsData(Product plywood);

    boolean saveTheImageOnServer(String fileName, byte[] bytes);

    List<Product> getSortListMaterials(int type_particleBoard, int type_plywood, int price_with, int price_before, int grade);
}
