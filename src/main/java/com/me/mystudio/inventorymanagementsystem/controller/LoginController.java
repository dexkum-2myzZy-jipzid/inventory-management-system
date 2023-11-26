package com.me.mystudio.inventorymanagementsystem.controller;

import com.me.mystudio.inventorymanagementsystem.model.User;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login(@ModelAttribute("user") User user) {
        return "login";
    }

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminDashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/user/dashboard")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userDashboard() {
        return "user-dashboard";
    }
}
