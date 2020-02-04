package cn.jcet.springcloud.controller;

import cn.jcet.springcloud.pojo.Dept;
import cn.jcet.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService service;

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") int id){
        return this.service.get(id);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> queryAll(){
        return this.service.queryAll();
    }

    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return this.service.addDept(dept);
    }

}
