package net.yorksolutions.backend.Coupon;

import net.yorksolutions.backend.Category.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {
    Optional<Coupon> findByCoupon(String couponName);
}
