package ru.pinch.entity.products.plywoods;

import ru.pinch.entity.products.Product;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Plywood")
@Table(name = "Product")
@DiscriminatorValue("Plywood")
public class Plywood extends Product {
    private String productId;
    private Integer length;
    private Integer weight;
    private Integer thickness;
    private String grade;
    private Integer sanded;
    private Integer waterResistance;
    private Integer numberOfSheets;
    private Integer numberOfPackages;

    @Id
    @Column(name = "ProductID", nullable = false, length = 45)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "Length", nullable = true)
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Basic
    @Column(name = "Weight", nullable = true)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "Thickness", nullable = true)
    public Integer getThickness() {
        return thickness;
    }

    public void setThickness(Integer thickness) {
        this.thickness = thickness;
    }

    @Basic
    @Column(name = "Grade", nullable = true, length = 45)
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "Sanded", nullable = true)
    public Integer getSanded() {
        return sanded;
    }

    public void setSanded(Integer sanded) {
        this.sanded = sanded;
    }

    @Basic
    @Column(name = "WaterResistance", nullable = true)
    public Integer getWaterResistance() {
        return waterResistance;
    }

    public void setWaterResistance(Integer waterResistance) {
        this.waterResistance = waterResistance;
    }

    @Basic
    @Column(name = "NumberOfSheets", nullable = true)
    public Integer getNumberOfSheets() {
        return numberOfSheets;
    }

    public void setNumberOfSheets(Integer numberOfSheets) {
        this.numberOfSheets = numberOfSheets;
    }

    @Basic
    @Column(name = "NumberOfPackages", nullable = true)
    public Integer getNumberOfPackages() {
        return numberOfPackages;
    }

    public void setNumberOfPackages(Integer numberOfPackages) {
        this.numberOfPackages = numberOfPackages;
    }


}
