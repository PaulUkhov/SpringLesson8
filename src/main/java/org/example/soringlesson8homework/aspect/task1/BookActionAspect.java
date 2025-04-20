package org.example.soringlesson8homework.aspect.task1;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class BookActionAspect {

    @Pointcut("execution(* org.example.soringlesson8homework.service.task1.BookService.*(..))")
    public void myServiceBeanPointcut() {
    }

    @Before("myServiceBeanPointcut()")
    public void logBookAction(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("{}: {}", methodName, Arrays.toString(args));
    }
}
