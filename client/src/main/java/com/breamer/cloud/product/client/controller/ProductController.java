package com.breamer.cloud.product.client.controller;

import com.breamer.cloud.product.client.Client.UserClient;
import com.breamer.cloud.product.client.config.RabbitMQConfig;
import com.breamer.cloud.product.client.domain.entity.Order;
import com.breamer.cloud.product.client.domain.entity.ProductInfo;
import com.breamer.cloud.product.client.service.ProductService;
import com.breamer.cloud.product.client.socketserver.WebSocketServer;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @date 2019/3/5 15:03
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping(value = "/product")
@RefreshScope
//默认fallBack发方法
//@DefaultProperties(defaultFallback = "defaultFallback")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private UserClient userClient;
    @Value("${product.port}")
    private String port;

    @GetMapping
    public List<ProductInfo> list(){
        return productService.findAll();
    }
    @GetMapping("/port")
    public String port(){
        return "product port : " + port;
    }


    //指定fallback方法
//    @HystrixCommand(fallbackMethod = "fallback")
    // 以下超时设置不支持feign
//    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
//    })
    //熔断设置 - 多次调用失败后 服务设定时间内不可用
    //circuitBreaker.enabled
    //circuitBreaker.requestVolumeThreshold
    //circuitBreaker.sleepWindowInMilliseconds
    //circuitBreaker.errorThresholdPercentage  请求错误频率  60 - 错误百分之60
    @GetMapping("hello")
    public String hello(){
        System.out.println("trace product");
        return userClient.hello();
    }

    @GetMapping("test")
    public void test(){
        Order order = new Order();
        order.setOrderId("1001");
        order.setOrderName("测试消息传送");
        order.setTime(String.valueOf(System.currentTimeMillis()));
        amqpTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME,order);
    }

    @GetMapping("test/web")
    public void testWebSocket(){
        WebSocketServer.sendInfo("测试消息推送");
    }

    private String fallback(){
        return "指定fall back";
    }

    private String defaultFallback(){
        return "默认fall back";
    }

}
