package com.test.demo5.controller;

import com.test.demo5.entity.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @GetMapping
    public String manage(Model model) {
        List<user> users = new ArrayList<>();
        users.add(new user("1","zawser","1234","email@gmail.com"));
        users.add(new user("2","ali","1234","email@gmail.com"));
        model.addAttribute("users",users);
        return "manageIndex";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @GetMapping("/edit")
    public String edit() {
        return "edit";
    }
}
