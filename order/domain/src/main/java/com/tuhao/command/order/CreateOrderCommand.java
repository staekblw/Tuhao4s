package com.tuhao.command.order;

import com.tuhao.common.id.CarIdentifier;
import com.tuhao.common.id.CarOwnerIdentifier;
import com.tuhao.common.id.OrderIdentifier;
import com.tuhao.common.id.StoreIdentifier;
import com.tuhao.domain.order.Location;

/**
 * Created by apple on 2/27/16.
 */
public class CreateOrderCommand {
    private CarOwnerIdentifier carOwnerId;
    private Location carLocation;

    private OrderIdentifier orderId;

    public CreateOrderCommand() {
    }

    public CreateOrderCommand(OrderIdentifier orderId, CarOwnerIdentifier carOwnerId, Location carLocation) {
        this.orderId = orderId;
        this.carOwnerId = carOwnerId;
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
