package com.tuhao.domain.order;

import com.tuhao.command.order.AcceptOrderCommand;
import com.tuhao.command.order.CreateOrderCommand;
import com.tuhao.common.id.OrderIdentifier;
import com.tuhao.events.order.OrderAcceptedEvent;
import com.tuhao.events.order.OrderCreatedEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

public class Order extends AbstractAnnotatedAggregateRoot<OrderIdentifier> {
    @AggregateIdentifier
    private OrderIdentifier id;

    private OrderStatus orderStatus;

    Order(){
    }

    public Order(CreateOrderCommand createOrderCommand) {
        super.apply(new OrderCreatedEvent(createOrderCommand.getCarOwnerId(), createOrderCommand.getOrderId()));
    }

    public void acceptOrder(AcceptOrderCommand acceptOrderCommand) {
        if (orderStatus.equals(OrderStatus.CREATED)) {
            this.apply(new OrderAcceptedEvent(acceptOrderCommand.getDriverId(), this.id));
        } else {
            throw new RuntimeException("order already being accepted!");
        }
    }

    @EventHandler
    public void handle(OrderCreatedEvent event) {
        this.id = event.getOrderId();
        this.orderStatus = OrderStatus.CREATED;
    }

    @EventHandler
    public void handle(OrderAcceptedEvent event) {
        this.orderStatus = OrderStatus.ACCEPTED;
    }
}
