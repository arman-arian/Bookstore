package com.tosan.bookstore.services;

import com.tosan.bookstore.dtos.inputs.*;
import com.tosan.bookstore.dtos.outputs.*;
import com.tosan.bookstore.exceptions.GeneralException;
import com.tosan.bookstore.models.*;
import com.tosan.bookstore.daos.UserRepository;
import com.tosan.bookstore.utils.enums.EnumUtils;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {
    private final UserRepository repository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public Map<Integer, String> GetUserTypes() {
        return EnumUtils.GetEnumDescriptions(UserType.class);
    }

    public UserOutputDto GetUser(Long id) {
        try {
            User user = repository.findById(id).orElse(null);
            if (user == null)
                throw new GeneralException("1000", "User not exists");
            return modelMapper.map(user, UserOutputDto.class);
        } catch (Exception ex) {
            throw new GeneralException("1003", "GetUser Error", ex);
        }
    }

    public List<UserOutputDto> GetUsers() {
        try {
            List<UserOutputDto> outputDto = new ArrayList<>();
            List<User> users = (List<User>) repository.findAll();
            for (User user : users) {
                outputDto.add(modelMapper.map(user, UserOutputDto.class));
            }

            return outputDto;
        } catch (Exception ex) {
            throw new GeneralException("1003", "GetUsers Error", ex);
        }
    }

    public void Register(UserInputDto inputDto) {
        try {
            var user = modelMapper.map(inputDto, User.class);
            user.setPassword(passwordEncoder.encode(inputDto.getPassword()));
            user.setActive(true);

            repository.save(user);
        } catch (Exception ex) {
            throw new GeneralException("1003", "Register Error", ex);
        }
    }

    public LoginOutputDto Login(LoginInputDto inputDto) {
        try {
            User user = repository.findByUsername(inputDto.getUsername());
            if (user == null) {
                throw new GeneralException("1000", "User not found!");
            }

            if (!user.getActive()) {
                throw new GeneralException("1001", "User is not active!");
            }

            if (passwordEncoder.matches(inputDto.getPassword(), user.getPassword())) {
                var outputDto = modelMapper.map(user, LoginOutputDto.class);
                user.setLastLoginDate(LocalDateTime.now());
                repository.save(user);
                return outputDto;
            } else {
                throw new GeneralException("1002", "Invalid Username or password");
            }
        } catch (Exception ex) {
            throw new GeneralException("1003", "Login Error", ex);
        }
    }

    public void ChangePassword(ChangePasswordInputDto inputDto) {
        try {
            if (passwordEncoder.matches(inputDto.getOldPassword(), inputDto.getNewPassword())) {
                throw new GeneralException("1001", "New password is similar to old password");
            }

            User user = repository.findByUsername(inputDto.getUsername());
            if (user == null) {
                throw new GeneralException("1000", "User not found!");
            }

            if (!user.getActive()) {
                throw new GeneralException("1001", "User is not active!");
            }

            if (passwordEncoder.matches(inputDto.getOldPassword(), user.getPassword())) {
                user.setPassword(inputDto.getNewPassword());
                repository.save(user);
            } else {
                throw new GeneralException("1002", "Invalid Username or password");
            }
        } catch (Exception ex) {
            throw new GeneralException("1003", "ChangePassword Error", ex);
        }
    }

    public void ResetPassword(ResetPasswordInputDto inputDto) {
        try {
            User user = repository.findByUsername(inputDto.getUsername());
            if (user == null) {
                throw new GeneralException("1000", "User not found!");
            }

            if (!user.getActive()) {
                throw new GeneralException("1001", "User is not active!");
            }

            user.setPassword(inputDto.getNewPassword());
            repository.save(user);
        } catch (Exception ex) {
            throw new GeneralException("1003", "ChangePassword Error", ex);
        }
    }
}
