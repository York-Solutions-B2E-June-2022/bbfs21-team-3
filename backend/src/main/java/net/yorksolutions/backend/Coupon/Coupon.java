package net.yorksolutions.backend.Coupon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String coupon;

    public Coupon() {
    }

    public Coupon(String coupon) {
        this.coupon = coupon;
    }
    public String getCoupon() {
        return coupon;
    }

}

