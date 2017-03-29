package com.pincha.spring.forms;

import java.util.HashMap;
import java.util.Map;

public class ProductInputForm {
    private Map<String, String> product = new HashMap<>();
    private int idCategory;

    public ProductInputForm() {}

    public ProductInputForm(Map<String, String> product, int idCategory) {
        this.product = product;
        this.idCategory = idCategory;
    }

    public Map<String, String> getProduct() {
        return product;
    }

    public void setProduct(Map<String, String> product) {
        this.product = product;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "ProductInputForm{" +
                "product=" + product +
                ", idCategory=" + idCategory +
                '}';
    }
}
