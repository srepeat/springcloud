package cn.jcet.springcloud.dao;

import cn.jcet.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(Dept Dept);

    public Dept queryById(@Param("id") Integer id);

    public List<Dept> queryAll();
}
