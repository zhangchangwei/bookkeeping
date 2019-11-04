package com.breamer.cloud.orderclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单客户端启动类
 * @author zhang.penghao
 * @date 2019/3/5 11:08
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderClientApplication.class, args);
    }

}
