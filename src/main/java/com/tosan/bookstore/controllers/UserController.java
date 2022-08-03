package com.tosan.bookstore.controllers;

import com.tosan.bookstore.daos.UserRepository;
import com.tosan.bookstore.dtos.*;
import com.tosan.bookstore.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDto> Login(@RequestBody final LoginRequestDto req)
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

            if(user.getPassword().equals(req.getPassword()))
            {
                LoginResponseDto res = new LoginResponseDto(user.getId(), user.getUsername(),user.getName(),
                        user.getEmail(), user.getUserTypes(), user.getCreationDate(), user.getLastLoginDate());

                return new ResponseEntity<>(res, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }
        }
        catch (Exception exc)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found", exc);
        }
    }
}
