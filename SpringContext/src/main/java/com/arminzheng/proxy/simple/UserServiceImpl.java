package com.arminzheng.proxy.simple;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * UserServiceImpl
 *
 * @author zy
 * @version 2022/4/20
 */
public class UserServiceImpl implements UserService, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register 业务运算 + dao 操作");
        // throw new RuntimeException("test exception!");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.login("zhangshan", "wangwu");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
