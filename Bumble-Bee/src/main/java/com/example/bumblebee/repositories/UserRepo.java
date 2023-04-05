package com.example.bumblebee.repositories;

import com.example.bumblebee.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<Users, Long> {
    List<Users> findByEmailAndPassword(String email, String password);
}
