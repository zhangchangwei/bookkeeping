package com.breamer.cloud.getway;

import com.netflix.hystrix.Hystrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.netflix.hystrix.HystrixProperties;
import org.springframework.context.annotation.Bean;

/**
* 网关实现
*
* @author zhang.penghao
* @date  2019/6/14
*/
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

//    @Bean
//    public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient, DiscoveryLocatorProperties properties) {
//        return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
//    }


    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
    @ConfigurationProperties("spring.cloud.gateway")
    @RefreshScope
    public GatewayProperties refreshGateway(){
        return new GatewayProperties();
    }
    @ConfigurationProperties( prefix = "hystrix")
    @RefreshScope
    public HystrixProperties refreshHystrix(){
        return new HystrixProperties();
    }
}
