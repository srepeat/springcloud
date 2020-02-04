package cn.jcet.springcloud.service;

import cn.jcet.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept queryById(Integer id);

    public List<Dept> queryAll();
}
