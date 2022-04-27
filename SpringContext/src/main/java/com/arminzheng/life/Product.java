package com.arminzheng.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 生命周期：实例化，初始化，销毁
 *
 * @author zy
 * @version 2022/4/15
 */
public class Product implements InitializingBean, DisposableBean {

    public Product() {
        System.out.println("Product.Product");
    }

    /**
     * 做一些初始化操作，最后Spring会进行调用
     *
     * @throws Exception null
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product.afterPropertiesSet");
    }

    public void myInit() {
        System.out.println("Product.myInit");
    }

    public void myDestroy() {
        System.out.println("Product.myDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Product.destroy");
    }
}
