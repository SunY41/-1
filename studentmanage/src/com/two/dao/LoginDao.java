package com.two.dao;

import com.two.entity.User;

import java.util.List;

public interface LoginDao {
    public List<User> login(String username, String password);
}
