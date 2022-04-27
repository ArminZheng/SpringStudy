package com.arminzheng.proxy.dynamic.cglib;

import com.arminzheng.proxy.simple.User;

/**
 * UserServiceImpl
 *
 * @author zy
 * @version 2022/4/20
 */
public class UserService {

    public void register(User user) {
        System.out.println("UserService.register 业务运算 + dao 操作");
        // throw new RuntimeException("test exception!");
    }

    public boolean login(String name, String password) {
        System.out.println("UserService.login");
        return true;
    }
}
