package com.tuhao.view.model;

import com.tuhao.common.id.CarIdentifier;
import com.tuhao.common.id.CarOwnerIdentifier;
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
    private String location;

    protected Order() {
    }

    public Order(CarOwnerIdentifier carOwnerId, OrderIdentifier id) {
        this.id = id.toString();
        this.carOwnerId = carOwnerId.toString();
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
