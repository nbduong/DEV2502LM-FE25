package com.test.demo5.controller;


import com.test.demo5.entity.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title","Devmaster::trang chu");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        return "contact";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        List<user> users = new ArrayList<>();
        users.add(new user("1","zawser","1234","email@gmail.com"));
        users.add(new user("2","ali","1234","email@gmail.com"));
        model.addAttribute("users",users);
        return "profile";
    }
}
