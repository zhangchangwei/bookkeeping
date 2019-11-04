package com.breamer.cloud.getway.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * Swagger配置
 *
 * @author zhang.penghao
 * @date 2018/7/11 11:42
 */
@Component
@Primary
public class SwaggerProvider implements SwaggerResourcesProvider {

    @Autowired
    private RouteLocator routeLocator;
//    @Autowired
//    private RouteDefinitionLocator routeDefinitionLocator;


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        routeLocator.getRoutes().subscribe(route -> {
            System.out.println(route);
            System.out.println(route.getUri());
            System.out.println(route.getUri().toString().substring(4));
        });
        System.out.println("********************");
//        System.out.println("********************");
//        routeDefinitionLocator.getRouteDefinitions().subscribe(System.out::println);
//		resources.add(swaggerResource("用户系统","/user-client/v2/api-docs","2.0"));
//        resources.add(swaggerResource("订单系统","/order-client/v2/api-docs","2.0"));
        //动态获取
        routeLocator.getRoutes().subscribe(route -> {
                resources.add(swaggerResource(
                        route.getId(),route.getUri().toString().substring(4) + "/v2/api-docs","2.0"));
        });
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource resource = new SwaggerResource();
        resource.setName(name);
        resource.setLocation(location);
        resource.setSwaggerVersion(version);
        return resource;
    }
}
