package com.jash.SpringAOP.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMetricsAspect {

    private static final Logger log = LoggerFactory.getLogger(PerformanceMetricsAspect.class);

    @Around("execution(* com.jash.SpringAOP.service.JobPostService.*(..))")
    public Object performaceMetrics(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        log.info("Time Taken by method: {} is {} ms", joinPoint.getSignature().getName(), System.currentTimeMillis() - startTime);
        return obj;
    }
    /*
    2024-11-27T08:41:40.702+05:30  INFO 25008 --- [SpringAOP] [nio-8080-exec-2] c.j.S.aop.PerformanceMetricsAspect       : Time Taken by method: getJobPost is 2 ms
    * */
}
