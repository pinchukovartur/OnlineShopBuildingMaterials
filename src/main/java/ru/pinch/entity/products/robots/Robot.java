package ru.pinch.entity.products.robots;

import ru.pinch.entity.products.Product;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Robot")
@Table(name = "Product")
@DiscriminatorValue("Robot")
public class Robot extends Product{
    private String productId;
    private String model;
    private String manufacturer;
    private Integer productionYear;
    private String condition;
    private String axles;
    private Integer maxLoad;
    private Integer reach;
    private String footprint;
    private String repeatability;

    @Id
    @Column(name = "ProductID", nullable = false, length = 45)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "Model", nullable = true)
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "Manufacturer", nullable = true)
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "ProductionYear", nullable = true)
    public Integer getProductionYear() {
        return productionYear;
    }
    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    @Basic
    @Column(name = "Condition", nullable = true)
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name = "Axles", nullable = true)
    public String getAxles() {
        return axles;
    }
    public void setAxles(String axles) {
        this.axles = axles;
    }

    @Basic
    @Column(name = "MaxLoad", nullable = true)
    public Integer getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(Integer maxLoad) {
        this.maxLoad = maxLoad;
    }

    @Basic
    @Column(name = "Reach", nullable = true)
    public Integer getReach() {
        return reach;
    }
    public void setReach(Integer reach) {
        this.reach = reach;
    }

    @Basic
    @Column(name = "Footprint", nullable = true)
    public String getFootprint() {
        return footprint;
    }
    public void setFootprint(String footprint) {
        this.footprint = footprint;
    }

    @Basic
    @Column(name = "Repeatability", nullable = true)
    public String getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(String repeatability) {
        this.repeatability = repeatability;
    }
}
