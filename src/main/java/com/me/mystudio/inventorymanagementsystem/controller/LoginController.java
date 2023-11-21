package com.me.mystudio.inventorymanagementsystem.controller;

import com.me.mystudio.inventorymanagementsystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        if ("admin".equals(user.getUsername())) {
            // Admin login, redirect to admin-dashboard with user object
            user.setRole("admin");
            redirectAttributes.addFlashAttribute("user", user);
            System.out.println("User: " + user.getUsername() + " Password: " + user.getPassword() +
                    " Role: " + user.getRole());
            return "redirect:/admin-dashboard";
        } else {
            // General user login, redirect to user-dashboard
            return "redirect:/user-dashboard";
        }
    }

    @GetMapping("/admin-dashboard")
    public String adminDashboard(Model model, @ModelAttribute("user") User user) {
        model.addAttribute("user", user);
        return "admin-dashboard";
    }

    @GetMapping("/user-dashboard")
    public String userDashboard() {
        return "user-dashboard";
    }
}
