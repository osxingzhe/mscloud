package pub.ants.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pub.ants.springcloud.service.PaymentHystrixService;

/**
 * @author magw
 * @version 1.0
 * @date 2020/8/23 下午4:19
 * @description: No Description
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback="defaultFallbackMethodOutTime")
public class PaymentHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(
            //fallbackMethod ="fallbackMethodOutTime",
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
            })
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_timeout(id);
    }
    public String fallbackMethodOutTime(Integer id){
        return "系统忙，请稍后再试";
    }
    public String defaultFallbackMethodOutTime(){
        return "默认兜底方法系统忙，请稍后再试";
    }
}
