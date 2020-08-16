package pub.ants.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author magw
 * @version 1.0
 * @date 2020/8/16 下午4:22
 * @description: No Description
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
