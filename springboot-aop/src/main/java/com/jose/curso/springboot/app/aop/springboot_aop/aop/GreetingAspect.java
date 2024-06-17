package com.jose.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("GreetingServicePointcuts.greetingLoggerPointCur()")
    public void loggerBefore(JoinPoint joinPoint){
        String method =  joinPoint.getSignature().getName();
        String args = Arrays.toString(  joinPoint.getArgs()    );
        logger.info("Antes : " + method + " con los argumentos " +  args);
    } 
    @After("GreetingServicePointcuts.greetingLoggerPointCur()")
    public void loggerAfter(JoinPoint joinPoint){
        String method =  joinPoint.getSignature().getName();
        String args = Arrays.toString(  joinPoint.getArgs()    );
        logger.info("Despues :  " + method + " con los argumentos " +  args);
    } 
    @AfterReturning("GreetingServicePointcuts.greetingLoggerPointCur()")
    public void loggerAfterReturning(JoinPoint joinPoint){
        String method =  joinPoint.getSignature().getName();
        String args = Arrays.toString(  joinPoint.getArgs()    );
        logger.info("Despues de retornar :  " + method + " con los argumentos " +  args);
    } 
    @AfterThrowing("GreetingServicePointcuts.greetingLoggerPointCur()")
    public void loggerAfterThrowing(JoinPoint joinPoint){
        String method =  joinPoint.getSignature().getName();
        String args = Arrays.toString(  joinPoint.getArgs()    );
        logger.info("Despues de exception :  " + method + " con los argumentos " +  args);
    } 
    @Around("GreetingServicePointcuts.greetingLoggerPointCur()")
    public Object logerAroun(ProceedingJoinPoint joinPoint) throws Throwable{
         String method =  joinPoint.getSignature().getName(); 
         String args = Arrays.toString(  joinPoint.getArgs()  );
    
        try {
            logger.info("el metodo " + method + "() con los argumentos " +  args);
            Object result = joinPoint.proceed();
            logger.info("el metodo " + method + "() retorna " +  result); 
                return result ;
        } catch (Throwable e) { 
            logger.error("Error en la llamade del metodo " + method ); 
            throw e;
        } 
    }
    
    







}
