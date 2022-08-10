package net.yorksolutions.backend.Inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {

    ArrayList<Inventory> getAllBy();
}
