package com.tuhao.gateway;

import org.axonframework.domain.EventMessage;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutBoundGateway {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @EventHandler
    public void on(EventMessage event) {
        rabbitTemplate.convertAndSend(event.getPayload());
    }
}
