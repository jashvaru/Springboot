package com.jash.SpringAOP.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
    /*
    2024-11-27T07:58:33.178+05:30  INFO 14320 --- [SpringAOP] [nio-8080-exec-1] com.jash.SpringAOP.aop.LoggingAspect     : Method signature: JobPost com.jash.SpringAOP.service.JobPostService.getJobPost(int)
    2024-11-27T07:58:33.178+05:30  INFO 14320 --- [SpringAOP] [nio-8080-exec-1] com.jash.SpringAOP.aop.LoggingAspect     : Class name: class org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint
    2024-11-27T07:58:33.178+05:30  INFO 14320 --- [SpringAOP] [nio-8080-exec-1] com.jash.SpringAOP.aop.LoggingAspect     : postId: 2
    2024-11-27T07:58:33.178+05:30  INFO 14320 --- [SpringAOP] [nio-8080-exec-1] com.jash.SpringAOP.aop.LoggingAspect     : Target objcom.jash.SpringAOP.service.JobPostService@691a5c3a
    * */

    @After("execution(* com.jash.SpringAOP.service.JobPostService.*(..))")
    public void methodCompleted() {
        log.info("After method completed");
    }
    /*
    2024-11-27T08:06:53.044+05:30  INFO 7332 --- [SpringAOP] [nio-8080-exec-1] com.jash.SpringAOP.aop.LoggingAspect     : After method completed successfully
    2024-11-27T08:06:53.044+05:30  INFO 7332 --- [SpringAOP] [nio-8080-exec-1] com.jash.SpringAOP.aop.LoggingAspect     : After method completed
    * */

    @AfterThrowing("execution(* com.jash.SpringAOP.service.JobPostService.*(..))")
    public void methodCrash() {
        log.info("After method crashed");
    }
    /*
    2024-11-27T08:08:34.099+05:30  INFO 17264 --- [SpringAOP] [nio-8080-exec-1] com.jash.SpringAOP.aop.LoggingAspect     : After method crashed
    2024-11-27T08:08:34.100+05:30  INFO 17264 --- [SpringAOP] [nio-8080-exec-1] com.jash.SpringAOP.aop.LoggingAspect     : After method completed
    * */

    @AfterReturning("execution(* com.jash.SpringAOP.service.JobPostService.*(..))")
    public void methodCompletedSuccessfully() {
        log.info("After method completed successfully");
    }
    /*
    2024-11-27T08:06:53.044+05:30  INFO 7332 --- [SpringAOP] [nio-8080-exec-1] com.jash.SpringAOP.aop.LoggingAspect     : After method completed successfully
    2024-11-27T08:06:53.044+05:30  INFO 7332 --- [SpringAOP] [nio-8080-exec-1] com.jash.SpringAOP.aop.LoggingAspect     : After method completed
    * */
}
