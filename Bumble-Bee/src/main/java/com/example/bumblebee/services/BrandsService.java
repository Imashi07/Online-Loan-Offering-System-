package com.example.bumblebee.services;

import com.example.bumblebee.DAO.BrandsDAO;
import com.example.bumblebee.DTO.requestDTO.CreateBrandsDTO;
import com.example.bumblebee.DTO.responseDTO.BrandsDTO;
import com.example.bumblebee.mappers.BrandsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandsService {
    private BrandsDAO brandsDAO;
    private BrandsMapper brandsMapper;

    public BrandsService(BrandsDAO brandsDAO, BrandsMapper brandsMapper) {
        this.brandsDAO = brandsDAO;
        this.brandsMapper = brandsMapper;
    }

    public BrandsDTO createBrand(CreateBrandsDTO createBrandsDTO){
        return brandsMapper.entityToDTO(brandsDAO.createBrand(brandsMapper.dtoToEntityForCreate(createBrandsDTO)));
    }

    public List<BrandsDTO> getAllBrands(){
        return brandsDAO.getAllBrands().stream().map(brandsMapper::entityToDTO).toList();
    }

    public BrandsDTO getBrandByID(Long id){
        return brandsMapper.entityToDTO(brandsDAO.getBrandByID(id));
    }
}
