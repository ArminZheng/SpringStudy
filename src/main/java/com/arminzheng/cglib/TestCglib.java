package com.arminzheng.cglib;

import com.arminzheng.proxy.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * TestCglib
 *
 * @author zy
 * @version 2022/4/26
 */
public class TestCglib {
    public static void main(String[] args) {
        // 1 create primitive object
        UserService userService = new UserService();
        /* 2 通过cglib方式创建动态代理对象 */
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(TestCglib.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());

        MethodInterceptor methodInterceptor =
                new MethodInterceptor() {
                    /**
                     * 等同于 InvocationHandle
                     *
                     * @param o 创建好后的代理对象本身，也就是执行时的自己（一般很少使用）
                     * @param method 原始方法
                     * @param objects 原始方法参数
                     * @param methodProxy
                     * @return result
                     * @throws Throwable exception
                     */
                    @Override
                    public Object intercept(
                            Object o, Method method, Object[] objects, MethodProxy methodProxy)
                            throws Throwable {
                        System.out.println("methodProxy = " + methodProxy);
                        System.out.println(">>>>>> Cglib log in >>>>>");
                        Object invoke = method.invoke(userService, objects);
                        System.out.println("<<<<<< Cglib log out <<<<<");

                        // StackOverflowError 代理后的对象，会被递归
                        // ((UserService) o).register(new User());
                        return invoke;
                    }
                };
        enhancer.setCallback(methodInterceptor);

        UserService userServiceProxy = (UserService) enhancer.create();

        userServiceProxy.login("hello", "myhello");
        userServiceProxy.register(new User());
    }
}
