package cn.jcet.springcloud.controller;

import cn.jcet.springcloud.pojo.Dept;
import cn.jcet.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") int id){
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

    @GetMapping("/dept/list")
    public List<Dept> queyAll(){
        return deptService.queryAll();
    }

    @PostMapping("/dept/add")
    public boolean add(Dept dept){
        return deptService.add(dept);
    }
}
