package com.breamer.cloud.product.client.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/6/14
 */
@FeignClient(name = "user-client")
@RequestMapping("/user-client")
public interface UserClient {
    @GetMapping("/user/test")
    String hello();

}
