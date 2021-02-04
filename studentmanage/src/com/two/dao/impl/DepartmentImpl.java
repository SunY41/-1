package com.two.dao.impl;

import com.two.dao.DepartmentDao;
import com.two.entity.Department;
import com.two.entity.User;
import com.two.util.BaseDaoUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentImpl extends BaseDaoUtil implements DepartmentDao {
    @Override
    public List<Department> selectAll() {
        String sql="select *from department";
        Object [] obj ={};
        try {
            List<Department> departments = super.selectData(sql, obj, Department.class);
            Department department1 = new Department();

            return departments;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(String dno) {
        String sql="delete from department where dno=?";
        Object [] obj={dno};
        try {
            int i = super.updateData(sql, obj);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(  String after_dname,String dno) {
        String sql="update department set dname=? where dno=?";
        Object[] obj={ after_dname,dno};
        try {
            int i = super.updateData(sql, obj);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int add(String dno, String dname) {
       String sql="insert into department (dno,dname) values (?,?)";
       Object [] obj ={dno,dname};
        try {
            int i = super.updateData(sql, obj);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static void main(String[] args) {


        }


    }




