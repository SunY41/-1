package com.two.service;

import com.two.entity.Department;

import java.util.List;

public interface DepartementService {
    public List<Department> selectAll();
    public int delete(String dno);
    public int update(String after_dname,String dno);
    public int add(String dno,String dname);
}
