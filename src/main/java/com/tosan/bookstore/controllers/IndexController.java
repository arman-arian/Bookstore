package com.tosan.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("home")
    public String home() {
        return "home";
    }
}
