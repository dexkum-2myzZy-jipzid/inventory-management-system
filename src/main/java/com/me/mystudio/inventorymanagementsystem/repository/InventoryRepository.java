package com.me.mystudio.inventorymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.mystudio.inventorymanagementsystem.model.Inventory;

/**
 * Repository interface for the inventory table.
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // Add custom query methods if needed
}