package com.breamer.cloud.orderclient.controller;

import com.breamer.cloud.orderclient.client.ProductClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @date 2019/3/5 16:40
 */
@Api(value = "订单接口描述", tags = {"订单接口描述"})
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {
    @Value("${test.port}")
    private String port;

    @Autowired
    private ProductClient productClient;

    @GetMapping
    public String get(){
        return productClient.hello();
    }

    @ApiOperation(value = "测试接口", notes = "测试")
    @GetMapping("/test")
    public String getTest(){
        return "hello order config : " + port;
    }
}
