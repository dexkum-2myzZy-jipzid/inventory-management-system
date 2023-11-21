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
    private InventoryService inventoryService;

    @GetMapping("/add-inventory")
    public String showAddProductForm(Model model) {
        model.addAttribute("inventory", new Inventory());
        model.addAttribute("inventories", inventoryService.getAllInventories());
        return "add-inventory";
    }

    @PostMapping("/add-inventory")
    public String addInventory(@ModelAttribute("inventory") Inventory inventory, Model model) {
        // Add the inventory to the database
        inventoryService.addInventory(inventory);

        // Clear the form by adding a new, empty Inventory object to the model
        model.addAttribute("inventory", new Inventory());

        // Add the updated list of inventories to the model
        model.addAttribute("inventories", inventoryService.getAllInventories());
        return "add-inventory";
    }

    @GetMapping("/remove-inventory")
    public String showRemoveInventoryForm(Model model) {
        model.addAttribute("inventory", new Inventory());
        model.addAttribute("inventories", inventoryService.getAllInventories());
        return "remove-inventory";
    }

    @PostMapping("/remove-inventory")
    public String removeInventory(@ModelAttribute("inventory") Inventory inventory, Model model) {
        // remove the inventory from the database
        inventoryService.removeInventory(inventory.getId());
        // Clear the form by adding a new, empty Inventory object to the model
        model.addAttribute("inventory", new Inventory());

        // Add the updated list of inventories to the model
        model.addAttribute("inventories", inventoryService.getAllInventories());
        return "remove-inventory";
    }

}
