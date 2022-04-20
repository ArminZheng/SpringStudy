package com.arminzheng.beanpost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

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
        if (bean instanceof Category) {
            Category category = (Category) bean;
            category.setName("Johnson");
        }
        return bean;
    }
}
