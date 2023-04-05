package com.example.bumblebee.mappers;

import com.example.bumblebee.DTO.requestDTO.CreateCategoriesDTO;
import com.example.bumblebee.DTO.responseDTO.CategoriesDTO;
import com.example.bumblebee.entity.Categories;
import org.springframework.stereotype.Component;

@Component
public class CategoriesMapper {

    public CategoriesDTO entityToDTO(Categories category){
        return new CategoriesDTO(
                category.getId(),
                category.getName()
        );
    }

    public Categories dtoToEntityForCreate(CreateCategoriesDTO createCategoriesDTO){
        return new Categories(
                createCategoriesDTO.name()
        );
    }
}
