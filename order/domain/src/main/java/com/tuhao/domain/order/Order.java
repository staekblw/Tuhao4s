package com.tuhao.domain.order;

import com.tuhao.command.order.TakeOrderCommand;
import com.tuhao.command.order.CreateOrderCommand;
import com.tuhao.common.id.OrderIdentifier;
import com.tuhao.events.order.OrderTakenEvent;
import com.tuhao.events.order.OrderCancelledEvent;
import com.tuhao.events.order.OrderCreatedEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

public class Order extends AbstractAnnotatedAggregateRoot<OrderIdentifier> {
    @AggregateIdentifier
    private OrderIdentifier id;

    private OrderStatus orderStatus;

    Order() {
    }

    public Order(CreateOrderCommand createOrderCommand) {
        super.apply(new OrderCreatedEvent(
                createOrderCommand.getCarOwnerId(),
                createOrderCommand.getOrderId(),
                createOrderCommand.getCarLocation()));
    }

    public void cancel() {
        if (orderStatus.equals(OrderStatus.CREATED)) {
            this.apply(new OrderCancelledEvent(this.id));
        } else {
            throw OrderException.CAN_NOT_CANCEL_ORDER;
        }
    }

    public void take(TakeOrderCommand takeOrderCommand) {
        if (orderStatus.equals(OrderStatus.CREATED)) {
            this.apply(new OrderTakenEvent(takeOrderCommand.getDriverId(), this.id));
        } else {
            throw OrderException.CAN_NOT_TAKEN_ORDER;
        }
    }

    @EventHandler
    protected void handle(OrderCreatedEvent event) {
        this.id = event.getOrderId();
        this.orderStatus = OrderStatus.CREATED;
    }

    @EventHandler
    protected void handle(OrderTakenEvent event) {
        this.orderStatus = OrderStatus.ACCEPTED;
    }

    @EventHandler
    protected void handle(OrderCancelledEvent event) {
        this.orderStatus = OrderStatus.CANCELLED;
    }
}
