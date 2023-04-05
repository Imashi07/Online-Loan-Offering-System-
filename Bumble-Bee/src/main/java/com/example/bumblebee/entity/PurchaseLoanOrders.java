package com.example.bumblebee.entity;

import jakarta.persistence.*;

import java.lang.annotation.Target;

@Entity
public class PurchaseLoanOrders {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;
    private float LoanAmount;
    private String createdDate;
    @ManyToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_ID", referencedColumnName = "id")
    private Users user;
    @ManyToOne(targetEntity = Products.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_ID", referencedColumnName = "id")
    private Products product;

    public PurchaseLoanOrders() {
    }

    public PurchaseLoanOrders(float loanAmount, String createdDate, Users user, Products product) {
        LoanAmount = loanAmount;
        this.createdDate = createdDate;
        this.user = user;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public float getLoanAmount() {
        return LoanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        LoanAmount = loanAmount;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
