package pub.ants.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pub.ants.springcloud.entities.CommonResult;
import pub.ants.springcloud.entities.Payment;

/**
 * @author magw
 * @version 1.0
 * @date 2020/7/29 下午10:45
 * @description: No Description
 *   RestTemplate提供了多种便捷访问远程Http服务的防范。
 *   是一种简单便捷访问RESTFul服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集
 */
@RestController
@Slf4j
public class OrderController {

    // public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create( Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

}
