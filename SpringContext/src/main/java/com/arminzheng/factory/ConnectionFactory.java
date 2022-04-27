package com.arminzheng.factory;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 实例工厂：new ConnectionFactory().getConnection();
 *
 * @author zy
 * @version 2022/4/12
 */
@Data
public class ConnectionFactory {

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
    public Connection getConnection() {
        // 由于JVM加载类文件时会执行其中的静态代码块，
        // 从Driver类的源码中可以看到该静态代码块执行的操作是：将mysql的driver注册到系统的DriverManager中。
        // 1. 新建一个mysql的driver对象 2. 将这个对象注册到DriverManager中
        Connection connection = null;
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
