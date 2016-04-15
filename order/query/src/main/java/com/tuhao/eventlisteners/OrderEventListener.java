package com.tuhao.eventlisteners;

import com.tuhao.events.order.OrderAcceptedEvent;
import com.tuhao.events.order.OrderCreatedEvent;
import com.tuhao.view.model.Order;
import com.tuhao.view.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderEventListener {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public void handle(OrderAcceptedEvent event) {
        Order order = orderRepository.findOne(event.getOrderId().toString());
        order.setOrderStatus("已经接单");
    }

    @Transactional
    public void handle(OrderCreatedEvent event) {
        Order order = new Order(event.getOrderId().toString(), null, event.getOrderId());
        order.setOrderStatus("创建成功");
        orderRepository.save(order);
    }
}
