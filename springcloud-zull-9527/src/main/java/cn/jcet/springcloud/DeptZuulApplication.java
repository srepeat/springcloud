package cn.jcet.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul的作用  实现过滤
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableZuulProxy  //开启网关代理  getway
public class DeptZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptZuulApplication.class,args);
    }
}
