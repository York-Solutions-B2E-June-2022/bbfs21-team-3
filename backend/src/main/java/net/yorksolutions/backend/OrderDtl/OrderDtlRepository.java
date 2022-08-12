package net.yorksolutions.backend.OrderDtl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDtlRepository extends CrudRepository<OrderDtl, Long> {
    Optional<OrderDtl> findByOrderDtl(String orderDtlName);
}
