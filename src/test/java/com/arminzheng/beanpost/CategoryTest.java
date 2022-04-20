package com.arminzheng.beanpost;

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

}