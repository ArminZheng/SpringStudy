package com.arminzheng.converter;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MyDateConverterTest
 *
 * @author zy
 * @version 2022/4/18
 */
public class MyDateConverterTest {

    private ApplicationContext ioc;

    @Before
    public void setIoc() {
        ioc = new ClassPathXmlApplicationContext("/applicationContextConverter.xml");
    }

    @Test
    public void testI() {
        Person person = ioc.getBean("person", Person.class);
        System.out.println("person = " + person);
    }
}
