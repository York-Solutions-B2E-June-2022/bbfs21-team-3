package net.yorksolutions.backend.Inventory;

import net.yorksolutions.backend.Category.Category;
import net.yorksolutions.backend.Category.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class InventoryService {

    InventoryRepository inventoryRepository;
    CategoryRepository categoryRepository;

    public InventoryService(InventoryRepository inventoryRepository, CategoryRepository categoryRepository) {
        this.inventoryRepository = inventoryRepository;
        this.categoryRepository = categoryRepository;
    }

    public ArrayList<Inventory> list() {

        return new ArrayList<Inventory>(inventoryRepository.getAllBy());
    }

    public void create(InventoryReq requestBody) {
        Optional<Category> category = categoryRepository.findByCategory(requestBody.catName);

        if (category.isPresent()) {
            requestBody.category = category.get();
        }

        Inventory item = new Inventory(requestBody);

        inventoryRepository.save(item);

    }

    public void delete(Long id) {

        Optional<Inventory> itemExists = inventoryRepository.findById(id);

        if (itemExists.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        inventoryRepository.delete(itemExists.get());
    }

    public void edit(InventoryReq requestBody) {
        Optional<Inventory> itemExists = inventoryRepository.findById(requestBody.id);

        if (itemExists.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Inventory item = itemExists.get();

        if (requestBody.price != null) {
            item.price = requestBody.price;
        }

        if (requestBody.priceDate != null) {
            item.priceDate = requestBody.priceDate;
        }

        if (requestBody.map != null) {
            item.map = requestBody.map;
        }

        if (requestBody.mapDate != null) {
            item.mapDate = requestBody.mapDate;
        }

        if (requestBody.sale != null) {
            item.sale = requestBody.sale;
        }

        if (requestBody.saleDate != null) {
            item.saleDate = requestBody.saleDate;
        }

        if (requestBody.cost != null) {
            item.cost = requestBody.cost;
        }

        if (requestBody.name != null) {
            item.name = requestBody.name;
        }

        if (requestBody.description != null) {
            item.description = requestBody.description;
        }

        if (requestBody.image != null) {
            item.image = requestBody.image;
        }

        if (requestBody.discontinued != null) {
            item.discontinued = requestBody.discontinued;
        }

        if (requestBody.availDate != null) {
            item.availDate = requestBody.availDate;
        }

        if (requestBody.catName != null) {
            Optional<Category> category = categoryRepository.findByCategory(requestBody.catName);

            category.ifPresent(value -> item.category = value);
        }

        inventoryRepository.save(item);


    }

}

