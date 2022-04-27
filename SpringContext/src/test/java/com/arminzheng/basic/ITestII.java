package com.arminzheng.basic;

/**
 * CustomerTest
 *
 * @author zy
 * @version 2022/4/12
 */
public interface ITestII {

    default void sayI(){
        System.out.println("我是你舅");
    }
}