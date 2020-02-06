package cn.jcet.springcloud.service;

import cn.jcet.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    Dept queryById(int id);

    List<Dept> queryAll();

    boolean add(Dept dept);
}
