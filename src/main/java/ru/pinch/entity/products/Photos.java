package ru.pinch.entity.products;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Photos {
    private String photo;
    private int idPhoto;
    private Product product;

    @Basic
    @Column(name = "Photo", nullable = false, length = 45)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Id
    @Column(name = "id_photo", nullable = false)
    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photos photos = (Photos) o;

        if (idPhoto != photos.idPhoto) return false;
        if (photo != null ? !photo.equals(photos.photo) : photos.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = photo != null ? photo.hashCode() : 0;
        result = 31 * result + idPhoto;
        return result;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "productID")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
