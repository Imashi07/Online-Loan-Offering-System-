package com.example.bumblebee.DAO;

import com.example.bumblebee.entity.Admins;
import com.example.bumblebee.repositories.AdminRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminsDAO {
    private final AdminRepo repo;

    public AdminsDAO(AdminRepo repo) {
        this.repo = repo;
    }

    public Admins createAdmin(Admins admin){
        return repo.save(admin);
    }

    public List<Admins> getAllAdmins(){
        return repo.findAll();
    }

    public  List<Admins> getAllAdminsByEmail(String email){ return repo.findByEmail(email); }

}
