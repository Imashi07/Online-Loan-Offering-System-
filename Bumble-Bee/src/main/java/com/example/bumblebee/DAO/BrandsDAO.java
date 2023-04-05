package com.example.bumblebee.DAO;

import com.example.bumblebee.entity.Brands;
import com.example.bumblebee.repositories.BrandsRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandsDAO {
    private BrandsRepo repo;

    public BrandsDAO(BrandsRepo repo) {
        this.repo = repo;
    }

    public Brands createBrand(Brands brand){
        return repo.save(brand);
    }

    public List<Brands> getAllBrands(){
        return repo.findAll();
    }

    public Brands getBrandByID(Long id){
        return repo.findById(id).get();
    }
}
