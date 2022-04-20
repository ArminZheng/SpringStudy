package com.arminzheng.life.scope;

/**
 * 生命周期中的scope（范围）通常为单例，只在Spring工厂创建时创建（通过设置可变为原型，在获取时创建）
 *
 * @author zy
 * @version 2022/4/14
 */
// @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Account {}
