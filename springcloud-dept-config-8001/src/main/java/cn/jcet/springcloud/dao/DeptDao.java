package cn.jcet.springcloud.dao;

import cn.jcet.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    Dept queryById(@Param("id") int id);

    List<Dept> queryAll();

    boolean addDept(Dept dept);
}
