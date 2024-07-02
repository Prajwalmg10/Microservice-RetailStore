package Inventory.src.main.com.retailStore.Services;

import Customer.src.main.com.retailStore.Models.Inventory;
import Customer.src.main.com.retailStore.uiResponse.DataException;

public interface InventoryServices {

    Inventory addToInventory(Inventory inventory)  throws DataException;

    Inventory searchInventory(int inventoryId) throws DataException;

    String deleteInventory(int Inventory) throws DataException;

    Inventory updateInventory(Inventory inventory) throws DataException;
}
