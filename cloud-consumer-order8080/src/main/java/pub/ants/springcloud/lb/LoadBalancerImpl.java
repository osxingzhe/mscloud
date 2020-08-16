package pub.ants.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author magw
 * @version 1.0
 * @date 2020/8/16 下午4:24
 * @description: No Description
 */
@Component
@Slf4j
public class LoadBalancerImpl implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = atomicInteger.get();
            next = current>=Integer.MAX_VALUE?0:current+1;
            // cas 不满足自旋
        }while (!this.atomicInteger.compareAndSet(current,next));
        log.info("第几次访问，此处 next value is:{}",next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        // 取下标
        int index = getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
