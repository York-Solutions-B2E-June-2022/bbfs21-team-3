package net.yorksolutions.backend.OrderDtl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class OrderDtl {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String orderDtl;

    public OrderDtl() {
    }

    public OrderDtl(String orderDtl) {
        this.orderDtl = orderDtl;
    }
    public String getOrderDtl() {
        return orderDtl;
    }

}

