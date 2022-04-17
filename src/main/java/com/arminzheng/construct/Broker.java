package com.arminzheng.construct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Broker
 *
 * @author zy
 * @version 2022/4/12
 */
@Component
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
