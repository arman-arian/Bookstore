package com.tosan.bookstore.controllers;

import com.tosan.bookstore.LoginDto;
import com.tosan.bookstore.daos.UserRepository;
import com.tosan.bookstore.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<Boolean> Login(@RequestBody final LoginDto inputs)
    {
       User user = repository.findByUsername(inputs.getUsername());

       if(user == null)
       {
           return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
       }

       if(!user.isActive())
       {
           return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
       }

       if(user.getPassword().equals(inputs.getPassword()))
       {
           return new ResponseEntity<>(true, HttpStatus.OK);
       }
       else
       {
           return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
       }
    }
}
