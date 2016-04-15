package com.tuhao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by apple on 2/29/16.
 */
@Configuration
@Import(RabbitMqConfig.class)
@ImportResource("axon-context.xml")
public class AppConfig {
}
