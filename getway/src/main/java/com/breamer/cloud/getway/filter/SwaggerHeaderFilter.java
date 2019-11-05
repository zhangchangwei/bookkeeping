package com.breamer.cloud.getway.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/6/25
 */
@Component
public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory {

    private static final String HEADER_NAME = "X-Forwarded-Prefix";

    private static final String HOST_NAME = "X-Forwarded-Host";

    @Override

    public GatewayFilter apply(Object config) {

        return (exchange, chain) -> {

            ServerHttpRequest request = exchange.getRequest();

            String path = request.getURI().getPath();

            if (!StringUtils.endsWithIgnoreCase(path, "/v2/api-docs")) {

                return chain.filter(exchange);

            }

            String basePath = path.substring(0, path.lastIndexOf("/v2/api-docs"));

            ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();

            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();

            return chain.filter(newExchange);

        };

    }

}
