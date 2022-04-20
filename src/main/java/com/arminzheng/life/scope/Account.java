package com.arminzheng.life.scope;

import com.alibaba.fastjson.JSON;

/**
 * 生命周期中的scope（范围）通常为单例，只在Spring工厂创建时创建（通过设置可变为原型，在获取时创建）
 *
 * @author zy
 * @version 2022/4/14
 */
// @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Account {
    private Money money;
    private Integer id;

    public Account(Money money) {
        this.money = money;
    }

    public Account() {
        System.out.println("Account.Account");
    }

    public Money getMoney() {
        return this.money;
    }

    public void setMoney(Money money) {
        this.money = money;
        System.out.println("Account.setMoney");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString() {
        // return "Account(money=" + money + ")";
        return JSON.toJSONString(this);
    }
}
