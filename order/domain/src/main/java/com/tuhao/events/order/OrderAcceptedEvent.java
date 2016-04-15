package com.tuhao.events.order;

import com.tuhao.common.id.OrderIdentifier;

/**
 * Created by apple on 2/29/16.
 */
public class OrderAcceptedEvent {
    private String driverId;
    private OrderIdentifier orderId;

    public OrderAcceptedEvent() {
    }

    public String getDriverId() {
        return driverId;
    }

    public OrderAcceptedEvent(String driverId, OrderIdentifier orderId) {
        this.driverId = driverId;
        this.orderId = orderId;
    }

    public OrderIdentifier getOrderId() {
        return orderId;
    }
}
