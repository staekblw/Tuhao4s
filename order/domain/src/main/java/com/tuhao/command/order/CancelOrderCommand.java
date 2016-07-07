package com.tuhao.command.order;

import com.tuhao.common.id.OrderIdentifier;

/**
 * Created by apple on 2/27/16.
 */
public class CancelOrderCommand {
    private OrderIdentifier orderId;

    public CancelOrderCommand(OrderIdentifier orderId, String driverId) {
        this.orderId = orderId;
    }

    public OrderIdentifier getOrderId() {
        return orderId;
    }

}
