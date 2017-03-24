package com.pincha.spring.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Catalog {

    private int idCatalog;
    private String catalogName;
    private List<Category> categoryList;

    @Id
    @Column(name = "idCatalog", unique = true, nullable = false, length = 11)
    public int getIdCatalog() {
        return idCatalog;
    }
    public void setIdCatalog(int idCatalog) {
        this.idCatalog = idCatalog;
    }

    @Basic
    @Column(name = "CatalogName", unique = true, nullable = false, length = 45)
    public String getCatalogName() {
        return catalogName;
    }
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "catalog", cascade = CascadeType.ALL)
    public List<Category> getCategoryList() {
        return this.categoryList;
    }
    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return idCatalog == catalog.idCatalog && (catalogName != null ? catalogName.equals(catalog.catalogName) : catalog.catalogName == null);
    }

    @Override
    public int hashCode() {
        int result = idCatalog;
        result = 31 * result + (catalogName != null ? catalogName.hashCode() : 0);
        return result;
    }
}
