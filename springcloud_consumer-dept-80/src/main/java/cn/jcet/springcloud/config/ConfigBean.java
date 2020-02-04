package cn.jcet.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    /**
     * ribbon的轮询模式
     * IRule
     * RoundRibbonRule 轮询
     * RandomRule 随机
     * AvailabilityFilteringRule 先过滤掉 跳闸 访问故障的服务 对剩下的进行轮询
     * RetryRule 按照轮询获取服务获取获取失败 ，在规定的时间进行重试
     * @return
     */

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
