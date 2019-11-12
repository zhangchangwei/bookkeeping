package com.breamer.cloud.orderclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品服务调用
 *
 * @author zhang.penghao
 * @date 2019/3/5 15:51
 */
@FeignClient(name = "product-client")
@RequestMapping("/product-client")
public interface ProductClient {

    @GetMapping("/product/hello")
    String hello();
}
