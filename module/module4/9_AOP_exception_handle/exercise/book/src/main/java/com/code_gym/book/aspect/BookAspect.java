package com.code_gym.book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class BookAspect {

    private int count = 0;

    @Pointcut("within(com.code_gym.book.BookController*)")
    public void allMethodPointCut() {
    }

    @After("allMethodPointCut()")
    public void afterAllMethod(JoinPoint joinPoint) {
        count++;
        System.out.println("Method name: " + joinPoint.getSignature().getName() +
                " number visit book " + count);
    }

    @Pointcut("within(*com.code_gym.book.BookController*)")
    public void payAndBorrowMethodPointCut() {
    }

    @After("payAndBorrowMethodPointCut()")
    public void afterPayAndBorrowMethod(JoinPoint joinPoint) {
        System.out.println("Method name: " + joinPoint.getSignature().getName() + " | Time: " + LocalDateTime.now());
    }

}
