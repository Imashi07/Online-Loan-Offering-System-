package com.example.bumblebee.repositories;

import com.example.bumblebee.entity.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsRepo extends JpaRepository<Brands, Long> {
}
