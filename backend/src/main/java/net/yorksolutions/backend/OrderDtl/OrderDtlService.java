package net.yorksolutions.backend.OrderDtl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderDtlService {
    OrderDtlRepository OrderDtlRepository;

    public OrderDtlService(OrderDtlRepository OrderDtlRepository) {
        this.OrderDtlRepository = OrderDtlRepository;
    }

    public ArrayList<String> list() {
        Iterable<OrderDtl> orderDtls = OrderDtlRepository.findAll();
        ArrayList<String> data = new ArrayList<String>();
        orderDtls.forEach(OrderDtl -> data.add(OrderDtl.getOrderDtl()));
        return data;
    }

        public void create(String orderDtlName) {
        Optional<OrderDtl> orderDtlExist = OrderDtlRepository.findByOrderDtl(orderDtlName);
        if (orderDtlExist.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        OrderDtl orderDtl = new OrderDtl(orderDtlName);
        OrderDtlRepository.save(orderDtl);
    }

}
