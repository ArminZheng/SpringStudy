package com.arminzheng.construct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Broker
 *
 * @author zy
 * @version 2022/4/12
 */
@Component
@Lazy // 可以使用在类上 方法上
@Primary // 可以使用在一个接口 多个实现类的其中一个上，作为首选
public class Broker {

    private Customer customer;

    @Autowired
    public Broker(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Broker{" + "customer=" + customer + '}';
    }
}
