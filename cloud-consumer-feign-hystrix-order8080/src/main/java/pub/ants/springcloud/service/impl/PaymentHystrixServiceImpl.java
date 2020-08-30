package pub.ants.springcloud.service.impl;

import org.springframework.stereotype.Component;
import pub.ants.springcloud.service.PaymentHystrixService;

/**
 * @author magw
 * @version 1.0
 * @date 2020/8/23 下午6:16
 * @description: No Description
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "paymentInfo_ok 降级服务";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "paymentInfo_timeout 降级服务";
    }
}
