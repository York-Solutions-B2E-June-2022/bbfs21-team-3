package net.yorksolutions.backend.Inventory;

import net.yorksolutions.backend.Category.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/inventory")
@CrossOrigin
public class InventoryController {

    InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/list")
    public ArrayList<Inventory> list() {

        return inventoryService.list();
    }

    @PostMapping("/create")
    public void create(@RequestBody InventoryReq requestBody) {
        inventoryService.create(requestBody);
    }
}

class InventoryReq {
    public int price;
    public String priceDate;

    public int map;
    public String mapDate;

    public int sale;
    public String saleDate;

    public int cost;

    public String name;
    public String description;
    public String image;

    public Boolean discontinued;
    public String availDate;

    public String catName;
    public Category category;
}
