package net.yorksolutions.backend.Coupon;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CouponService {
    CouponRepository CouponRepository;

    public CouponService(CouponRepository CouponRepository) {
        this.CouponRepository = CouponRepository;
    }

    public ArrayList<String> list() {
        Iterable<Coupon> coupons = CouponRepository.findAll();
        ArrayList<String> data = new ArrayList<String>();
        coupons.forEach(Coupon -> data.add(Coupon.getCoupon()));
        return data;
    }

        public void create(String couponName) {
        Optional<Coupon> couponExist = CouponRepository.findByCoupon(couponName);
        if (couponExist.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Coupon Coupon = new Coupon(couponName);
        CouponRepository.save(Coupon);
    }

}
