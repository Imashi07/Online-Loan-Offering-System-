package com.example.bumblebee.DTO.requestDTO;

import com.example.bumblebee.entity.Products;
import com.example.bumblebee.entity.Users;

public record CreatePurchaseOrderDTO(
        String createdDate,
        float loanAmount,
        Users user,
        Products product
) {
}
