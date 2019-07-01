package com.viewscenes.order.controller;

import com.viewscenes.common.dto.OrderDTO;
import com.viewscenes.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping("/create_order")
    public void createOrder(@RequestBody OrderDTO order){
        orderService.createOrder(order);
    }
}
