package com.tosan.bookstore.controllers;

import com.tosan.bookstore.dtos.inputs.*;
import com.tosan.bookstore.services.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/user")
public class UserController {
    private final AuthenticationService _authenticationService;

    public UserController(AuthenticationService authenticationService) {
        _authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public String loginForm(LoginInputDto loginInputDto, Model model) {
//uncomment
//        if(_authenticationService.isUserAuthenticated()) {
//            return "redirect:/home";
//        }

        model.addAttribute("loginInputDto", new LoginInputDto());
        model.addAttribute("errors", new HashMap<String, String>());
        return "/users/login";
    }

    @PostMapping("/login")
    public String loginSubmit(LoginInputDto loginInputDto, Model model) {
        return "/users/login";
    }

    @GetMapping("/forgot_password")
    public String forgot_password() {
        return "/users/forgot_password";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (_authenticationService.isUserAuthenticated()) {
            return "redirect:/home";
        }

        model.addAttribute("errors", new HashMap<String, String>());
        model.addAttribute("userInputDto", new UserInputDto());
        return "/users/register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute UserInputDto userInputDto, Model model) {
        var errors = new HashMap<String, String>();
        errors.put("usernameError", "validation.username.duplicate");
        errors.put("passwordError", "validation.password.invalid");
        model.addAttribute("errors", errors);

        return "/users/register";
    }

    @PostMapping("/logout")
    public String logout() {
        //TODO: Clean Session
        return "redirect:/index";
    }
}
