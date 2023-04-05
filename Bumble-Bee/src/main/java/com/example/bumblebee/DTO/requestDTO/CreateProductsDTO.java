package com.example.bumblebee.DTO.requestDTO;

import com.example.bumblebee.entity.Brands;
import com.example.bumblebee.entity.Categories;

public record CreateProductsDTO(
        String name,
        float price,
        Categories category,
        Brands brand
) {
}
