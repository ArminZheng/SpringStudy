package com.arminzheng.proxy.simple;

/**
 * UserService
 *
 * @author zy
 * @version 2022/4/20
 */
public interface UserService {

    void register(User user);

    boolean login(String name, String password);
}
