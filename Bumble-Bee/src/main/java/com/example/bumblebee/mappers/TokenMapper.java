package com.example.bumblebee.mappers;


import com.example.bumblebee.DTO.responseDTO.TokenDTO;
import com.example.bumblebee.entity.Roles;
import org.springframework.stereotype.Component;

@Component
public class TokenMapper {
    public TokenDTO tokenToDTO(String token, Long id, String email, String name, String createdDate, String dateOfBirth, Roles role){
        return new TokenDTO(
            token,
            id,
            email,
            name,
            createdDate,
            dateOfBirth,
            role
        );
    }
}
