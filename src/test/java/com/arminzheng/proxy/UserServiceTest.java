package com.arminzheng.proxy;

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

    @Test
    public void testI() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("classpath:/applicationContextProxy.xml");
        UserService userService = ioc.getBean("userService", UserService.class);
        userService.register(new User());
        userService.login("zs", "fwkt");
    }
}
