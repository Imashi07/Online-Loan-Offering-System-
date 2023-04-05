package com.example.bumblebee.services;

import com.example.bumblebee.DAO.UsersDAO;
import com.example.bumblebee.DTO.requestDTO.RegistrationOrLoginUsersDTO;
import com.example.bumblebee.DTO.responseDTO.UsersDTO;
import com.example.bumblebee.entity.Users;
import com.example.bumblebee.mappers.UsersMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private UsersDAO usersDAO;
    private UsersMapper usersMapper;

    public UsersService(UsersDAO usersDAO, UsersMapper usersMapper) {
        this.usersDAO = usersDAO;
        this.usersMapper = usersMapper;
    }

    public UsersDTO createUser(RegistrationOrLoginUsersDTO registrationOrLoginUsersDTO){
        return usersMapper.entityToDTO(usersDAO.createUser(usersMapper.dtoToEntityForRegOrLogin(registrationOrLoginUsersDTO)));
    }

    public UsersDTO loginUser(RegistrationOrLoginUsersDTO registrationOrLoginUsersDTO){
        List<Users> users = usersDAO.getAllUsersFromEmailAndPassword(usersMapper.dtoToEntityForRegOrLogin(registrationOrLoginUsersDTO));
        if(users.isEmpty()){
            return null;
        }else{
            return usersMapper.entityToDTO(users.get(0));
        }
    }

    public List<UsersDTO> getAllUsers(){
        return usersDAO.getAllUsers().stream().map(usersMapper::entityToDTO).toList();
    }
}


