package com.jash.SpringAOP.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger log = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.jash.SpringAOP.service.JobPostService.*(..)) && args(postId)")
    public Object validate(ProceedingJoinPoint joinPoint, int postId) throws Throwable {
        if(postId < 0) {
            log.info("PostId value is negative: " + postId + " so updating it");
            postId = -postId;
            log.info("PostId new value: " + postId);
        }

        Object obj = joinPoint.proceed(new Object[]{postId});
        return obj;
    }
    /*
    2024-11-27T08:41:40.700+05:30  INFO 25008 --- [SpringAOP] [nio-8080-exec-2] c.jash.SpringAOP.aop.ValidationAspect    : PostId value is negative: -2 so updating it
    2024-11-27T08:41:40.701+05:30  INFO 25008 --- [SpringAOP] [nio-8080-exec-2] c.jash.SpringAOP.aop.ValidationAspect    : PostId new value: 2
    * */
}
