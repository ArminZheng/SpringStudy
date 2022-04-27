package com.arminzheng.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * MyAspect
 *
 * <blockquote>
 *
 * <pre>{@code
 * public class AroundMethodInterceptor implements MethodInterceptor {
 *     @Override
 *     public Object invoke(MethodInvocation methodInvocation) throws Throwable {
 *         Object result = methodInvocation.proceed();
 *         return result;
 *     }
 * }
 * }</pre>
 *
 * </blockquote>
 *
 * @author zy
 * @version 2022/4/27
 */
@Aspect
public class MyAspect {

    /**
     * 1. 额外功能
     * 2. 切入点（自动绑定切面）
     * @param joinPoint 原始方法
     * @return 返回值
     * @throws Throwable 执行异常
     */
    @Around("execution(* login(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--------aspect log----------");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg = " + arg);
        }
        return joinPoint.proceed();
    }
}
