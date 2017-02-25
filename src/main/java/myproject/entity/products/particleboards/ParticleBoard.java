package myproject.entity.products.particleboards;



import myproject.entity.products.Product;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ParticleBoard")
@Table(name = "Product")
@DiscriminatorValue("ParticleBoard")
public class ParticleBoard extends Product {
    private String productId;
    private Integer length;
    private Integer thickness;
    private String color;
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
    @Column(name = "Color", nullable = true, length = 45)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

        ParticleBoard that = (ParticleBoard) o;

        if (!productId.equals(that.productId)) return false;
        if (!length.equals(that.length)) return false;
        if (!thickness.equals(that.thickness)) return false;
        if (!color.equals(that.color)) return false;
        if (!numberOfSheets.equals(that.numberOfSheets)) return false;
        return numberOfPackages.equals(that.numberOfPackages);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + productId.hashCode();
        result = 31 * result + length.hashCode();
        result = 31 * result + thickness.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + numberOfSheets.hashCode();
        result = 31 * result + numberOfPackages.hashCode();
        return result;
    }
}
