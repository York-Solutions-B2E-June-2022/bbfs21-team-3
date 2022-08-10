package net.yorksolutions.backend.OrderHdr;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderHdrRepository extends CrudRepository<OrderHdr, Long> {
    Optional<OrderHdr> findByOrderHdr(String orderHdrName);
}
