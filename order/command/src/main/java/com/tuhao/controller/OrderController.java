package com.tuhao.controller;

import com.tuhao.command.order.AcceptOrderCommand;
import com.tuhao.command.order.CreateOrderCommand;
import com.tuhao.common.id.OrderIdentifier;
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
    public void placeOrder(@RequestBody CreateOrderCommand createOrderCommand) {
        commandGateway.send(createOrderCommand);
    }

    @RequestMapping(path = "/orders/accept-order-command", method = RequestMethod.POST)
    public void placeOrder(AcceptOrderCommand acceptOrderCommand) {
        commandGateway.send(acceptOrderCommand);
    }
}
