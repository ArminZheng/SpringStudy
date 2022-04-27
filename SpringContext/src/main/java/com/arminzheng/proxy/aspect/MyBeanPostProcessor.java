package com.arminzheng.proxy.aspect;

import com.arminzheng.proxy.simple.UserService;
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
        return bean instanceof UserService
                ? Proxy.newProxyInstance(
                        this.getClass().getClassLoader(),
                        // 注意，无论哪种，只要使用cglib，当前类的getInterfaces()就得不到接口了，因为继承后递增了一级；
                        // 注意必须全局cglib才能getSuperClass，但凡用了jdk，就得到 Serializable 了
                        bean.getClass().getSuperclass().getInterfaces(),
                        (proxy, method, args) -> {
                            System.out.println(
                                    "---------- log infisfhdsjasjfiaopsfjsjsifsfjasopifjsapdfsajsajfsaop -----------");
                            return method.invoke(bean, args);
                        })
                : bean;
    }
}
