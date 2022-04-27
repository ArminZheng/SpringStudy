package com.arminzheng.construct;

import java.io.Serializable;

/**
 * Customer
 *
 * @author zy
 * @version 2022/4/12
 */
public class Customer implements Serializable {

    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
