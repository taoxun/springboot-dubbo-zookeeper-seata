package com.viewscenes.order.dubbo;

import com.viewscenes.common.dto.OrderDTO;
import com.viewscenes.common.dubbo.OrderDubboService;
import com.viewscenes.order.service.OrderService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderDubboServiceImpl implements OrderDubboService {


    @Autowired
    OrderService orderService;

    @Override
    public void createOrder(OrderDTO order) {
        orderService.createOrder(order);
    }
}
