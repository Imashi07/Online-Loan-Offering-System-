package com.example.bumblebee.mappers;

import com.example.bumblebee.DTO.requestDTO.CreateProductsDTO;
import com.example.bumblebee.DTO.responseDTO.ProductsDTO;
import com.example.bumblebee.entity.Products;
import org.springframework.stereotype.Component;

@Component
public class ProductsMapper {

    public Products dtoToEntityForCreate(CreateProductsDTO createProductsDTO){
        return new Products(
            createProductsDTO.name(),
            createProductsDTO.price(),
            createProductsDTO.brand(),
            createProductsDTO.category()
        );
    }

    public ProductsDTO EntityToDTO(Products product){
        return new ProductsDTO(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
