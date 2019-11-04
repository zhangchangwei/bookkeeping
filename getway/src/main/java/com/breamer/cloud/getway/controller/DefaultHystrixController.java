package com.breamer.cloud.getway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/6/17
 */
@RestController
public class DefaultHystrixController {

    @RequestMapping("/fallback")
    public Mono<String> fallBack(){
        return Mono.just("error, jump fallback");
    }
}
