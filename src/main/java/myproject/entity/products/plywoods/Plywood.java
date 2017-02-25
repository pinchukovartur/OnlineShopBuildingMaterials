package myproject.entity.products.plywoods;



import myproject.entity.products.Product;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
@DiscriminatorValue("Plywood")
public class Plywood extends Product {
    private String productId;
    private Integer length;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Plywood plywood = (Plywood) o;

        if (!productId.equals(plywood.productId)) return false;
        if (!length.equals(plywood.length)) return false;
        if (!thickness.equals(plywood.thickness)) return false;
        if (!grade.equals(plywood.grade)) return false;
        if (!sanded.equals(plywood.sanded)) return false;
        if (!waterResistance.equals(plywood.waterResistance)) return false;
        if (!numberOfSheets.equals(plywood.numberOfSheets)) return false;
        return numberOfPackages.equals(plywood.numberOfPackages);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + productId.hashCode();
        result = 31 * result + length.hashCode();
        result = 31 * result + thickness.hashCode();
        result = 31 * result + grade.hashCode();
        result = 31 * result + sanded.hashCode();
        result = 31 * result + waterResistance.hashCode();
        result = 31 * result + numberOfSheets.hashCode();
        result = 31 * result + numberOfPackages.hashCode();
        return result;
    }
}
