package ru.pinch.entity;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase", schema = "buildingonlineshop")
public class Purchase {
    private int idPurchase;
    private String productID;
    private int quantity;
    private String username;
    private String email;
    private String date;

    @Id
    @Column(name = "id_purchase", nullable = false, length = 5)
    public int getIdPurchase() {
        return idPurchase;
    }
    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    @Basic
    @Column(name = "productName", nullable = false, length = 45)
    public String getProductID() {
        return productID;
    }
    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Basic
    @Column(name = "quantity", nullable = false, length = 6)
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "date", nullable = false, length = 45)
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (idPurchase != purchase.idPurchase) return false;
        if (quantity != purchase.quantity) return false;
        if (!productID.equals(purchase.productID)) return false;
        if (!username.equals(purchase.username)) return false;
        if (!email.equals(purchase.email)) return false;
        return date.equals(purchase.date);
    }

    @Override
    public int hashCode() {
        int result = idPurchase;
        result = 31 * result + productID.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + username.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
