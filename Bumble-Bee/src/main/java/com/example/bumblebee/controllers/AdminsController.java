package com.example.bumblebee.controllers;

import com.example.bumblebee.DTO.requestDTO.CreateBrandsDTO;
import com.example.bumblebee.DTO.requestDTO.CreateCategoriesDTO;
import com.example.bumblebee.DTO.requestDTO.CreateProductsDTO;
import com.example.bumblebee.DTO.requestDTO.RegistrationOrLoginAdminsDTO;
import com.example.bumblebee.DTO.responseDTO.*;
import com.example.bumblebee.services.AdminsService;
import com.example.bumblebee.services.BrandsService;
import com.example.bumblebee.services.CategoriesService;
import com.example.bumblebee.services.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/admins")
public class AdminsController {

    private final AdminsService adminsService;
    private CategoriesService categoriesService;
    private BrandsService brandsService;
    private ProductsService productsService;

    public AdminsController(AdminsService adminsService, CategoriesService categoriesService, BrandsService brandsService, ProductsService productsService) {
        this.adminsService = adminsService;
        this.categoriesService = categoriesService;
        this.brandsService = brandsService;
        this.productsService = productsService;
    }

    @PostMapping(path = "/create")
    public TokenDTO createAdmin(@RequestBody RegistrationOrLoginAdminsDTO registrationOrLoginAdminsDTO){
        return adminsService.createAdmin(registrationOrLoginAdminsDTO);
    }

    @PostMapping(path = "/login")
    public TokenDTO loginAdmin(@RequestBody RegistrationOrLoginAdminsDTO registrationOrLoginAdminsDTO){
        System.out.println(registrationOrLoginAdminsDTO.email());
        return adminsService.loginAdmin(registrationOrLoginAdminsDTO);
    }

    @GetMapping(path = "/all")
    public List<AdminsDTO> getAllAdmins(){
        return adminsService.getAllAdmins();
    }

    @PostMapping(path = "/categories/create")
    public CategoriesDTO createCategory(@RequestBody CreateCategoriesDTO createCategoriesDTO){
        return categoriesService.createCategory(createCategoriesDTO);
    }

    @GetMapping(path = "/categories/all")
    public List<CategoriesDTO> getAllCategories(){
        return categoriesService.getAllCategories();
    }

    @GetMapping(path = "/categories/{id}")
    public CategoriesDTO getCategoryByID(@PathVariable Long id){
        return categoriesService.getCategoryByID(id);
    }

    @PostMapping(path = "/brands/create")
    public BrandsDTO createBrand(@RequestBody CreateBrandsDTO createBrandsDTO){
        return brandsService.createBrand(createBrandsDTO);
    }

    @GetMapping(path = "/brands/all")
    public List<BrandsDTO> getAllBrands(){
        return brandsService.getAllBrands();
    }

    @GetMapping(path = "/brands/{id}")
    public BrandsDTO getBrandByID(@PathVariable Long id){
        return brandsService.getBrandByID(id);
    }

    @PostMapping(path = "/products/create")
    public ProductsDTO createProduct(@RequestBody CreateProductsDTO createProductsDTO){
        return productsService.createProduct(createProductsDTO);
    }

    @GetMapping(path = "/products/all")
    public List<ProductsDTO> getAllProducts(){
        return productsService.getAllProducts();
    }

    @GetMapping(path = "/categories/products/{id}")
    public List<ProductsDTO> getProductListOfCategoryByID(@PathVariable Long id){
        return categoriesService.getProductsListOfCategoryByID(id);
    }

    @GetMapping(path = "/products/productbrand/{id}")
    public BrandsDTO getRelatedBrandOfProduct(@PathVariable Long id){
        return productsService.getRelatedBrandOfTheProductByID(id);
    }

    @GetMapping(path = "/products/productcategory/{id}")
    public CategoriesDTO getRelatedCategoryOfProduct(@PathVariable Long id){
        return productsService.getRelatedCategoryOfTheProductByID(id);
    }

}
