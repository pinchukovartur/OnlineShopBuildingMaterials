package com.pincha.spring.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Category {

    private String categoryName;
    private int idCategory;
    private int catalogID;
    private Catalog catalog;
    private Set<Product> productSet;
    private Set<Attribute> attributes;

    @Id
    @Column(name = "idCategory", unique = true, nullable = false, length = 45)
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Basic
    @Column(name = "CategoryName", unique = true, nullable = false, length = 45)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    @Basic
    @Column(name = "CatalogID", unique = true, nullable = false, length = 45)
    public int getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(int catalogID) {
        this.catalogID = catalogID;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "catalogID")
    public Catalog getCatalog() {
        return catalog;
    }
    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    public Set<Product> getProductSet() {
        return this.productSet;
    }
    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "CategoryAttribute",
            joinColumns = {@JoinColumn(name = "categoryID")},
            inverseJoinColumns = {@JoinColumn(name = "AttributeID")})
    public Set<Attribute> getAttributes() {
        return attributes;
    }
    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (idCategory != category.idCategory) return false;
        if (categoryName != null ? !categoryName.equals(category.categoryName) : category.categoryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryName != null ? categoryName.hashCode() : 0;
        result = 31 * result + idCategory;
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", idCategory=" + idCategory +
                ", catalogID=" + catalogID +
                ", catalog=" + catalog +
                ", productSet=" + productSet +
                ", attributes=" + attributes +
                '}';
    }
}
