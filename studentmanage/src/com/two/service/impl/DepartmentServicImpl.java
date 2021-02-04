package com.two.service.impl;

import com.two.dao.impl.DepartmentImpl;
import com.two.entity.Department;
import com.two.service.DepartementService;

import java.util.List;

public class DepartmentServicImpl implements DepartementService {
    @Override
    public List<Department> selectAll() {
        DepartmentImpl department = new DepartmentImpl();
        List<Department> departments = department.selectAll();

        return departments;
    }

    @Override
    public int delete(String dno) {
        DepartmentImpl department = new DepartmentImpl();
        int delete = department.delete(dno);
        return delete;
    }

    @Override
    public int update( String after_dname, String dno) {
        DepartmentImpl department = new DepartmentImpl();
        int update = department.update( after_dname, dno);
        return update;
    }

    @Override
    public int add(String dno, String dname) {
        DepartmentImpl department = new DepartmentImpl();
        int add = department.add(dno, dname);

        return add;
    }


}
