package com.example.bumblebee.mappers;

import com.example.bumblebee.DTO.requestDTO.RegistrationOrLoginUsersDTO;
import com.example.bumblebee.DTO.responseDTO.UsersDTO;
import com.example.bumblebee.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {
    public Users dtoToEntityForRegOrLogin(RegistrationOrLoginUsersDTO registrationOrLoginUsersDTO){
        return new Users(
                registrationOrLoginUsersDTO.email(),
                registrationOrLoginUsersDTO.name(),
                registrationOrLoginUsersDTO.password(),
                registrationOrLoginUsersDTO.createdDate(),
                registrationOrLoginUsersDTO.dateOfBirth()
        );
    }

    public UsersDTO entityToDTO(Users user){
        return new UsersDTO(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getCreatedDate(),
                user.getDateOfBirth(),
                user.getLoanBalance()

        );
    }
}
