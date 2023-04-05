package com.example.bumblebee.services;

import com.example.bumblebee.DAO.AdminsDAO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JWTUserDetailsService implements UserDetailsService {
    private AdminsDAO adminsDAO;

    public JWTUserDetailsService(AdminsDAO adminsDAO) {
        this.adminsDAO = adminsDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminsDAO.getAllAdminsByEmail(username).get(0);
    }
}
