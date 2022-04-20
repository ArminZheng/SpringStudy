package com.arminzheng.proxy;

/**
 * User
 *
 * @author zy
 * @version 2022/4/20
 */
public class User {

    private String username;
    private String password;

    public static void main(String[] args) {
        UserService serviceProxy = new UserServiceProxy();
        serviceProxy.login("john", "john123");
        // Instantiation of utility class 'User' 实例化一个工具类
        // 原因：在对象的Class中只存在static静态变量或方法 会被判断为工具类，new 对象会显示为多余操作
        serviceProxy.register(new User());
    }
}
