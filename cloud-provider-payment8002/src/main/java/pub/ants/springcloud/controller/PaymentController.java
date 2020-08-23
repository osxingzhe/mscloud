package pub.ants.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import pub.ants.springcloud.entities.CommonResult;
import pub.ants.springcloud.entities.Payment;
import pub.ants.springcloud.service.PaymentService;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author magw
 * @version 1.0
 * @date 2020/7/26 下午11:28
 * @description: No Description
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result =  paymentService.create(payment);
        log.info("插入结果是：{}",result);
        if(result > 0){
            return new CommonResult<Integer>(200,"插入成功，端口号："+serverPort,result);
        }else{
            return new  CommonResult<Integer>(400,"插入失败");
        }

    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment result =  paymentService.getPaymentById(id);
        log.info("查询结果是：{}",result);
        if(result != null){
            return new CommonResult<Payment>(200,"查询成功，端口号："+serverPort,result);
        }else{
            return new  CommonResult<Payment>(400,"数据不存在，id="+id);
        }
    }

    /**
     * 获取注册信息
     * @return
     */
    @GetMapping(value = "/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.stream().forEach((name)->{
            log.info("****element"+name);
        });

        services.stream().forEach((name)->{
            List<ServiceInstance> instances = discoveryClient.getInstances(name);
            instances.stream().forEach((instance)->{
                log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort());
            });
        });
        return discoveryClient;
    }

    @GetMapping(value="/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
