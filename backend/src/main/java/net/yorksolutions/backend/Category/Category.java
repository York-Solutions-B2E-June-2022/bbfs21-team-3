package net.yorksolutions.backend.Category;

import javax.persistence.*;


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
