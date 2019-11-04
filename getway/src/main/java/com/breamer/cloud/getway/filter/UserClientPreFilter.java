package com.breamer.cloud.getway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/6/27
 */
@Component
public class UserClientPreFilter extends AbstractGatewayFilterFactory implements Ordered{
    @Override
    public GatewayFilter apply(Object config) {
        return ((exchange, chain) -> {
            String path = exchange.getRequest().getURI().getPath();
            String uuid = exchange.getAttribute("request_uuid") == null ? "123456789": exchange.getAttribute("request_uuid");
            System.out.println(125  + "path:{" + path + "} before - " + uuid + " - " + System.currentTimeMillis());
            return chain.filter(exchange);
        });
    }

    @Override
    public int getOrder() {
        return 125;
    }


}
