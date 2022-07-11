package com.arminzheng.proxy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

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
     * 1. 额外功能 2. 切入点（自动绑定切面）
     *
     * @param joinPoint 原始方法
     * @return 返回值
     * @throws Throwable 执行异常
     */
    @Around("execution(* com.arminzheng.proxy.simple.UserService.login(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--------aspect log start----------");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg = " + arg);
        }
        System.out.println("--------aspect log end----------");
        return joinPoint.proceed();
    }

    /* 切入点复用：切入点配置提取到一个独立的函数上 */
    /* 函数必须是 public void ; 方法名自定义 */
    @Pointcut("execution(* login(..))")
    public void myPointcut() {}

    /**
     * {@link com.arminzheng.proxy.generate.UserServiceTest#main(String[]) test}
     *
     * @param joinPoint 目标
     * @return 返回结果
     * @throws Throwable 过程产生的异常
     */
    @Around("myPointcut()")
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--------aspect tx----------");
        return joinPoint.proceed();
    }

    @Around("myPointcut()")
    public Object around2(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--------aspect performance----------");
        return joinPoint.proceed();
    }
}
