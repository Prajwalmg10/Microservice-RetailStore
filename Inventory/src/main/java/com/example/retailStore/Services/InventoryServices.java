package com.example.retailStore.Services;

import com.example.retailStore.Models.Inventory;
import com.example.retailStore.uiResponse.DataException;

public interface InventoryServices {

    Inventory addToInventory(Inventory inventory)  throws DataException;

    Inventory searchInventory(int inventoryId) throws DataException;

    String deleteInventory(int Inventory) throws DataException;

    Inventory updateInventory(Inventory inventory) throws DataException;
}
