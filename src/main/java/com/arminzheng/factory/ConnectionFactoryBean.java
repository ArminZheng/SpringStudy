package com.arminzheng.factory;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ConnectionFactoryBean
 *
 * @author zy
 * @version 2022/4/12
 */
@Data
public class ConnectionFactoryBean implements FactoryBean<Connection> {

    private String className;
    private String url;
    private String username;
    private String password;

    /**
     * 用于创建复杂对象
     *
     * @return
     * @throws Exception
     */
    @Override
    public Connection getObject() throws Exception {
        // 由于JVM加载类文件时会执行其中的静态代码块，
        // 从Driver类的源码中可以看到该静态代码块执行的操作是：将mysql的driver注册到系统的DriverManager中。
        // 1. 新建一个mysql的driver对象 2. 将这个对象注册到DriverManager中
        Class.forName(className);
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    @Override
    public boolean isSingleton() {
        // 只需要修改这一处就能切换 单例 和 prototype 了

        // 连接对象Connection不能被共用，得设为false
        // SqlSessionFactory在mybatis里面是一个重量级资源（占内存，只创建一个；线程安全的；），得设为true
        return false;
    }
}
