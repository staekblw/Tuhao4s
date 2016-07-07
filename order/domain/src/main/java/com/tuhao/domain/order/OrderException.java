package com.tuhao.domain.order;

/**
 * Created by lbwang on 7/6/16.
 */
public class OrderException extends RuntimeException {

    public static final OrderException CAN_NOT_TAKEN_ORDER = new OrderException("can not taken order");
    public static final OrderException CAN_NOT_CANCEL_ORDER = new OrderException("can not cancel order");

    public OrderException(String message) {
        super(message);
    }
}
