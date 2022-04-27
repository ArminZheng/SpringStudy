package com.arminzheng.basic;

/**
 * Person
 *
 * @author zy
 * @version 2022/4/10
 */
public class Person {

    public String name = "张三";
    public Integer age = 98;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Person() {
        System.out.println("就算是私有构造器也会被调用");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
