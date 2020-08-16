package pub.ants.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author magw
 * @version 1.0
 * @date 2020/8/16 上午11:06
 * @description: No Description
 */
@Configuration
public class MySelfRule {

    /**
     * 随机
     * @return
     */
    @Bean
    public IRule MyRule(){
        return  new RandomRule();
    }
}
