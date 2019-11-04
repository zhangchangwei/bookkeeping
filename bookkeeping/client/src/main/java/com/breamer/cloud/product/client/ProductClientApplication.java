package com.breamer.cloud.product.client;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.sleuth.autoconfig.SleuthProperties;
import org.springframework.cloud.sleuth.zipkin2.ZipkinProperties;

/**
 * 客户端启动类
 *
 * @author zhang.penghao
 * @date 2019/3/5 10:20
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
@EnableFeignClients
public class ProductClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductClientApplication.class, args);
    }

    @ConfigurationProperties("spring.zipkin")
    @RefreshScope
    public ZipkinProperties refreshZipkin() {
        return new ZipkinProperties();
    }

    @ConfigurationProperties("spring.sleuth")
    @RefreshScope
    public SleuthProperties refreshSleuth() {
        return new SleuthProperties();
    }

    @ConfigurationProperties( prefix = "spring.jpa")
    @RefreshScope
    public JpaProperties refreshJpa() {
        return new JpaProperties();
    }

    @ConfigurationProperties(prefix = "spring.rabbitmq")
    @RefreshScope
    public RabbitProperties refreshRabbitMQ() {
        return new RabbitProperties();
    }
}
