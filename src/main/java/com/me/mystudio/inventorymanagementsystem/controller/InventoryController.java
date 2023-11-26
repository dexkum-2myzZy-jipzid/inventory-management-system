package com.me.mystudio.inventorymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.mystudio.inventorymanagementsystem.model.Inventory;
import com.me.mystudio.inventorymanagementsystem.service.InventoryService;
import java.util.List;

/**
 * Controller class for handling inventory-related requests.
 */
@Controller
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    /**
     * Displays the view-inventory page.
     *
     * @param model the Model object
     * @return the view-inventory page
     */
    @GetMapping({ "/admin/view-inventory", "/user/view-inventory" })
    public String viewInventory(Model model) {
        // Get the list of inventories from the database
        List<Inventory> inventories = inventoryService.getAllInventories();

        // Add the list of inventories to the model
        model.addAttribute("inventories", inventories);

        // Return the view name
        return "shared/view-inventory";
    }

    /**
     * Displays the add-inventory page.
     *
     * @param model the Model object
     * @return the add-inventory page
     */
    @GetMapping("/admin/add-inventory")
    public String showAddProductForm(Model model) {
        model.addAttribute("inventory", new Inventory());
        model.addAttribute("inventories", inventoryService.getAllInventories());
        return "admin/add-inventory";
    }

    /**
     * Adds a new inventory to the database.
     *
     * @param inventory the Inventory object
     * @param model     the Model object
     * @return the add-inventory page
     */
    @PostMapping("/admin/add-inventory")
    public String addInventory(@ModelAttribute("inventory") Inventory inventory, Model model) {
        // Add the inventory to the database
        inventoryService.addInventory(inventory);
        // Clear the form by adding a new, empty Inventory object to the model
        model.addAttribute("inventory", new Inventory());
        // Add the updated list of inventories to the model
        model.addAttribute("inventories", inventoryService.getAllInventories());
        return "admin/add-inventory";
    }

    /**
     * Displays the remove-inventory page.
     *
     * @param model the Model object
     * @return the remove-inventory page
     */
    @GetMapping("/admin/remove-inventory")
    public String showRemoveInventoryForm(Model model) {
        model.addAttribute("inventory", new Inventory());
        model.addAttribute("inventories", inventoryService.getAllInventories());
        return "admin/remove-inventory";
    }

    /**
     * Removes an inventory from the database.
     *
     * @param inventory the Inventory object
     * @param model     the Model object
     * @return the remove-inventory page
     */
    @PostMapping("/admin/remove-inventory")
    public String removeInventory(@ModelAttribute("inventory") Inventory inventory, Model model) {
        // remove the inventory from the database
        inventoryService.removeInventory(inventory.getId());
        // Clear the form by adding a new, empty Inventory object to the model
        model.addAttribute("inventory", new Inventory());
        // Add the updated list of inventories to the model
        model.addAttribute("inventories", inventoryService.getAllInventories());
        return "admin/remove-inventory";
    }

    /**
     * Displays the update-inventory page.
     *
     * @param model the Model object
     * @return the update-inventory page
     */
    @GetMapping("/admin/update-inventory")
    public String showUpdateInventoryForm(Model model) {
        model.addAttribute("inventories", inventoryService.getAllInventories());
        return "admin/update-inventory";
    }

    /**
     * Updates an inventory in the database.
     *
     * @param id       the id of the inventory to update
     * @param name     the name of the inventory to update
     * @param quantity the quantity of the inventory to update
     * @param price    the price of the inventory to update
     * @param model    the Model object
     * @return the update-inventory page
     */
    @PostMapping("/admin/update-inventory")
    public String updateInventory(@RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("price") Double price,
            Model model) {

        Inventory inventory = inventoryService.getInventoryById(id);

        if (inventory != null) {
            inventory.setName(name);
            inventory.setQuantity(quantity);
            inventory.setPrice(price);
            inventoryService.updateInventory(inventory);
            model.addAttribute("updateSuccess", true);
        } else {
            System.out.println("Inventory not found with id: " + id);
            model.addAttribute("updateSuccess", false);
        }

        model.addAttribute("inventories", inventoryService.getAllInventories());

        return "admin/update-inventory";
    }

}
