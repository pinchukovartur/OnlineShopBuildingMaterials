package ru.pinch.model.database;

import javax.persistence.*;

/**
 * Created by pincha on 27.11.2016.
 */
@Entity
@Table(name = "photoconstructionmaterials", schema = "buildingonlineshop", catalog = "")
public class PhotoconstructionmaterialsEntity {
    private String productId;
    private String photo;
    private ConstructionmaterialsEntity constructionmaterialsByProductId;

    @Id
    @Column(name = "ProductID", nullable = false, length = 45)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "Photo", nullable = false, length = 45)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoconstructionmaterialsEntity that = (PhotoconstructionmaterialsEntity) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false)
    public ConstructionmaterialsEntity getConstructionmaterialsByProductId() {
        return constructionmaterialsByProductId;
    }

    public void setConstructionmaterialsByProductId(ConstructionmaterialsEntity constructionmaterialsByProductId) {
        this.constructionmaterialsByProductId = constructionmaterialsByProductId;
    }
}
