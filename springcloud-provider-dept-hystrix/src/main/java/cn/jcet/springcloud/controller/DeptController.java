package cn.jcet.springcloud.controller;

import cn.jcet.springcloud.pojo.Dept;
import cn.jcet.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;


    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept queryById(@PathVariable("id") int id){
        Dept dept = deptService.queryById(id);
        if(dept == null){
            throw new RuntimeException("id=>"+id+",不存在该用户或者信息有误！");
        }
        return dept;
    }

    //备用方法
    public Dept hystrixGet(@PathVariable("id") int id){

        return new Dept()
                .setDeptno(id)
                .setDname("id=>"+id+"没有对应得信息，null ==@hystrix")
                .setDb_source("this not databases in mysql");
    }

}
