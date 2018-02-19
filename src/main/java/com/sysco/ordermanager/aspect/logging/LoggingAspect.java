package com.sysco.ordermanager.aspect.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.sysco.ordermanager.web.controller.*.*(*)) || execution(* com.sysco.ordermanager.service.*.*(*))")
    public void logMethodCalls(JoinPoint joinPoint){
        logger.info("Calling the function "+ joinPoint.toString());
    }

    @After("execution(* com.sysco.ordermanager.web.*.*.*(*)) || execution(* com.sysco.ordermanager.service.*.*(*))")
    public void logMethodFinishes(JoinPoint joinPoint){
        logger.info("Finished executing the function "+ joinPoint.toString());
    }

    @Around("execution(* com.sysco.ordermanager.service.*.*(*))")
    public Object profileTheServices(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object returnValue = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Execution time for "+ pjp.toString() + " : " + elapsedTime + "ms");
        return returnValue;
    }



}
