package com.breamer.cloud.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/6/14
 */
@Api(value = "用户接口描述", tags = {"用户接口描述"})
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "测试接口", notes = "测试")
    @GetMapping("/test")
    public String userTest() throws InterruptedException {
        return "hello this is user client";
    }
    @GetMapping("/userGetway")
    public String userGetway() throws InterruptedException {
        System.out.println("*****************************");
        Thread.sleep(5000);
        return "hello this is user getway";
    }

    //TODO 买家登陆
    //TODO 卖家登陆

}
