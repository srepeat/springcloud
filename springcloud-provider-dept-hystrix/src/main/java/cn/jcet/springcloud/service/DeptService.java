package cn.jcet.springcloud.service;

import cn.jcet.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    public boolean addDept(Dept Dept);

    public Dept queryById(Integer id);

    public List<Dept> queryAll();
}
