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
    /**
     * 实战中很少进行初始化操作（需要将操作写在类内部，过于强制） 也就很少区分 before after，只需要实现其中一个 after 方法即可。
     * (注意：postProcessBeforeInitialization 得 return bean; )
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof Category) {
            System.out.println("MyBeanPostProcessor.postProcessAfterInitialization");
            Category category = (Category) bean;
            category.setName("Johnson");
        }
        return bean;
    }
}
