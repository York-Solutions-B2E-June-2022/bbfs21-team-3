package net.yorksolutions.backend.Inventory;

import net.yorksolutions.backend.Category.Category;
import net.yorksolutions.backend.Category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    InventoryRepository inventoryRepository;
    CategoryRepository categoryRepository;

    public InventoryService(InventoryRepository inventoryRepository, CategoryRepository categoryRepository) {
        this.inventoryRepository = inventoryRepository;
        this.categoryRepository = categoryRepository;
    }

    public void create(InventoryReq requestBody) {
        Optional<Category> category = categoryRepository.findByCategory(requestBody.catName);

        if (category.isPresent()) {
            requestBody.category = category.get();

            Inventory item = new Inventory(requestBody);

            inventoryRepository.save(item);
        }

    }
}

