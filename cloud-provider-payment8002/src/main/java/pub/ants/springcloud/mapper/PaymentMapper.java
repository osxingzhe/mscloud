package pub.ants.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pub.ants.springcloud.entities.Payment;

/**
 * @author magw
 * @version 1.0
 * @date 2020/7/26 下午11:16
 * @description: No Description
 */
@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
