package com.breamer.cloud.getway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/6/26
 */
@Component
public class GlobalCheckOrderFilter implements GlobalFilter, Ordered {
    private static final String REQUEST_ID = "request_uuid";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println(123);
        String id = UUID.randomUUID().toString();
        System.out.println(123 + " before - " + id + " - " + System.currentTimeMillis());
        exchange.getResponse();

        exchange.getAttributes().put(REQUEST_ID, id);
        return chain.filter(exchange).then( Mono.defer(() -> checkAfterResponse(exchange)));
    }

    @Override
    public int getOrder() {
        return 123;
    }

    public Mono<Void> checkAfterResponse(ServerWebExchange exchange) {
        System.out.println(123 + " after - " + exchange.getAttribute(REQUEST_ID).toString() + " - " + System.currentTimeMillis());
        return Mono.empty();
    }
}
