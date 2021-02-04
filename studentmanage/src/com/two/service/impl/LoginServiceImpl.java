package com.two.service.impl;

import com.two.dao.impl.LoginImpl;
import com.two.entity.User;
import com.two.service.LoginService;

import java.util.List;

public class LoginServiceImpl implements LoginService {
    @Override
    public List<User> login(String username, String password) {
        LoginImpl login = new LoginImpl();
        List<User> login1 = login.login(username, password);
        return login1;
    }
}
