package pub.ants.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author magw
 * @version 1.0
 * @date 2020/7/29 下午10:41
 * @description: No Description
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8080.class,args);
    }
}
