package com.pincha.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
public class UserRole {
    private String username;
    private String role;
    private User user;

    public UserRole(){

    }
    public UserRole(String username, String role){
        this.username = username;
        this.role = role;
    }

    @Id
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "UserRole", nullable = false, length = 45)
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
