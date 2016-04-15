package com.tuhao.eventlisteners;

import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by apple on 2/29/16.
 */
@Component
public class MessageSubscriber {
    @Autowired
    public MessageSubscriber(OrderEventListener orderEventListener, SimpleMessageListenerContainer simpleMessageListenerContainer, Jackson2JsonMessageConverter messageConverter) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(orderEventListener, "handle");
        messageListenerAdapter.setMessageConverter(messageConverter);
        simpleMessageListenerContainer.setMessageListener(messageListenerAdapter);
    }
}