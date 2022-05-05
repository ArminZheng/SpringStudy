package com.arminzheng.proxy.test;

import com.arminzheng.proxy.simple.User;
import com.arminzheng.proxy.simple.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * UserServiceTest
 *
 * @author zy
 * @version 2022/4/21
 */
public class UserServiceTest {

    public static void main(String[] args) {
        // sun.misc.ProxyGenerator 341行 if (saveGeneratedFiles) 根据这个方法查看生成的方法
        // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("classpath:/applicationContextProxy.xml");
        UserService simpleUserService = ioc.getBean("simpleUserService", UserService.class);
        UserService userService = ioc.getBean("userServiceImpl2", UserService.class);
        userService.register(new User());
        userService.login("zs", "my_password");
    }
}
