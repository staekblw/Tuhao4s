package com.tuhao.commandhandler.order;

import com.tuhao.command.order.AcceptOrderCommand;
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
    public void acceptOrder(AcceptOrderCommand acceptOrderCommand) {
        Order order = orderRepository.load(acceptOrderCommand.getOrderId());
        order.acceptOrder(acceptOrderCommand);
    }
}
