package com.me.mystudio.inventorymanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.mystudio.inventorymanagementsystem.model.Inventory;

/**
 * Repository interface for the inventory table.
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // Custom query to search the inventory table by name
    List<Inventory> findByNameContainingIgnoreCase(String searchTerm);
}