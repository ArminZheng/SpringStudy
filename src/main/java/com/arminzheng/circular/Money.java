package com.arminzheng.circular;

import com.alibaba.fastjson.JSON;

/**
 * Money
 *
 * @author zy
 * @version 2022/4/20
 */
public class Money {
    private Account account;
    private Integer id;

    public Money(Account account) {
        this.account = account;
    }

    public Money() {
        System.out.println("Money.Money");
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
        System.out.println("Money.setAccount");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString() {
        // return "Money(account=" + account + ")";
        return JSON.toJSONString(this);
    }
}
