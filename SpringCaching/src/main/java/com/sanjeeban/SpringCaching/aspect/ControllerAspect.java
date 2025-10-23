package com.sanjeeban.SpringCaching.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);


    @Around("execution(* com.sanjeeban.SpringCaching.controllers.*.*(..))")
    public Object logBeforeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long starTime = System.currentTimeMillis();
        logger.info("Before Method Execution: {}", joinPoint.getSignature().toShortString());

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        logger.info("Time taken ms : {}"+(endTime-starTime)+" ms");
        logger.info("After Method execution : {}",joinPoint.getSignature().toShortString());

        return result;
    }

}
