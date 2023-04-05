package com.example.bumblebee.repositories;

import com.example.bumblebee.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Categories, Long> {
}
