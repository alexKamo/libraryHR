package com.projectHR.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut declaration for controller package every method
    // forControllerPackage()

    @Pointcut("execution(* com.projectHR.app.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.projectHR.app.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.projectHR.app.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        logger.info("Logging message for method: " + joinPoint.getSignature().toShortString());

        for(Object o : joinPoint.getArgs()){
            logger.info("*** argument passed to the method is: " + o);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "res")
    public void afterReturning(JoinPoint  joinPoint, Object res){
        logger.info("Logging message for method: " + joinPoint.getSignature().toShortString());
        logger.info("returns: " + res);
    }

}
