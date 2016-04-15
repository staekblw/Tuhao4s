package com.tuhao.command.order;

import com.tuhao.common.id.CarIdentifier;
import com.tuhao.common.id.CarOwnerIdentifier;
import com.tuhao.common.id.OrderIdentifier;
import com.tuhao.common.id.StoreIdentifier;

/**
 * Created by apple on 2/27/16.
 */
public class CreateOrderCommand {
    private CarOwnerIdentifier carOwnerId;
    private CarIdentifier carId;
    private StoreIdentifier storeId;
    private Location carLocation;

    public void setOrderId(OrderIdentifier orderId) {
        this.orderId = orderId;
    }

    private OrderIdentifier orderId;
    public CreateOrderCommand() {
    }

    public CreateOrderCommand(OrderIdentifier orderId) {
        this.orderId = orderId;
    }

    public OrderIdentifier getOrderId() {
        return orderId;
    }

    public CarOwnerIdentifier getCarOwnerId() {
        return carOwnerId;
    }

    public CarIdentifier getCarId() {
        return carId;
    }

    public StoreIdentifier getStoreId() {
        return storeId;
    }

    public Location getCarLocation() {
        return carLocation;
    }
}
