package com.suretrust.gateway.gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.suretrust.gateway.gateway.constants.Services.PRODUCT_SERVICE;
import static com.suretrust.gateway.gateway.constants.Services.USER_DETAILS;
import static com.suretrust.gateway.gateway.utils.CommonUtil.getLoadBalancedPath;
import static com.suretrust.gateway.gateway.utils.CommonUtil.getPrefixPath;

@Configuration
public class ProductManagement {


    @Bean
    public RouteLocator defaultProductManagementServiceRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(PRODUCT_SERVICE, p -> p.order(3)
                        .path("/")
                        .filters(f -> f.prefixPath(getPrefixPath(PRODUCT_SERVICE)))
                        .uri(getLoadBalancedPath(PRODUCT_SERVICE))
                )
                .build();
    }
}
