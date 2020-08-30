package pub.ants.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author magw
 * @version 1.0
 * @date 2020/8/23 下午2:59
 * @description: No Description
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_ok,id="+id;
    }

    /**
     * 3秒超时访问访问
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod ="fallbackMethodOutTime",
    commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_timeout(Integer id){
        int time= 5;
        try{
            TimeUnit.SECONDS.sleep(time);
        }catch (Exception e){e.printStackTrace();}
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_timeout,耗时"+time+"秒钟,id="+id;
    }
    public String fallbackMethodOutTime(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_timeout fallbackMethod";
    }

    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            // 请求次数
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            // 时间窗口期
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            // 失败率达到多少开启断路器
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试";
    }

}
