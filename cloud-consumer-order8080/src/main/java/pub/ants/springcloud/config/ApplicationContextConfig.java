package pub.ants.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author magw
 * @version 1.0
 * @date 2020/7/29 下午11:07
 * @description: No Description
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // 注释掉，使用自己的负载均衡算法
    //@LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
