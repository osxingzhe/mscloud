package pub.ants.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: magaowei
 * @Date: 2020/9/5 17:10
 * @Description:
 * @RefreshScope  支持nacos的动态刷新功能
 */
@RestController
@RefreshScope
@Slf4j
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        log.info("-----"+configInfo);
        return configInfo;
    }
}