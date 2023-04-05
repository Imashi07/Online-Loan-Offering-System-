package com.example.bumblebee.controllers;

import com.example.bumblebee.DTO.requestDTO.CreatePurchaseOrderDTO;
import com.example.bumblebee.DTO.requestDTO.RegistrationOrLoginUsersDTO;
import com.example.bumblebee.DTO.responseDTO.PurchaseLoanOrdersDTO;
import com.example.bumblebee.DTO.responseDTO.UsersDTO;
import com.example.bumblebee.services.PurchaseOrderService;
import com.example.bumblebee.services.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/users")
public class UsersController {

    private UsersService usersService;
    private PurchaseOrderService purchaseOrderService;

    public UsersController(UsersService usersService, PurchaseOrderService purchaseOrderService) {
        this.usersService = usersService;
        this.purchaseOrderService = purchaseOrderService;
    }

    @PostMapping(path = "/create")
    public UsersDTO createUser(@RequestBody RegistrationOrLoginUsersDTO registrationOrLoginUsersDTO){
        return usersService.createUser(registrationOrLoginUsersDTO);
    }

    @GetMapping(path = "/login")
    public UsersDTO loginUser(@RequestBody RegistrationOrLoginUsersDTO registrationOrLoginUsersDTO) {
        return usersService.loginUser(registrationOrLoginUsersDTO);
    }

    @GetMapping(path = "/all")
    public List<UsersDTO> getAllUsers(){
        return usersService.getAllUsers();
    }

    @PostMapping("/createloanorder")
    public PurchaseLoanOrdersDTO createPurchaseOrder(@RequestBody CreatePurchaseOrderDTO createPurchaseOrderDTO){
        return purchaseOrderService.createPurchaseOrder(createPurchaseOrderDTO);
    }
}
