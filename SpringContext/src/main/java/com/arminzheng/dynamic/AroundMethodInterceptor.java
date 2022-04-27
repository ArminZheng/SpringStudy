package com.arminzheng.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Around
 *
 * @author zy
 * @version 2022/4/24
 */
public class AroundMethodInterceptor implements MethodInterceptor {

    /**
     * 原始方法怎么运行{@link MethodInvocation} 是对{@link Method} 的高级封装
     *
     * <p>{@link MethodInvocation#proceed} 就是原始方法的运行
     *
     * @param methodInvocation 对{@link Method} 的高级封装
     * @return 原始方法的返回值
     * @throws Throwable throws
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(">>>>>>>Around.invoke.start");
        Object result = null;
        try {
            result = methodInvocation.proceed();
        } catch (Throwable e) {
            System.out.println("=======Around.invoke.catch.exception: " + e.getMessage());
            // e.printStackTrace();
        }
        System.out.println("<<<<<<<<Around.invoke.end");
        return result;
    }
}
