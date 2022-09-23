package com.code_gym.book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


import java.util.Arrays;

@Component
@Aspect
public class BookAspect {

    private int count = 0;

    @AfterReturning("execution(* com.code_gym.book.controller.BookController.showBorrow(..))")
    public void logInfoBorrow(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.err.println("Method " + methodName + " done!");
    }

    @AfterReturning("execution(* com.code_gym.book.controller.BookController.showPay(..))")
    public void logInfoReturn(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.err.println("Method " + methodName + " done!");
    }

    @Pointcut("execution(* com.code_gym.book.controller.BookController.*(..))")
    public void allMethodPointCut() {
    }

    @After("allMethodPointCut()")

    public void logInfoVisit(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        count++;
        System.err.println("Method " + methodName + " done! (logTime=" + count + ")");
    }


}
