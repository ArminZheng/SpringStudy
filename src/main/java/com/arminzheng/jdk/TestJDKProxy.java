package com.arminzheng.jdk;

import com.arminzheng.proxy.User;
import com.arminzheng.proxy.UserService;
import com.arminzheng.proxy.UserServiceImpl;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TestJDKProxy
 *
 * @author zy
 * @version 2022/4/24
 */
public class TestJDKProxy {
    public static void main(String[] args) {
        // 1. 原始对象
        final UserService userService = new UserServiceImpl();

        /* invocationHandler 用于书写额外功能 */
        /* jdk 1.8 之前匿名内部类，使用外部对象，需要设置外部对象为 final */
        InvocationHandler handler =
                new InvocationHandler() {
                    /**
                     * 2. 额外功能 等同于{@link MethodInterceptor#invoke(MethodInvocation)}
                     *
                     * <p>{@link MethodInvocation} 等同于 封装了{@code method、proxy、args}的一个对象
                     *
                     * @param proxy 创建好后的代理对象本身，也就是执行时的自己（一般很少使用）
                     * @param method 会被增加的 {@code 原始方法}
                     * @param args {@code 原始方法} 的参数
                     * @return {@code 原始方法}的返回值
                     * @throws Throwable {@code 原始方法}抛出的异常
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        // System.out.println("proxy = " + proxy.getClass().getName());
                        Object result = method.invoke(userService, args);
                        System.out.println("<<<<<<<<< TestJDKProxy.invoke");

                        // 就是代理后的对象，会造成递归调用，所以不怎么使用。
                        // ((UserService)proxy).login("hello", "myhello");
                        return result;
                    }
                };

        /* 借用类加载器：任意类都行 */
        UserService userServiceProxy =
                (UserService)
                        Proxy.newProxyInstance(
                                UserService.class.getClassLoader(),
                                userService.getClass().getInterfaces(), // 3. 代理对象实现和原始对象相同的接口
                                handler);

        // userServiceProxy.login("hello", "myhello");
        userServiceProxy.register(new User());
    }
}
