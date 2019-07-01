package com.viewscenes.order.service.impl;

import com.viewscenes.common.dto.OrderDTO;
import com.viewscenes.common.dto.StorageDTO;
import com.viewscenes.common.dubbo.StorageDubboService;
import com.viewscenes.order.entity.Order;
import com.viewscenes.order.mapper.OrderMapper;
import com.viewscenes.order.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Reference
    StorageDubboService storageDubboService;

    AtomicInteger order_id = new AtomicInteger(0);

    @Override
    @GlobalTransactional
    public void createOrder(OrderDTO orderDTO) {

        System.out.println("开始全局事务。XID="+RootContext.getXID());

        StorageDTO storageDTO = new StorageDTO();
        storageDTO.setCount(orderDTO.getCount());
        storageDTO.setCommodityCode(orderDTO.getCommodityCode());

        //1、扣减库存
        storageDubboService.decreaseStorage(storageDTO);

        //2、创建订单
        orderDTO.setId(order_id.incrementAndGet());
        orderDTO.setOrderNo(UUID.randomUUID().toString());
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO,order);
        orderMapper.createOrder(order);

        throw new RuntimeException("分布式事务异常..."+orderDTO.getOrderNo());
    }
}
