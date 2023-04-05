package com.example.bumblebee.repositories;

import com.example.bumblebee.entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepo extends JpaRepository<Admins, String> {
    List<Admins> findByEmail(String email);
}
