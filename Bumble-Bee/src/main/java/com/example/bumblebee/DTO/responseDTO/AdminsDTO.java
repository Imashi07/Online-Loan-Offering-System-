package com.example.bumblebee.DTO.responseDTO;

public record AdminsDTO(
        Long id,
        String email,
        String name,
        String createdDate,
        String dateOfBirth
) {
}
