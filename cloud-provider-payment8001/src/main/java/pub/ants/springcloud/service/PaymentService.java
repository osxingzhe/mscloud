package pub.ants.springcloud.service;

import org.apache.ibatis.annotations.Param;
import pub.ants.springcloud.entities.Payment;

/**
 * @author magw
 * @version 1.0
 * @date 2020/7/26 下午11:26
 * @description: No Description
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}