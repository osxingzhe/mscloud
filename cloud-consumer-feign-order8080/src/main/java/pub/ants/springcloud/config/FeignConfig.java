package pub.ants.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author magw
 * @version 1.0
 * @date 2020/8/23 上午10:20
 * @description: No Description
 */
@Component
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
