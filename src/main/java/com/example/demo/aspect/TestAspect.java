package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/3/24 10:09 上午
 */
@Aspect
@Component
public class TestAspect {

    @Pointcut("execution( * com.example.demo.aspect.*.*(..))")
    public void anyMethod() {

    }

    @Before(value = "anyMethod()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知");
    }

    @After(value = "anyMethod()")
    public void after(JoinPoint joinPoint) {
        System.out.println();
        System.out.println("后置通知");
    }

    @AfterReturning(value = "anyMethod()", returning = "hello")
    public void after(JoinPoint joinPoint, Object hello) {
        System.out.println();
        System.out.println(hello);
        System.out.println("切点返回内容后执行代码，可以对切点的返回值进行封装");
    }


    /**
     * 先执行环绕通知，在通过joinPoint.proceed()执行方法
     * 环绕通知的参数需要为ProceedingJoinPoint,并且需要有返回值，这个返回值是目标方法的返回值
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "anyMethod()")
    public String around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println();
        System.out.println("环绕通知");
        System.out.println(joinPoint.proceed().toString());
        return joinPoint.proceed().toString();
    }
}
