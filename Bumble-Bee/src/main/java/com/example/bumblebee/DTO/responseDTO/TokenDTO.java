package com.example.bumblebee.DTO.responseDTO;

import com.example.bumblebee.entity.Roles;

public record TokenDTO(
        String token,
        Long id,
        String email,
        String name,
        String createdDate,
        String dateOfBirth,
        Roles role
) {
}
