package com.arminzheng.basic;

import com.arminzheng.factory.ConnectionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * SpringMain
 *
 * @author zy
 * @version 2022/4/10
 */
public class SpringMainNew {

    private final ApplicationContext ioc;

    {
        ioc = new ClassPathXmlApplicationContext("/applicationContextNew.xml");
    }

    public static void main(String[] args) {
        SpringMainNew main = new SpringMainNew();
        main.close();
    }

    public void close() {
        ClassPathXmlApplicationContext ctx = (ClassPathXmlApplicationContext) ioc;
        ConnectionFactoryBean bean = (ConnectionFactoryBean) ctx.getBean("&conn");
        System.out.println("bean = " + bean);
        ctx.close();
    }
}
