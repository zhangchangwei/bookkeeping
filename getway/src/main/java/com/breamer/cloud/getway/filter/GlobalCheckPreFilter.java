package com.breamer.cloud.getway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/6/26
 */
@Component
public class GlobalCheckPreFilter implements GlobalFilter, Ordered {
    private static final String REQUEST_ID = "request_uuid";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println(124);
        System.out.println(124 + " before - " + exchange.getAttribute(REQUEST_ID).toString() + " - " + System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            System.out.println(124 + " after - " + exchange.getAttribute(REQUEST_ID).toString() + " - " + System.currentTimeMillis());
        }));
    }

    @Override
    public int getOrder() {
        return 124;
    }
}
