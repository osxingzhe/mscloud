package pub.ants.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.ants.springcloud.entities.Payment;
import pub.ants.springcloud.mapper.PaymentMapper;
import pub.ants.springcloud.service.PaymentService;

/**
 * @author magw
 * @version 1.0
 * @date 2020/7/26 下午11:26
 * @description: No Description
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
