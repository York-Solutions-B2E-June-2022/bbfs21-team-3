package net.yorksolutions.backend.OrderHdr;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderHdrService {
    OrderHdrRepository OrderHdrRepository;

    public OrderHdrService(OrderHdrRepository OrderHdrRepository) {
        this.OrderHdrRepository = OrderHdrRepository;
    }

    public ArrayList<String> list() {
        Iterable<OrderHdr> orderHdrs = OrderHdrRepository.findAll();
        ArrayList<String> data = new ArrayList<String>();
        orderHdrs.forEach(OrderHdr -> data.add(OrderHdr.getOrderHdr()));
        return data;
    }

        public void create(String orderHdrName) {
        Optional<OrderHdr> orderHdrExist = OrderHdrRepository.findByOrderHdr(orderHdrName);
        if (orderHdrExist.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        OrderHdr orderHdr = new OrderHdr(orderHdrName);
        OrderHdrRepository.save(orderHdr);
    }

}
