package com.example.webapplication.controller;

import com.example.webapplication.entity.Admin;
import com.example.webapplication.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public String showLoginForm() {
        return "admin_login";
    }
    @GetMapping("/admin_dashboard")
    public String adminDashboard(Model model) {
        return "admin_dashboard";
    }
    @PostMapping("/admin_login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            // Admin login successful, redirect to the admin dashboard
            return "redirect:/admin_dashboard";
        } else {
            // Admin login failed, display an error message
            model.addAttribute("error", "Invalid username or password");
            return "admin_login";
        }
    }
}
