package com.tosan.bookstore.controllers;

import com.tosan.bookstore.dtos.inputs.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    public UserController() {
    }

    @GetMapping("/login")
    public String loginForm(LoginInputDto loginInputDto, Model model) {
        model.addAttribute("loginInputDto", new LoginInputDto());
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
        model.addAttribute("usernameError", "empty");
        model.addAttribute("passwordError", "empty");
        model.addAttribute("hasError", "false");
        model.addAttribute("userInputDto", new UserInputDto());
        return "/users/register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute UserInputDto userInputDto, Model model) {
        model.addAttribute("hasError", "true");
        model.addAttribute("usernameError", "validation.username.duplicate");
        model.addAttribute("passwordError", "validation.username.duplicate");
        return "/users/register";
    }

    @PostMapping("/logout")
    public String logout() {
        //TODO: Clean Session
        return "redirect:/index";
    }
}
