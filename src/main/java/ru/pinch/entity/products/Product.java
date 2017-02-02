package ru.pinch.entity.products;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "Product")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="type",
        discriminatorType= DiscriminatorType.STRING
)
@DiscriminatorValue(value="Product")
public class Product {
    private String productId;
    private String type;
    private Double price;
    private String description;
    private String firstPhoto;
    private String secondPhoto;
    private String thirdPhoto;

    @Id
    @Column(name = "ProductID", nullable = false, length = 45)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "Type", nullable = false, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Basic
    @Column(name = "Price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "FirstPhoto", nullable = true, length = 45)
    public String getFirstPhoto() {
        return firstPhoto;
    }

    public void setFirstPhoto(String firstPhoto) {
        this.firstPhoto = firstPhoto;
    }

    @Basic
    @Column(name = "SecondPhoto", nullable = true, length = 45)
    public String getSecondPhoto() {
        return secondPhoto;
    }

    public void setSecondPhoto(String secondPhoto) {
        this.secondPhoto = secondPhoto;
    }

    @Basic
    @Column(name = "ThirdPhoto", nullable = true, length = 45)
    public String getThirdPhoto() {
        return thirdPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!productId.equals(product.productId)) return false;
        if (!type.equals(product.type)) return false;
        if (!price.equals(product.price)) return false;
        if (!description.equals(product.description)) return false;
        if (!firstPhoto.equals(product.firstPhoto)) return false;
        if (!secondPhoto.equals(product.secondPhoto)) return false;
        return thirdPhoto.equals(product.thirdPhoto);
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + firstPhoto.hashCode();
        result = 31 * result + secondPhoto.hashCode();
        result = 31 * result + thirdPhoto.hashCode();
        return result;
    }

    public void setThirdPhoto(String thirdPhoto) {


        this.thirdPhoto = thirdPhoto;
    }
}
