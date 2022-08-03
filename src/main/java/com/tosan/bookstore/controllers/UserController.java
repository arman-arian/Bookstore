package com.tosan.bookstore.controllers;

import com.tosan.bookstore.daos.UserRepository;
import com.tosan.bookstore.dtos.*;
import com.tosan.bookstore.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/getUsers")
    public ResponseEntity<List<UserDto>> GetUsers()
    {
        try
        {
            List<User> users = (List<User>) repository.findAll();
            List<UserDto> userDtoList = new ArrayList<>();
            for(User user : users)
            {
                UserDto userDto = new UserDto(user.getId(), user.getUsername(),user.getName(),
                        user.getEmail(), user.getUserTypes(), user.getCreationDate(), user.getLastLoginDate());

                userDtoList.add(userDto);
            }

            return new ResponseEntity<>(userDtoList, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unhandled Exception Has Occurred", ex);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserDto> Login(@RequestBody final LoginRequestDto req)
    {
        try {
            User user = repository.findByUsername(req.getUsername());
            if(user == null)
            {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

            if(!user.isActive())
            {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }

            // TODO: Hash Password
            if(user.getPassword().equals(req.getPassword()))
            {
                // TODO: Create JWT Token
                UserDto userDto = new UserDto(user.getId(), user.getUsername(),user.getName(),
                        user.getEmail(), user.getUserTypes(), user.getCreationDate(), user.getLastLoginDate());

                return new ResponseEntity<>(userDto, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }
        }
        catch (Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unhandled Exception Has Occurred", ex);
        }
    }


}
