package com.tuhao.events.order;

import com.tuhao.common.id.OrderIdentifier;

/**
 * Created by apple on 2/29/16.
 */
public class OrderCancelledEvent {
    private OrderIdentifier orderId;

    public OrderCancelledEvent() {
    }


    public OrderCancelledEvent(OrderIdentifier orderId) {
        this.orderId = orderId;
    }

    public OrderIdentifier getOrderId() {
        return orderId;
    }
}
