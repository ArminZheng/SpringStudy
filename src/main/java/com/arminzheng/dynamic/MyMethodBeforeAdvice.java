package com.arminzheng.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Before
 *
 * @author zy
 * @version 2022/4/21
 */
@Slf4j
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        log.info("---------method before advice log-----------");
    }
}
