package cn.jcet.springcloud;

import cn.jcet.myRule.CodeRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients
@EnableEurekaClient  //客户端可以直接调用
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = CodeRule.class)
public class DeptConsumer_80 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
