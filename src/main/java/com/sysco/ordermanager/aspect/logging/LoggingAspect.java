package com.sysco.ordermanager.aspect.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.sysco.ordermanager.web.controller.*.*(*))")
    public void logMethodCalls(JoinPoint joinPoint){
        logger.info("Calling the function "+ joinPoint.toString());
    }

    @After("execution(* com.sysco.ordermanager.web.controller.*.*(*))")
    public void logMethodFinishes(JoinPoint joinPoint){
        logger.info("End of the execution of the function "+ joinPoint.toString());
    }

}
