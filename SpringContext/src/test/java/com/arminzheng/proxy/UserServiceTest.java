package com.arminzheng.proxy;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * UserServiceTest
 *
 * @author zy
 * @version 2022/4/21
 */
public class UserServiceTest {
    ApplicationContext ioc;

    @Before
    public void before() {
        ioc = new ClassPathXmlApplicationContext("classpath:/applicationContextProxy.xml");
    }

    @Test
    public void testI() {
        UserService userService = ioc.getBean("userService", UserService.class);
        userService.register(new User());
        userService.login("zs", "my_password");
    }
}
