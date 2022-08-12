package net.yorksolutions.backend.Inventory;

import net.yorksolutions.backend.Category.Category;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    Integer price;
    String priceDate;

    Integer map;
    String mapDate;

    Integer sale;
    String saleDate;

    Integer cost;

    String name;
    String description;
    String image;

    Boolean discontinued;
    String availDate;

    @ManyToOne
    Category category;

    public Inventory() {
    }

    public Inventory(InventoryReq inventoryReq) {

        this.price = inventoryReq.price;
        this.priceDate = inventoryReq.priceDate;
        this.map = inventoryReq.map;
        this.mapDate = inventoryReq.mapDate;
        this.sale = inventoryReq.sale;
        this.saleDate = inventoryReq.saleDate;
        this.cost = inventoryReq.cost;
        this.name = inventoryReq.name;
        this.description = inventoryReq.description;
        this.image = inventoryReq.image;
        this.discontinued = inventoryReq.discontinued;
        this.availDate = inventoryReq.availDate;
        this.category = inventoryReq.category;
    }

    public Long getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public String getPriceDate() {
        return priceDate;
    }

    public Integer getMap() {
        return map;
    }

    public String getMapDate() {
        return mapDate;
    }

    public Integer getSale() {
        return sale;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public Integer getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Boolean getDiscontinued() {
        return discontinued;
    }

    public String getAvailDate() {
        return availDate;
    }

    public String getCategory() {
        return category.getCategory();
    }
}
