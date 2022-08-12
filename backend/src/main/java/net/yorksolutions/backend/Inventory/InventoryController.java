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

    @DeleteMapping("/delete")
    public void delete(@RequestBody InventoryReq requestBody) {
        inventoryService.delete(requestBody.id);
    }

    @PatchMapping("/edit")
    public void edit(@RequestBody InventoryReq requestBody) {
        inventoryService.edit(requestBody);
    }
}

class InventoryReq {
    public Long id;
    public Integer price;
    public String priceDate;

    public Integer map;
    public String mapDate;

    public Integer sale;
    public String saleDate;

    public Integer cost;

    public String name;
    public String description;
    public String image;

    public Boolean discontinued;
    public String availDate;

    public String catName;
    public Category category;
}
