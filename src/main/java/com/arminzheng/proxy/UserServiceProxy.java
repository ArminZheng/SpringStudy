package com.arminzheng.proxy;

/**
 * UserServiceProxy
 *
 * @author zy
 * @version 2022/4/20
 */
public class UserServiceProxy implements UserService {

    private final UserService userService = new UserServiceImpl();

    @Override
    public void register(User user) {
        System.out.println("log user:" + user);
        userService.register(user);
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("log name = " + name + " login");
        return userService.login(name, password);
    }
}
