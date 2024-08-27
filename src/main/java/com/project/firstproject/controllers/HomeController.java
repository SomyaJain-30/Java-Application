package com.project.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.firstproject.entities.User;
import com.project.firstproject.helper.Message;
import com.project.firstproject.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;

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
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/do_register")
    public String registerUser(@ModelAttribute("user") User user, @RequestParam(value="agreement",defaultValue="false") boolean agreement, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        try{
            if(!agreement){
                System.out.println("please accept the terms & conditions");
                throw new Exception("Please accept terms & condition");
            }
    
            user.setEnabled(true);
            user.setRole("ROLE_USER");
            userRepository.save(user);
            model.addAttribute("user", new User());
            // redirectAttributes.addFlashAttribute("message", new Message("Successfully registered!", "alert-success"));
            session.setAttribute("message", new Message("Successfully registered!", "alert-success"));
            // session.set("message", new Message("Successfully registered!", "alert-success"));
            
        }catch(Exception e){
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute("message", new Message("Please accept terms & conditions", "alert-danger"));
            // redirectAttributes.addFlashAttribute("message", new Message("Please accept terms & conditions", "alert-danger"));


        }
        return "register";
        
    }
    
    
}
