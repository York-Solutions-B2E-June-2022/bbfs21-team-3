package net.yorksolutions.backend.OrderHdr;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/orderHdr")
@CrossOrigin
public class OrderHdrController {
    OrderHdrService orderHdrService;

    public OrderHdrController(OrderHdrService orderHdrService) {
        this.orderHdrService = orderHdrService;
    }
    @GetMapping("/list")
        public ArrayList<String> list() {
        return orderHdrService.list();
    }
    @PostMapping("/create")
    public void create(@RequestBody OrderHdrReq requestBody) {
        orderHdrService.create(requestBody.orderHdr);
    }
}


class OrderHdrReq {

    public String orderHdr;
}

