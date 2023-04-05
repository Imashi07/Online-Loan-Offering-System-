package com.example.bumblebee.DTO.responseDTO;

public record PurchaseLoanOrdersDTO(
        Long id,
        float loanAmount,
        String createdDate
) {
}
