package com.tuhao.events.order;

import com.tuhao.common.id.CarOwnerIdentifier;
import com.tuhao.common.id.OrderIdentifier;
import com.tuhao.domain.order.Location;

/**
 * Created by apple on 2/29/16.
 */
public class OrderCreatedEvent {
    private CarOwnerIdentifier carOwnerId;

    private OrderIdentifier orderId;

    private Location carLocation;

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(CarOwnerIdentifier carOwnerId, OrderIdentifier orderId, Location carLocation) {
        this.carOwnerId = carOwnerId;
        this.orderId = orderId;
        this.carLocation = carLocation;
    }

    public OrderIdentifier getOrderId() {
        return orderId;
    }

    public CarOwnerIdentifier getCarOwnerId() {
        return carOwnerId;
    }

    public Location getCarLocation() {
        return carLocation;
    }
}
