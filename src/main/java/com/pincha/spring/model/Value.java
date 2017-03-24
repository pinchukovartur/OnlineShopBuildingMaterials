package com.pincha.spring.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Value {

    private int idValue;
    private String value;
    private int productId;
    private int attributeId;
    private Attribute attribute;
    private Product product;

    @Id
    @Column(name = "idValue", unique = true, nullable = false, length = 11)
    public int getIdValue() {
        return idValue;
    }
    public void setIdValue(int idValue) {
        this.idValue = idValue;
    }

    @Basic
    @Column(name = "Value", unique = true, nullable = false, length = 11)
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "attributeId", unique = true, nullable = false, length = 11, insertable = false, updatable = false)
    public int getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    @Basic
    @Column(name = "productId", unique = true, nullable = false, length = 11)
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "attributeId")
    public Attribute getAttribute() {
        return attribute;
    }
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID",insertable = false,updatable = false) //////////------------------------------------
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Value value = (Value) o;
        return productId == value.productId && (this.value != null ? this.value.equals(value.value) : value.value == null);
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + productId;
        return result;
    }
}
