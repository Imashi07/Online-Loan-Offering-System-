package com.example.bumblebee.DAO;

import com.example.bumblebee.entity.Products;
import com.example.bumblebee.repositories.ProductRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsDAO {
    private ProductRepo repo;

    public ProductsDAO(ProductRepo repo) {
        this.repo = repo;
    }

    public Products createProduct(Products product){
        return repo.save(product);
    }

    public Products getProductByID(Long id){
        return repo.findById(id).get();
    }

    public List<Products> getAllProducts(){
        return repo.findAll();
    }
}
