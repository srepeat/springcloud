package cn.jcet.myRule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CodeRule {

    @Bean
    public IRule myRule(){
        return new MyRandomRule();
    }
}
