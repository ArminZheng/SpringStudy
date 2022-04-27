package com.arminzheng.beanpost;

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
    /**
     * 实战中很少进行初始化操作（需要将操作写在类内部，过于强制） 也就很少区分 before after，只需要实现其中一个 after 方法即可。
     * (注意：postProcessBeforeInitialization 得 return bean; )
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof Category) {
            System.out.println("MyBeanPostProcessor.postProcessAfterInitialization()");
            Category category = (Category) bean;
            category.setName("Johnson");
        }

        // Apr 27 动态代理
        if (bean instanceof UserService)
            return Proxy.newProxyInstance(
                    this.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        System.out.println("---------- log in -----------");
                        return method.invoke(bean, args);
                    });
        return bean;
    }
}
