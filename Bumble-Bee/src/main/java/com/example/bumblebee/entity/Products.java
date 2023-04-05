package com.example.bumblebee.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Products {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;
    private String name;
    private float price;
    @OneToMany(targetEntity = PurchaseLoanOrders.class, mappedBy ="product", fetch = FetchType.LAZY)
    private List<PurchaseLoanOrders> orders;
    @ManyToOne(targetEntity = Categories.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Categories category;
    @ManyToOne(targetEntity = Brands.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brands brand;

    public Products() {
    }

    public Products(String name, float price, List<PurchaseLoanOrders> orders, Categories category, Brands brand) {
        this.name = name;
        this.price = price;
        this.orders = orders;
        this.category = category;
        this.brand = brand;
    }

    public Products(String name, Brands brand, Categories category) {
        this.name = name;
        this.category = category;
        this.brand = brand;
    }

    public Products(String name, float price, Brands brand, Categories category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<PurchaseLoanOrders> getOrders() {
        return orders;
    }

    public void setOrders(List<PurchaseLoanOrders> orders) {
        this.orders = orders;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }
}
