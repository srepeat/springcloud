package cn.jcet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * feign与rest Template区别
 *  feign面向接口编程，需要包装一个service接口 (接口调用)
 *  rest 直接在注册中心获取实例+提供者路径获取，符合restful风格编程(地址调用)
 *  都是实现负载均衡
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"cn.jcet.springcloud"})  //开启figen调用
@ComponentScan(basePackages = "cn.jcet.springcloud")
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
