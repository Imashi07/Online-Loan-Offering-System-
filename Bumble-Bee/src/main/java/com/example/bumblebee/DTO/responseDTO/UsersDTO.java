package com.example.bumblebee.DTO.responseDTO;

public record UsersDTO(
        Long id,
        String email,
        String name,
        String createdDate,
        String dateOfBirth,
        float LoanBalance
) {
}
