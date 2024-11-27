package com.jash.SpringAOP.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Scope("singleton")
@Aspect
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);


    /*@Before("execution(* com.jash.SpringAOP.service.JobPostService.*(..))")
    public void loggingMethod() {
        log.info("Method called");
    }*/

    @Before("execution(* com.jash.SpringAOP.service.JobPostService.*(..))")
    public void loggingDetailMethod(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("Method signature: " + methodSignature);
        String[] params = methodSignature.getParameterNames();
        log.info("Class name: " + joinPoint.getClass());
        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < params.length; i++) {
            log.info(params[i] + ": " + args[i]);
        }

        log.info("Target obj" + joinPoint.getTarget());
    }
}
