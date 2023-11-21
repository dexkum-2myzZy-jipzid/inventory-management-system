package com.me.mystudio.inventorymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.mystudio.inventorymanagementsystem.model.Inventory;
import com.me.mystudio.inventorymanagementsystem.repository.InventoryRepository;

@Service
public class InventoryService {

    private final InventoryRepository InventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository InventoryRepository) {
        this.InventoryRepository = InventoryRepository;
    }

    public Inventory addProduct(Inventory inventory) {
        return InventoryRepository.save(inventory);
    }
}