package net.yorksolutions.backend.OrderHdr;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class OrderHdr {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String orderHdr;

    public OrderHdr() {
    }

    public OrderHdr(String orderHdr) {
        this.orderHdr = orderHdr;
    }
    public String getOrderHdr() {
        return orderHdr;
    }

}

