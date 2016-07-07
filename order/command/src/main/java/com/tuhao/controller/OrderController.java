package com.tuhao.controller;

import com.tuhao.command.order.TakeOrderCommand;
import com.tuhao.command.order.CreateOrderCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private CommandGateway commandGateway;

    @Autowired
    public OrderController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RequestMapping(path = "/orders/create-order-command", method = RequestMethod.POST)
    public void takeOrder(@RequestBody CreateOrderCommand createOrderCommand) {
        commandGateway.send(createOrderCommand);
    }

    @RequestMapping(path = "/orders/take-order-command", method = RequestMethod.POST)
    public void takeOrder(TakeOrderCommand takeOrderCommand) {
        commandGateway.send(takeOrderCommand);
    }
}
