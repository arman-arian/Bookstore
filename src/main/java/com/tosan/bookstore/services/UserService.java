package com.tosan.bookstore.services;

import com.tosan.bookstore.dtos.inputs.LoginInputDto;
import com.tosan.bookstore.dtos.outputs.LoginOutputDto;
import com.tosan.bookstore.exceptions.GeneralException;
import com.tosan.bookstore.models.User;
import com.tosan.bookstore.daos.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginOutputDto Login(LoginInputDto input) {
        try {
            User user = repository.findByUsername(input.getUsername());
            if (user == null) {
                throw new GeneralException("1000", "User not found!");
            }

            if (!user.getActive()) {
                throw new GeneralException("1001", "User is not active!");
            }

            if (passwordEncoder.matches(input.getPassword(), user.getPassword())) {
                var output = new LoginOutputDto();
                output.setId(user.getId());
                output.setUsername(user.getUsername());
                output.setUserType(user.getUserType());
                output.setName(user.getName());
                output.setEmail(user.getEmail());

                return output;
            } else {
                throw new GeneralException("1002", "Invalid Username or password");
            }
        } catch (Exception ex) {
            throw new GeneralException("1003", "Login Error", ex);
        }
    }
}
