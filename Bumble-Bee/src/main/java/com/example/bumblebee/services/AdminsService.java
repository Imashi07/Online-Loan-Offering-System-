package com.example.bumblebee.services;

import com.example.bumblebee.DAO.AdminsDAO;
import com.example.bumblebee.DTO.requestDTO.RegistrationOrLoginAdminsDTO;
import com.example.bumblebee.DTO.responseDTO.AdminsDTO;
import com.example.bumblebee.DTO.responseDTO.TokenDTO;
import com.example.bumblebee.entity.Admins;
import com.example.bumblebee.entity.Roles;
import com.example.bumblebee.mappers.AdminsMapper;
import com.example.bumblebee.mappers.TokenMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminsService {
    private final AdminsDAO adminsDAO;
    private final AdminsMapper adminsMapper;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final TokenMapper tokenMapper;
    private final AuthenticationManager authenticationManager;

    public AdminsService(AdminsDAO adminsDAO, AdminsMapper adminsMapper, PasswordEncoder passwordEncoder, JWTService jwtService, TokenMapper tokenMapper, AuthenticationManager authenticationManager) {
        this.adminsDAO = adminsDAO;
        this.adminsMapper = adminsMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.tokenMapper = tokenMapper;
        this.authenticationManager = authenticationManager;
    }

    public TokenDTO createAdmin(RegistrationOrLoginAdminsDTO registrationOrLoginAdminsDTO){
        Admins admin = adminsMapper.dtoToEntityForRegOrLogin(registrationOrLoginAdminsDTO);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setRole(registrationOrLoginAdminsDTO.role());
        Admins createdAdmin = adminsDAO.createAdmin(admin);
        return  tokenMapper.tokenToDTO(
                jwtService.generateToken(admin),
                createdAdmin.getId(),
                createdAdmin.getEmail(),
                createdAdmin.getName(),
                createdAdmin.getCreatedDate(),
                createdAdmin.getDateOfBirth(),
                createdAdmin.getRole()
                );
    }

    public List<AdminsDTO> getAllAdmins(){
        return adminsDAO.getAllAdmins().stream().map(adminsMapper::EntityToDTO).toList();
    }

    public TokenDTO loginAdmin(RegistrationOrLoginAdminsDTO registrationOrLoginAdminsDTO){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        registrationOrLoginAdminsDTO.email(),
                        registrationOrLoginAdminsDTO.password()
                )
        );
        List<Admins> admins = adminsDAO.getAllAdminsByEmail(registrationOrLoginAdminsDTO.email());
        String token = jwtService.generateToken(admins.get(0));
        return tokenMapper.tokenToDTO(
                token,
                admins.get(0).getId(),
                admins.get(0).getEmail(),
                admins.get(0).getName(),
                admins.get(0).getCreatedDate(),
                admins.get(0).getDateOfBirth(),
                admins.get(0).getRole()
                );
    }
}
