package net.yorksolutions.backend.Category;

import net.yorksolutions.backend.Inventory.Inventory;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String category;

    public Category() {
    }

    public Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}
