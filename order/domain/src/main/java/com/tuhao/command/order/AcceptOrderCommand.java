package com.tuhao.command.order;

import com.tuhao.common.id.OrderIdentifier;

/**
 * Created by apple on 2/27/16.
 */
public class AcceptOrderCommand {
    private OrderIdentifier orderId;
    private String driverId;

    public AcceptOrderCommand() {
    }

    public AcceptOrderCommand(OrderIdentifier orderId, String driverId) {
        this.orderId = orderId;
        this.driverId = driverId;
    }

    public OrderIdentifier getOrderId() {
        return orderId;
    }

    public String getDriverId() {
        return driverId;
    }
}
