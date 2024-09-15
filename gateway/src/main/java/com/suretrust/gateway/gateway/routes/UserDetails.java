package com.suretrust.gateway.gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.suretrust.gateway.gateway.constants.Services.USER_DETAILS;
import static com.suretrust.gateway.gateway.utils.CommonUtil.getLoadBalancedPath;
import static com.suretrust.gateway.gateway.utils.CommonUtil.getPrefixPath;

@Configuration
public class UserDetails {

    @Bean
    public RouteLocator defaultAssignmentServiceRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(USER_DETAILS, p -> p.order(3)
                        .path("/token",
                                "/user/**")
                        .filters(f -> f.prefixPath(getPrefixPath(USER_DETAILS)))
                        .uri(getLoadBalancedPath(USER_DETAILS))
                )
                .build();
    }
}
