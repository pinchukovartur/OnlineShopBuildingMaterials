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
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
public class Attribute {

    private int idAttribute;
    private String attributeName;
    private Set<Category> categories;
    private Set<Value> values;

    @Id
    @Column(name = "idAttribute", unique = true, nullable = false, length = 11)
    public int getIdAttribute() {
        return idAttribute;
    }
    public void setIdAttribute(int idAttribute) {
        this.idAttribute = idAttribute;
    }

    @Basic
    @Column(name = "AttributeName", unique = true, nullable = false, length = 11)
    public String getAttributeName() {
        return attributeName;
    }
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "attributes")
    public Set<Category> getProducts() {
        return categories;
    }
    public void setProducts(Set<Category> categories) {
        this.categories = categories;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "attribute", cascade = CascadeType.ALL)
    public Set<Value> getValues() {
        return values;
    }
    public void setValues(Set<Value> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attribute attribute = (Attribute) o;

        if (idAttribute != attribute.idAttribute) return false;
        if (attributeName != null ? !attributeName.equals(attribute.attributeName) : attribute.attributeName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAttribute;
        result = 31 * result + (attributeName != null ? attributeName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "idAttribute=" + idAttribute +
                ", attributeName='" + attributeName + '\'' +
                ", categories=" + categories +
                ", values=" + values +
                '}';
    }
}
