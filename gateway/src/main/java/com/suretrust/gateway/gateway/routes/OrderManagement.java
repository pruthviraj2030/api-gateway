package com.suretrust.gateway.gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.suretrust.gateway.gateway.constants.Services.ORDER_MANAGEMENT;
import static com.suretrust.gateway.gateway.constants.Services.PRODUCT_SERVICE;
import static com.suretrust.gateway.gateway.utils.CommonUtil.getLoadBalancedPath;
import static com.suretrust.gateway.gateway.utils.CommonUtil.getPrefixPath;

@Configuration
public class OrderManagement {
    @Bean
    public RouteLocator defaultOrderManagementServiceRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(ORDER_MANAGEMENT, p -> p.order(3)
                        .path("/v1/cart/**")
                        .filters(f -> f.prefixPath(getPrefixPath(ORDER_MANAGEMENT)))
                        .uri(getLoadBalancedPath(ORDER_MANAGEMENT))
                )
                .build();
    }
}

