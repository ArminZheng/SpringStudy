package com.arminzheng.basic;

/**
 * TestI
 *
 * @author zy
 * @version 2022/4/12
 */
public class TestI extends TestII implements ITestI, ITestII, ITestIII {

    static int i = printInt();

    public static int printInt() {
        System.out.println("so i am come in.");
        return 127;
    }

    public static void main(String[] args) {
        TestI testI = new TestI();
        testI.sayI();
        testI.sayII();
    }

    @Override
    public void sayI() {
        ITestI.super.sayI();
    }
}
