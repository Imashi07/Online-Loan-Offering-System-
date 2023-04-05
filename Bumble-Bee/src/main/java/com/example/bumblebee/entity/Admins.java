package com.example.bumblebee.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class Admins implements UserDetails {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;
    private String email;
    private String name;
    private String password;
    private String createdDate;
    private String dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Roles role;

    public Admins() {
    }

    public Admins(Long id, String email, String name, String password, String createdDate, String dateOfBirth, Roles role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.createdDate = createdDate;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }

    public Admins(String email, String name, String password, String createdDate, String dateOfBirth, Roles role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.createdDate = createdDate;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
