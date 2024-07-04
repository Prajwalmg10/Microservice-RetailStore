package com.online.retailStore.Controllers;

import com.online.retailStore.Models.Inventory;
import com.online.retailStore.Services.InventoryServices;
import com.online.retailStore.uiResponse.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/inventory")
public class InventoryController extends AbstarctController{

    @Autowired
    private InventoryServices inventoryServices;

    @PostMapping("/add")
    public ResponseEntity<?> addToInventory(@RequestBody Inventory inventory){
        try{
            return buildResponse(inventoryServices.addToInventory(inventory));
        }catch (DataException e){
            return buildError(e);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory){
        try{
            return buildResponse(inventoryServices.updateInventory(inventory));
        }catch (DataException e){
            return buildError(e);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteInventory(@RequestParam int inventoryId){
        try{
            return buildSuccessMessage(inventoryServices.deleteInventory(inventoryId));
        }catch (DataException e){
            return buildError(e);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchInventory(@RequestParam int inventoryId){
        try{
            return buildResponse(inventoryServices.searchInventory(inventoryId));
        }catch (DataException e){
            return buildError(e);
        }
    }

}
