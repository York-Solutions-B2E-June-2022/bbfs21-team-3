package net.yorksolutions.backend.Coupon;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/coupon")
@CrossOrigin
public class CouponController {
    CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }
    @GetMapping("/list")
        public ArrayList<String> list() {
        return couponService.list();
    }
    @PostMapping("/create")
    public void create(@RequestBody CouponReq requestBody) {
        couponService.create(requestBody.coupon);
    }
}


class CouponReq {

    public String coupon;
}

