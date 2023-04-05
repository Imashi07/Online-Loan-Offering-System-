package com.example.bumblebee.mappers;

import com.example.bumblebee.DTO.requestDTO.RegistrationOrLoginAdminsDTO;
import com.example.bumblebee.DTO.responseDTO.AdminsDTO;
import com.example.bumblebee.entity.Admins;
import org.springframework.stereotype.Component;

@Component
public class AdminsMapper {
    public Admins dtoToEntityForRegOrLogin(RegistrationOrLoginAdminsDTO registrationOrLoginForAdminsDTO) {
        return new Admins(
                registrationOrLoginForAdminsDTO.email(),
                registrationOrLoginForAdminsDTO.name(),
                registrationOrLoginForAdminsDTO.password(),
                registrationOrLoginForAdminsDTO.createdDate(),
                registrationOrLoginForAdminsDTO.dateOfBirth(),
                registrationOrLoginForAdminsDTO.role()
        );
    }
    public AdminsDTO EntityToDTO(Admins admins) {
        return new AdminsDTO(
                admins.getId(),
                admins.getEmail(),
                admins.getName(),
                admins.getCreatedDate(),
                admins.getDateOfBirth()
        );
    }
}
