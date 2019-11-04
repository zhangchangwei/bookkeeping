package com.breamer.cloud.secondserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务端高可用启动类
 * @author zhang.penghao
 * @date 2019/3/5 11:35
 */
@SpringBootApplication
@EnableEurekaServer
public class SecondServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondServerApplication.class, args);
    }

}
