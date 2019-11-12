package com.breamer.cloud.product.client.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置
 *
 * @author zhang.penghao
 * @date 2019/3/13 13:55
 */
@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "breamer-client";

    @Bean
    public Queue directQueue(){
        return new Queue(QUEUE_NAME, true);
    }
}
