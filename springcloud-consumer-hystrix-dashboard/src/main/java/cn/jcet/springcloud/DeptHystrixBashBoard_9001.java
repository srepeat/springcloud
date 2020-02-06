package cn.jcet.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启监控
public class DeptHystrixBashBoard_9001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptHystrixBashBoard_9001.class,args);
    }
}
