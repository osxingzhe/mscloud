package pub.ants.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author magw
 * @version 1.0
 * @date 2020/8/22 下午6:17
 * @description: No Description
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeign8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeign8080.class,args);
    }
}
