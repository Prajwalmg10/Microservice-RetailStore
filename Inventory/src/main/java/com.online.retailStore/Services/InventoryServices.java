package com.online.retailStore.Services;


import com.online.retailStore.Models.Inventory;
import com.online.retailStore.UiResponse.DataException;

public interface InventoryServices {

    Inventory addToInventory(Inventory inventory)  throws DataException;

    Inventory searchInventory(int inventoryId) throws DataException;

    String deleteInventory(int Inventory) throws DataException;

    Inventory updateInventory(Inventory inventory) throws DataException;
}
