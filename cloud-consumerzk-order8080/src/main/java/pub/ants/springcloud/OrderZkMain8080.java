package pub.ants.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author magw
 * @version 1.0
 * @date 2020/8/9 上午8:25
 * @description: No Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain8080.class,args);
    }
}
