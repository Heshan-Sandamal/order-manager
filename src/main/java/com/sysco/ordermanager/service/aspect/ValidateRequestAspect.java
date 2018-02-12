package com.sysco.ordermanager.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by vibodhab on 2/12/18.
 */
@Aspect
@Component
public class ValidateRequestAspect {

    @Before("execution(* com.sysco.ordermanager.service.*.*(..))")
    public void validateRequest(JoinPoint joinPoint){
        System.out.println(joinPoint.getArgs()[0]);
    }
}
