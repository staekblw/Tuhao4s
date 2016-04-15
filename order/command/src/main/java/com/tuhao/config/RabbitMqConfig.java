package com.tuhao.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by apple on 2/29/16.
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
public class RabbitMqConfig {
    @Autowired
    private Environment env;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        String queueName = "order.events";
        Queue queue = new Queue(queueName);

        CachingConnectionFactory cachingConnectionFactory = cachingConnectionFactory();
        RabbitAdmin rabbitAdmin = new RabbitAdmin(cachingConnectionFactory);
        rabbitAdmin.declareQueue(queue);

        String exchangeTopic = "order";
        TopicExchange topicExchange = new TopicExchange(exchangeTopic);
        rabbitAdmin.declareExchange(topicExchange);
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(topicExchange).with(queueName));

        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setRoutingKey(queueName);
        rabbitTemplate.setQueue(queueName);
        rabbitTemplate.setExchange(exchangeTopic);

        Jackson2JsonMessageConverter messageConverter = jackson2JsonMessageConverter();
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    CachingConnectionFactory cachingConnectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setAddresses("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        cachingConnectionFactory.setPort(5672);
        return cachingConnectionFactory;
    }
}
