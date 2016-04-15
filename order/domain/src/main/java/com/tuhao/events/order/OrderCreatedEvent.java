package com.tuhao.events.order;

import com.tuhao.common.id.CarOwnerIdentifier;
import com.tuhao.common.id.OrderIdentifier;

/**
 * Created by apple on 2/29/16.
 */
public class OrderCreatedEvent {
    private CarOwnerIdentifier carOwnerId;

    private OrderIdentifier orderId;

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(CarOwnerIdentifier carOwnerId, OrderIdentifier orderId) {
        this.carOwnerId = carOwnerId;
        this.orderId = orderId;
    }

    public OrderIdentifier getOrderId() {
        return orderId;
    }

    public CarOwnerIdentifier getCarOwnerId() {
        return carOwnerId;
    }
}
