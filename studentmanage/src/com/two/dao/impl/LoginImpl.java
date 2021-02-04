package com.two.dao.impl;

import com.two.dao.LoginDao;
import com.two.entity.User;
import com.two.util.BaseDaoUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class LoginImpl extends BaseDaoUtil implements LoginDao {
    @Override
    public List<User> login(String username, String password) {
        String sql="select *from user where username=? and password=? ";
        Object[] obj={username,password};
        try {
            List<User> users = super.selectData(sql, obj, User.class);
            return users;
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

    public static void main(String[] args) {

        LoginImpl login = new LoginImpl();
        List<User> admin = login.login("admin", "666");
        System.out.println(admin);
    }
}
