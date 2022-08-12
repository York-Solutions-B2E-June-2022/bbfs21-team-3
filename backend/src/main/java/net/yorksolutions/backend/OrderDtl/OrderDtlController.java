package net.yorksolutions.backend.OrderDtl;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/orderDetail")
@CrossOrigin
public class OrderDtlController {
    OrderDtlService orderDtlService;

    public OrderDtlController(OrderDtlService orderDtlService) {
        this.orderDtlService = orderDtlService;
    }
    @GetMapping("/list")
        public ArrayList<String> list() {
        return orderDtlService.list();
    }
    @PostMapping("/create")
    public void create(@RequestBody OrderDtlReq requestBody) {
        orderDtlService.create(requestBody.orderDtl);
    }
}


class OrderDtlReq {

    public String orderDtl;
}

