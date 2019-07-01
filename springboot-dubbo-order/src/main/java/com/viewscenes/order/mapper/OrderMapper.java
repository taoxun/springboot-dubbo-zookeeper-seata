package com.viewscenes.order.mapper;

import com.viewscenes.order.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    void createOrder(Order order);
}
