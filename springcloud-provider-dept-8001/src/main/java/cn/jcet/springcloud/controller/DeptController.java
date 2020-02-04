package cn.jcet.springcloud.controller;

import cn.jcet.springcloud.pojo.Dept;
import cn.jcet.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discovery;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Integer id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }


    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> services = discovery.getServices();
        System.out.println("discovery services==>"+services);

        List<ServiceInstance> instances = discovery.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        instances.forEach(item ->{
            System.out.println(
                    item.getHost()+"\t"+
                    item.getServiceId()+"\t"+
                    item.getPort()+"\t"+
                    item.getUri()
            );
        });

        return this.discovery;
    }
}
