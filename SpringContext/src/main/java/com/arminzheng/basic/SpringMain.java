package com.arminzheng.basic;

import com.arminzheng.circular.Account;
import com.arminzheng.construct.Broker;
import com.arminzheng.construct.Customer;
import com.arminzheng.factory.ConnectionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.Arrays;

/**
 * SpringMain
 *
 * @author zy
 * @version 2022/4/10
 */
public class SpringMain {

    private final ApplicationContext ioc;

    {
        ioc = new ClassPathXmlApplicationContext("/applicationContext.xml");
    }

    public static void main(String[] args) {
        SpringMain main = new SpringMain();
        // 0. 工厂模式+bean
        // main.personTest();

        // 1. 注入+property
        // main.injectionTest();

        // 2. 构造器注入
        // main.customerTest();

        // 3. 自动注入 fail
        // main.brokerTest();

        // 4. FactoryBean
        main.factoryBeanTest();

        // 下面两种都是为了避免spring框架侵入 和 整合遗留系统
        // 5. 实例工厂
        main.connectionFactoryTest();

        // 6. 静态工厂
        main.staticConnectionFactoryTest();

        // 7. 简单对象的创建次数（singleton or prototype）
        // main.accountTest();
        // 8. 控制复杂对象的创建次数仅需将isSingleton方法的返回值设为true/false，如果没有使用FactoryBean还是使用scope属性
        //    为什么要控制对象的创建次数：节省内存

        // 9. 初始化
        // main.productTest();
    }

    public void productTest() {
        // Product product = (Product) ioc.getBean("product");
        ClassPathXmlApplicationContext ctx = (ClassPathXmlApplicationContext) ioc;
        ctx.close();
    }

    public void accountTest() {
        Account account = (Account) ioc.getBean("account");
        Account account1 = (Account) ioc.getBean("account");
        System.out.println("account = " + account);
        System.out.println("account1 = " + account1);
    }

    private void personTest() {
        /* 工厂开发步骤：1. 创建类型； 2. 配置文件的配置； 3. 通过工厂类获得对象；*/
        Person person = (Person) ioc.getBean("person");
        System.out.println("person = " + person);
        person.age = 99;
        Person person1 = ioc.getBean("person", Person.class);
        System.out.println("person1 = " + person1);
        /* 以类型来获取bean，当前只能存在一个Person对象（除非设置primary属性）
        Person person2 = ctx.getBean(Person.class);
        System.out.println("person2 = " + person2);*/

        // 获取的是 spring 工厂配置文件中所有bean标签的id值列表
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        System.out.println("beanDefinitionNames = " + Arrays.toString(beanDefinitionNames));

        // 按类型获取bean的id值
        String[] beanNamesForType = ioc.getBeanNamesForType(Person.class);
        System.out.println("beanNamesForType = " + Arrays.toString(beanNamesForType));

        // 判断是否存在指定id值的bean（只判断id）
        System.out.println(ioc.containsBeanDefinition("person"));
        // 判断是否存在指定id值的bean（id和name都能判断）
        System.out.println(ioc.containsBean("person"));

        // name就是别名
        Person personMini = ioc.getBean("person小名或别名", Person.class);
        System.out.println("personMini = " + personMini + " 改名为：" + (personMini.name = "老王"));
        Person personMax = ioc.getBean("逗号隔开", Person.class);
        System.out.println("personMax = " + personMax);
    }

    public void injectionTest() {
        // 通过代码里进行设置属性，会硬编码到class文件中，进而带来耦合，所以Spring带来了注入，通过配置文件来对成员变量进行赋值
        Person person = (Person) ioc.getBean("person");
        person.age = 99;
        System.out.println("person = " + person);
    }

    public void customerTest() {
        Customer customer = (Customer) ioc.getBean("customer");
        System.out.println("customer = " + customer);
        Customer customer0 = (Customer) ioc.getBean("customer0");
        System.out.println("customer0 = " + customer0);
        Customer customer1 = (Customer) ioc.getBean("customer1");
        System.out.println("customer1 = " + customer1);
        Customer customer2 = (Customer) ioc.getBean("customer2");
        System.out.println("customer2 = " + customer2);
        Customer customer3 = (Customer) ioc.getBean("customer3");
        System.out.println("customer3 = " + customer3);
    }

    public void brokerTestFail() {
        // NoSuchBeanDefinitionException
        Broker broker = (Broker) ioc.getBean("broker");
        System.out.println("Broker = " + broker);
    }

    public void factoryBeanTest() {
        Connection connection = (Connection) ioc.getBean("conn");
        System.out.println("connection = " + connection);
        Connection connection1 = (Connection) ioc.getBean("conn");
        System.out.println("connection1 = " + connection1);
        // 加上& and符号就会取工厂对象，而不是加工对象
        ConnectionFactoryBean ctxBean = (ConnectionFactoryBean) ioc.getBean("&conn");
        System.out.println("ctxBean = " + ctxBean);
    }

    private void connectionFactoryTest() {
        Connection connection = (Connection) ioc.getBean("conn2");
        System.out.println("connection = " + connection);
        Connection connection1 = (Connection) ioc.getBean("conn2");
        System.out.println("connection1 = " + connection1);
    }

    private void staticConnectionFactoryTest() {
        Connection connection = (Connection) ioc.getBean("conn3");
        System.out.println("connection = " + connection);
        Connection connection1 = (Connection) ioc.getBean("conn3");
        System.out.println("connection1 = " + connection1);
    }
}
