package com.example.bumblebee.repositories;

import com.example.bumblebee.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products, Long> {
}
