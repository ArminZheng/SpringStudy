package com.arminzheng.proxy;

/**
 * UserServiceImpl
 *
 * @author zy
 * @version 2022/4/20
 */
public class UserServiceImpl implements UserService {

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register 业务运算 + dao 操作");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}
