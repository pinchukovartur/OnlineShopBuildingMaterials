package ru.pinch.entity.products.robots;

import ru.pinch.entity.products.Product;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
@DiscriminatorValue("Robot")
public class Robot extends Product{
    private String productId;
    private String model;
    private String manufacturer;
    private Integer productionYear;
    private String axles;
    private Integer maxLoad;
    private Integer reach;
    private String footprint;
    private String repeatability;
    private String condition;

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
    @Column(name = "RobotCondition", nullable = true)
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
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Robot myRobot = (Robot) o;

        if (!productId.equals(myRobot.productId)) return false;
        if (!model.equals(myRobot.model)) return false;
        if (!manufacturer.equals(myRobot.manufacturer)) return false;
        if (!productionYear.equals(myRobot.productionYear)) return false;
        if (!condition.equals(myRobot.condition)) return false;
        if (!axles.equals(myRobot.axles)) return false;
        if (!maxLoad.equals(myRobot.maxLoad)) return false;
        if (!reach.equals(myRobot.reach)) return false;
        if (!footprint.equals(myRobot.footprint)) return false;
        return repeatability.equals(myRobot.repeatability);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + productId.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + manufacturer.hashCode();
        result = 31 * result + productionYear.hashCode();
        result = 31 * result + condition.hashCode();
        result = 31 * result + axles.hashCode();
        result = 31 * result + maxLoad.hashCode();
        result = 31 * result + reach.hashCode();
        result = 31 * result + footprint.hashCode();
        result = 31 * result + repeatability.hashCode();
        return result;
    }*/
}
