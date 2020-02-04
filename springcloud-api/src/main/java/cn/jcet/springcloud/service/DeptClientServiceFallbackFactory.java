package cn.jcet.springcloud.service;

import cn.jcet.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务降级与服务熔断
 *
 * 服务熔断 ==》 服务端 某个服务超时或者异常，引起熔断  例如保险丝
 *
 * 服务降级 ==》 客户端 ~ 整体网络负载考虑 当某个服务熔断或者关闭之后不再被调用
 *              此时客户端可以准备一个FallbackFactory返回一个默认的缺省值，
 *              整体服务水平下降 可以给用户一个提醒，请求真实存在
 */

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(int id) {
                return new Dept().setDeptno(id)
                        .setDname("id=>"+id+"没有可用信息，服务降级，null==@hystrix")
                        .setDb_source("this not databases is mysql");
            }

            @Override
            public List<Dept> queryAll() {
               Dept dept = new Dept().setDeptno(0)
                        .setDname("id=>没有可用信息，服务降级，null==@hystrix")
                        .setDb_source("this not databases is mysql");
                List<Dept> list = new ArrayList<>();
                list.add(dept);
                return list;
            }

            @Override
            public boolean addDept(Dept dept) {
                return true;
            }
        };
    }
}
