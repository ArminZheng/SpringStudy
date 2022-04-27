package com.arminzheng.aspect;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

/**
 * MyBeanPostProcessor
 *
 * @author zy
 * @version 2022/4/20
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        // Apr 27 动态代理
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("---------- log in -----------");
                    return method.invoke(bean, args);
                });
    }
}
