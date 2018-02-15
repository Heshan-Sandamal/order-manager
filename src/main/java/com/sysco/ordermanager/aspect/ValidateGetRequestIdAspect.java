package com.sysco.ordermanager.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidateGetRequestIdAspect {
    @Before("execution(@com.sysco.ordermanager.aspect.anotation.ValidateGetRequestId * *(..))")
    public void validateGetRequestId(JoinPoint joinPoint){
        System.out.println(joinPoint.getArgs()[0]);
    }
}
