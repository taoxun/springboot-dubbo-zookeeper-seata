package com.viewscenes.order.controller;

import com.viewscenes.common.dto.OrderDTO;
import com.viewscenes.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/create_order")
    public void createOrder(@RequestBody OrderDTO order){
        logger.info("接收到订单数据：{}",order.getCommodityCode());
        orderService.createOrder(order);
    }
}
