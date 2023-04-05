package com.example.bumblebee.DAO;

import com.example.bumblebee.entity.Categories;
import com.example.bumblebee.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriesDAO {
    private CategoryRepo repo;

    public CategoriesDAO(CategoryRepo repo) {
        this.repo = repo;
    }

    public Categories createCategory(Categories category){
        return repo.save(category);
    }

    public List<Categories> getAllCategories(){
        return repo.findAll();
    }

    public Categories getCategoryByID(Long id){
        return repo.findById(id).get();
    }
}
