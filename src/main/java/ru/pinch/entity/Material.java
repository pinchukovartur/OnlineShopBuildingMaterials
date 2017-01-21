package ru.pinch.entity;


import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "constructionmaterials", schema = "buildingonlineshop")
public class Material {
    private String productId;
    private String type;
    private Integer length;
    private Integer weight;
    private Integer thickness;
    private String grade;
    private Double price;
    private Integer sanded;
    private Integer waterResistance;
    private Integer numberOfSheets;
    private Integer numberOfPackages;
    private String machineDescription;
    private String color;
    private List<MaterialsPictures> materialsPicturesList;

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
    @Column(name = "Price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    @Basic
    @Column(name = "MachineDescription", nullable = true, length = 45)
    public String getMachineDescription() {
        return machineDescription;
    }

    public void setMachineDescription(String machineDescription) {
        this.machineDescription = machineDescription;
    }

    @Basic
    @Column(name = "Color", nullable = true, length = 45)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @OneToMany(mappedBy = "material", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    public List<MaterialsPictures> getMaterialsPicturesList() {
        return materialsPicturesList;
    }

    public void setMaterialsPicturesList(List<MaterialsPictures> materialsPicturesList) {
        this.materialsPicturesList = materialsPicturesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Material that = (Material) o;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (thickness != null ? !thickness.equals(that.thickness) : that.thickness != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (sanded != null ? !sanded.equals(that.sanded) : that.sanded != null) return false;
        if (waterResistance != null ? !waterResistance.equals(that.waterResistance) : that.waterResistance != null)
            return false;
        if (numberOfSheets != null ? !numberOfSheets.equals(that.numberOfSheets) : that.numberOfSheets != null)
            return false;
        if (numberOfPackages != null ? !numberOfPackages.equals(that.numberOfPackages) : that.numberOfPackages != null)
            return false;
        if (machineDescription != null ? !machineDescription.equals(that.machineDescription) : that.machineDescription != null)
            return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (thickness != null ? thickness.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (sanded != null ? sanded.hashCode() : 0);
        result = 31 * result + (waterResistance != null ? waterResistance.hashCode() : 0);
        result = 31 * result + (numberOfSheets != null ? numberOfSheets.hashCode() : 0);
        result = 31 * result + (numberOfPackages != null ? numberOfPackages.hashCode() : 0);
        result = 31 * result + (machineDescription != null ? machineDescription.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
