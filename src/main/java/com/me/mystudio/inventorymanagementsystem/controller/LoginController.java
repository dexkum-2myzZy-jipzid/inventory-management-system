package com.me.mystudio.inventorymanagementsystem.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    /**
     * Displays the login page.
     *
     * @param user the User object
     * @return the login page
     */
    @GetMapping("/")
    public String login(@ModelAttribute("user") UserDetails user) {
        return "login";
    }

    /**
     * Displays the admin-dashboard page.
     *
     * @return the admin-dashboard page
     */
    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminDashboard() {
        return "admin/admin-dashboard";
    }

    /**
     * Displays the user-dashboard page.
     *
     * @return the user-dashboard page
     */
    @GetMapping("/user/dashboard")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userDashboard() {
        return "user/user-dashboard";
    }
}
