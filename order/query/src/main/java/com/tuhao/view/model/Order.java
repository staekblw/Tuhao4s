package com.tuhao.view.model;

import com.tuhao.common.id.OrderIdentifier;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_view")
public class Order {

    @Id
    private String id;
    private String driverId;
    private String carOwnerId;

    private String orderStatus;

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    protected Order() {
    }

    public Order(String driverId, String carOwnerId, OrderIdentifier id) {
        this.id = id.toString();
        this.driverId = driverId;
        this.carOwnerId = carOwnerId;
    }

    public String getId() {
        return id;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getCarOwnerId() {
        return carOwnerId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
