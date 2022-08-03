package com.tosan.bookstore.dtos;

import com.tosan.bookstore.models.UserType;

import java.time.LocalDateTime;

public class UserDto {
    private Long id;

    private String username;

    private String name;

    private String email;

    private UserType userType;

    private LocalDateTime creationDate;

    private LocalDateTime lastLoginDate;

    public UserDto(){

    }

    public UserDto(Long id, String username, String name, String email, UserType userType, LocalDateTime creationDate, LocalDateTime lastLoginDate) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.creationDate = creationDate;
        this.lastLoginDate = lastLoginDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
