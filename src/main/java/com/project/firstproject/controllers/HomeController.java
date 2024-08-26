package com.project.firstproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Contact Manager - Home");
        return "home";
    }
    
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Contact Manager - About");
        return "about";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("title", "Contact Manager - register");
        return "register";
    }
    
}
