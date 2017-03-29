package com.pincha.spring.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Photo {

    private String photoName;
    private Product product;

    public Photo(String photoName, Product product) {
        this.photoName = photoName;
        this.product = product;
    }

    public Photo(){

    }

    @Id
    @Column(name = "photoName",nullable = false, length = 45)
    public String getPhotoName() {
        return photoName;
    }
    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }


    @Override
    public String toString() {
        return "Photo{" +
                "photoName='" + photoName + '\'' +
                ", product=" + product +
                '}';
    }
}
