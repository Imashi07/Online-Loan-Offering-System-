package com.example.bumblebee.DAO;

import com.example.bumblebee.entity.Admins;
import com.example.bumblebee.entity.Users;
import com.example.bumblebee.repositories.UserRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersDAO {
    private UserRepo repo;

    public UsersDAO(UserRepo repo) {
        this.repo = repo;
    }

    public Users createUser(Users user){
        return repo.save(user);
    }

    public List<Users> getAllUsersFromEmailAndPassword(Users user){
        return repo.findByEmailAndPassword(user.getEmail(), user.getPassword());
    }

    public List<Users> getAllUsers(){
        return repo.findAll();
    }

    public Users getUserByID(Long id){
        return repo.findById(id).get();
    }
}
