package com.me.mystudio.inventorymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.mystudio.inventorymanagementsystem.exception.InventoryNotFoundException;
import com.me.mystudio.inventorymanagementsystem.model.Inventory;
import com.me.mystudio.inventorymanagementsystem.repository.InventoryRepository;
import java.util.List;

/**
 * Service class for handling inventory-related requests.
 */
@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    /**
     * Constructor injection.
     *
     * @param inventoryRepository the InventoryRepository object
     */
    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    /**
     * Adds a new inventory to the database.
     *
     * @param inventory the Inventory object
     * @return the Inventory object
     */
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    /**
     * Gets all inventories from the database.
     *
     * @return list of inventories
     */
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    /**
     * Removes an inventory from the database.
     *
     * @param id the inventory id
     */
    public void removeInventory(Long id) {
        if (!inventoryRepository.existsById(id)) {
            throw new InventoryNotFoundException("Inventory not found with id: " + id);
        }
        inventoryRepository.deleteById(id);
    }

    /**
     * Updates an inventory in the database.
     *
     * @param inventory the Inventory object
     */
    public Inventory updateInventory(Inventory inventory) {
        if (!inventoryRepository.existsById(inventory.getId())) {
            throw new InventoryNotFoundException("Inventory not found with id: " + inventory.getId());
        }
        return inventoryRepository.save(inventory);
    }

    /**
     * Gets an inventory by id.
     *
     * @param id the inventory id
     * @return the Inventory object
     */
    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    /**
     * Gets an inventory by name.
     *
     * @param name the inventory name
     * @return the Inventory object
     */
    public List<Inventory> searchInventory(String searchTerm) {
        String lowerCaseSearchTerm = searchTerm.toLowerCase();
        return inventoryRepository.findByNameContainingIgnoreCase(lowerCaseSearchTerm);
    }
}