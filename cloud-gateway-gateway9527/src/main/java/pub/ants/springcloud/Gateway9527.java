package pub.ants.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author magw
 * @version 1.0
 * @date 2020/8/30 下午2:23
 * @description: No Description
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway9527 {
    public static void main(String[] args) {
        SpringApplication.run(Gateway9527.class,args);
    }
}
