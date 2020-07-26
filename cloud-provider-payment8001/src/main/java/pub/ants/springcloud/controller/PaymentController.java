package pub.ants.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pub.ants.springcloud.entities.CommonResult;
import pub.ants.springcloud.entities.Payment;
import pub.ants.springcloud.service.PaymentService;

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

    @PostMapping(value = "/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result =  paymentService.create(payment);
        log.info("插入结果是：{}",result);
        if(result > 0){
            return new CommonResult<Integer>(200,"插入成功",result);
        }else{
            return new  CommonResult<Integer>(400,"插入失败");
        }

    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment result =  paymentService.getPaymentById(id);
        log.info("查询结果是：{}",result);
        if(result != null){
            return new CommonResult<Payment>(200,"查询成功",result);
        }else{
            return new  CommonResult<Payment>(400,"数据不存在，id="+id);
        }
    }

}
