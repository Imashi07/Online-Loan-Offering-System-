package com.example.bumblebee.services;

import com.example.bumblebee.DAO.CategoriesDAO;
import com.example.bumblebee.DTO.requestDTO.CreateCategoriesDTO;
import com.example.bumblebee.DTO.responseDTO.CategoriesDTO;
import com.example.bumblebee.DTO.responseDTO.ProductsDTO;
import com.example.bumblebee.entity.Categories;
import com.example.bumblebee.mappers.CategoriesMapper;
import com.example.bumblebee.mappers.ProductsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    private CategoriesDAO categoriesDAO;
    private CategoriesMapper categoriesMapper;
    private ProductsMapper productsMapper;

    public CategoriesService(CategoriesDAO categoriesDAO, CategoriesMapper categoriesMapper, ProductsMapper productsMapper) {
        this.categoriesDAO = categoriesDAO;
        this.categoriesMapper = categoriesMapper;
        this.productsMapper = productsMapper;
    }

    public CategoriesDTO createCategory(CreateCategoriesDTO createCategoriesDTO){
       Categories category = categoriesMapper.dtoToEntityForCreate(createCategoriesDTO);

       return categoriesMapper.entityToDTO(categoriesDAO.createCategory(category));
    }

    public List<CategoriesDTO> getAllCategories(){
        return categoriesDAO.getAllCategories().stream().map(categoriesMapper::entityToDTO).toList();
    }

    public CategoriesDTO getCategoryByID(Long id){
        return categoriesMapper.entityToDTO(categoriesDAO.getCategoryByID(id));
    }

    public List<ProductsDTO> getProductsListOfCategoryByID(Long id){
        return categoriesDAO.getCategoryByID(id).getProducts().stream().map(productsMapper::EntityToDTO).toList();
    }
}
