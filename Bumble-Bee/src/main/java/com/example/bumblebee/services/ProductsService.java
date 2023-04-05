package com.example.bumblebee.services;

import com.example.bumblebee.DAO.ProductsDAO;
import com.example.bumblebee.DTO.requestDTO.CreateProductsDTO;
import com.example.bumblebee.DTO.responseDTO.BrandsDTO;
import com.example.bumblebee.DTO.responseDTO.CategoriesDTO;
import com.example.bumblebee.DTO.responseDTO.ProductsDTO;
import com.example.bumblebee.mappers.BrandsMapper;
import com.example.bumblebee.mappers.CategoriesMapper;
import com.example.bumblebee.mappers.ProductsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsDAO productsDAO;
    private ProductsMapper productsMapper;
    private CategoriesMapper categoriesMapper;
    private BrandsMapper brandsMapper;

    public ProductsService(ProductsDAO productsDAO, ProductsMapper productsMapper, CategoriesMapper categoriesMapper, BrandsMapper brandsMapper) {
        this.productsDAO = productsDAO;
        this.productsMapper = productsMapper;
        this.categoriesMapper = categoriesMapper;
        this.brandsMapper = brandsMapper;
    }

    public ProductsDTO createProduct(CreateProductsDTO createProductsDTO){
        return productsMapper.EntityToDTO(productsDAO.createProduct(productsMapper.dtoToEntityForCreate(createProductsDTO)));
    }

    public CategoriesDTO getRelatedCategoryOfTheProductByID(Long id){
        return categoriesMapper.entityToDTO(productsDAO.getProductByID(id).getCategory());
    }

    public BrandsDTO getRelatedBrandOfTheProductByID(Long id){
        return brandsMapper.entityToDTO(productsDAO.getProductByID(id).getBrand());
    }

    public List<ProductsDTO> getAllProducts(){
        return productsDAO.getAllProducts().stream().map(productsMapper::EntityToDTO).toList();
    }
}
