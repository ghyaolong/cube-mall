package com.cube.ordercenter.controller;

import com.cube.ordercenter.vo.OrderVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单相关
 */
//@RequestMapping("/order")
@RestController
public class OrderController {

    @PostMapping("/order")
    public OrderVO addOrder(OrderVO orderVO){
        return null;
    }
}
