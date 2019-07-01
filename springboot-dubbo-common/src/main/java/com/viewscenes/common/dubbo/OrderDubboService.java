package com.viewscenes.common.dubbo;

import com.viewscenes.common.dto.OrderDTO;

public interface OrderDubboService {

    void createOrder(OrderDTO order);
}
