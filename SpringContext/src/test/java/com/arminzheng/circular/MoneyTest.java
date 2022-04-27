package com.arminzheng.circular;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Circular Reference
 *
 * @author zy
 * @version 2022/4/20
 */
public class MoneyTest {

    private ApplicationContext ioc;

    @Before
    public void setIoc() {
        ioc = new ClassPathXmlApplicationContext("classpath*:/applicationContextCycle.xml");
    }

    /** 会出现循环依赖问题 */
    @Test
    public void testI() {
        // BeanCurrentlyInCreationException: Error creating bean with name 'account':
        // Requested bean is currently in creation: Is there an unresolvable circular reference?
        Account account = ioc.getBean("a", Account.class);
        System.out.println("account = " + account);
    }

    /** 会出现循环依赖问题 */
    @Test
    public void testII() {
        // BeanCurrentlyInCreationException: Error creating bean with name 'accountI':
        // Requested bean is currently in creation: Is there an unresolvable circular reference?
        Account accountI = ioc.getBean("accountI", Account.class);
        System.out.println("accountI = " + accountI);
        System.out.println("accountI.getId() = " + accountI.getId());
        System.out.println("accountI.getMoney() = " + accountI.getMoney());
        // 如果是 原型模式 ，则两个中有一个是单例，就能终结循环 circular，而如果都为 原型模型｜多例 则 Spring 无法解决
        Money moneyI = ioc.getBean("moneyI", Money.class);
        System.out.println("moneyI = " + moneyI);
        Account accountII = ioc.getBean("accountI", Account.class);
        System.out.println("accountII = " + accountII);
    }
}
