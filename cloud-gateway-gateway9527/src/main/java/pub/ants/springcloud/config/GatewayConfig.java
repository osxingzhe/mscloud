package pub.ants.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author magw
 * @version 1.0
 * @date 2020/8/30 下午2:43
 * @description: No Description
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        RouteLocator build = routes.route("bilibili1", r -> r.path("/bilibili").uri("https://www.bilibili.com")).build();
        return build;
    }
}
