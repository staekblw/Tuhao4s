package com.tuhao.commandhandler.order;

import com.tuhao.command.order.CancelOrderCommand;
import com.tuhao.command.order.TakeOrderCommand;
import com.tuhao.command.order.CreateOrderCommand;
import com.tuhao.domain.order.Order;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by apple on 2/27/16.
 */
@Component
public class OrderCommandHandler {
    private Repository<Order> orderRepository;

    @Autowired
    public OrderCommandHandler(Repository<Order> orderRepository) {
        this.orderRepository = orderRepository;
    }

    @CommandHandler
    public void Order(CreateOrderCommand createOrderCommand) {
        orderRepository.add(new Order(createOrderCommand));
    }

    @CommandHandler
    public void takeOrder(TakeOrderCommand takeOrderCommand) {
        Order order = orderRepository.load(takeOrderCommand.getOrderId());
        order.take(takeOrderCommand);
    }

    @CommandHandler
    public void cancelOrder(CancelOrderCommand cancelOrderCommand) {
        Order order = orderRepository.load(cancelOrderCommand.getOrderId());
        order.cancel();
    }
}
