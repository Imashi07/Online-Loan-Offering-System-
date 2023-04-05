package com.example.bumblebee.DTO.requestDTO;

import com.example.bumblebee.entity.Roles;

public record RegistrationOrLoginAdminsDTO(
        String email,
        String name,
        String password,
        String createdDate,
        String dateOfBirth,
        Roles role
) {
}
