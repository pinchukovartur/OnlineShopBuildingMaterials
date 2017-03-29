package com.pincha.spring.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Value {

    private int idValue;
    private String value;
    private Attribute attribute;
    private Product product;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "iDValue", unique = true, length = 11)
    public int getIdValue() {
        return idValue;
    }
    public void setIdValue(int idValue) {
        this.idValue = idValue;
    }

    @Basic
    @Column(name = "value", unique = true, nullable = false, length = 11)
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "attributeId")
    public Attribute getAttribute() {
        return attribute;
    }
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Value{" +
                "idValue=" + idValue +
                ", value='" + value + '\'' +
                ", attribute=" + attribute +
                ", product=" + product +
                '}';
    }
}
