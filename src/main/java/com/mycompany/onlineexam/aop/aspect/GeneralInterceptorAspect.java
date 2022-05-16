//package com.mycompany.onlineexam.aop.aspect;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
///**
// * User: Kamtel
// * Date : 1/25/2022
// * Time : 12:41 PM
// */
//@Aspect
//@Component
//public class GeneralInterceptorAspect {
//    private final Logger logger = LogManager.getLogger(GeneralInterceptorAspect.class);
//
//    @Pointcut("execution(* com.mycompany.onlineexam.web.rest.*.*(..))")
//    public void loggingPointcut() {
//
//    }
//
//    @Before("loggingPointcut()")
//    public void before(JoinPoint joinPoint) {
//        logger.info("Logged in method " + joinPoint.getSignature().getDeclaringTypeName() + " : " + Arrays.toString(joinPoint.getArgs()));
//    }
//
//    @AfterReturning(value = "loggingPointcut()")
//    public void after(JoinPoint joinPoint) {
//        logger.info("End of method : " + joinPoint.getArgs()[0]);
//    }
//
//    @AfterThrowing(value = "loggingPointcut()", throwing = "e")
//    public void logException(JoinPoint joinPoint, Exception e) {
//        logger.error("Action failed in method : {" + joinPoint.getSignature().getDeclaringTypeName() + " } , caused by : " + e.getMessage() + " , " + e.getCause());
//    }
//}
