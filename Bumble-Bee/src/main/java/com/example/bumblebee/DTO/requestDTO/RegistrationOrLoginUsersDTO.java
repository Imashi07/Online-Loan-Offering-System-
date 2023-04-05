package com.example.bumblebee.DTO.requestDTO;

public record RegistrationOrLoginUsersDTO(
        String email,
        String name,
        String password,
        String createdDate,
        String dateOfBirth
) {
}
