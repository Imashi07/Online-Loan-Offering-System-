package com.example.bumblebee.mappers;

import com.example.bumblebee.DTO.requestDTO.CreateBrandsDTO;
import com.example.bumblebee.DTO.responseDTO.BrandsDTO;
import com.example.bumblebee.entity.Brands;
import org.springframework.stereotype.Component;

@Component
public class BrandsMapper {
    public BrandsDTO entityToDTO(Brands brand){
        return new BrandsDTO(
                brand.getId(),
                brand.getName()
        );
    }

    public Brands dtoToEntityForCreate(CreateBrandsDTO createBrandsDTO){
        return new Brands(
                createBrandsDTO.name()
        );
    }
}
