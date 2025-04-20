package org.example.soringlesson8homework.aspect.task2;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TransactionActionAspect {
    @Pointcut("@annotation(org.example.soringlesson8homework.aspect.task2.TrackTransactionsAspect)")
    public void myServiceBeanPointcut2() {
    }

    @Around("myServiceBeanPointcut2()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        log.info("{}.{}.{}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                executionTime);
        return result;
    }

}
