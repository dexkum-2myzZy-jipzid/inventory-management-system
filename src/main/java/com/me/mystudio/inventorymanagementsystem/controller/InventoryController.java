package com.me.mystudio.inventorymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.me.mystudio.inventorymanagementsystem.model.Inventory;
import com.me.mystudio.inventorymanagementsystem.service.InventoryService;

@Controller
public class InventoryController {

    @Autowired
    private InventoryService InventoryService;

    @GetMapping("/add-inventory")
    public String showAddProductForm(Model model) {
        model.addAttribute("inventory", new Inventory());
        return "add-inventory";
    }

    @PostMapping("/add-inventory")
    public String addProduct(@ModelAttribute("inventory") Inventory inventory) {
        // Add the inventory to the database
        InventoryService.addProduct(inventory);
        return "redirect:/admin-dashboard";
    }
}
