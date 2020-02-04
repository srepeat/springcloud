package cn.jcet.springcloud.controller;

import cn.jcet.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,boolean.class);
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> quertAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }


}
