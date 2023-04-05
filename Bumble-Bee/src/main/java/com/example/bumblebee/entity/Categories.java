package com.example.bumblebee.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categories {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(targetEntity = Products.class, mappedBy = "category", fetch = FetchType.LAZY)
    private List<Products> products;

    public Categories() {
    }

    public Categories(String name, List<Products> products) {
        this.name = name;
        this.products = products;
    }

    public Categories(String name) {
        this.name = name;
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

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
