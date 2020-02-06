package cn.jcet.springcloud.service.impl;

import cn.jcet.springcloud.dao.DeptDao;
import cn.jcet.springcloud.pojo.Dept;
import cn.jcet.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl  implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public Dept queryById(int id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }

    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }
}
