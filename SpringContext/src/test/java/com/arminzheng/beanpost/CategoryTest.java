package com.arminzheng.beanpost;

import com.arminzheng.proxy.User;
import com.arminzheng.proxy.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * CategoryTest
 *
 * @author zy
 * @version 2022/4/20
 */
public class CategoryTest {

    private ApplicationContext ioc;

    @Before
    public void setIoc() {
        ioc = new ClassPathXmlApplicationContext("classpath*:/applicationContextBeanPost.xml");
    }

    @Test
    public void testI() {
        Category category = ioc.getBean("category", Category.class);
        System.out.println("category = " + category);
    }

    @Test
    public void testII() {
        UserService userService = ioc.getBean("userService", UserService.class);
        userService.login("first", "login");
        userService.register(new User());
    }
}