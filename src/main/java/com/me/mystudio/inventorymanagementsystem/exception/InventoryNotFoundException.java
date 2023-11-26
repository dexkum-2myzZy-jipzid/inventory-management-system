package com.me.mystudio.inventorymanagementsystem.exception;

/**
 * Exception thrown when an inventory is not found.
 */
public class InventoryNotFoundException extends RuntimeException {
    /**
     * Constructor.
     *
     * @param message the error message
     */
    public InventoryNotFoundException(String message) {
        super(message);
    }
}