package com.two.service;

import com.two.entity.User;

import java.util.List;

public interface LoginService {
    public List<User> login(String username, String password);
}
