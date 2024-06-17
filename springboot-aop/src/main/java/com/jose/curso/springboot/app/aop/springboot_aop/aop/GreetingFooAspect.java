package com.jose.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class GreetingFooAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    

  @Before("GreetingServicePointcuts.greetingFooLoggerPointCur()")
  public void loggerBefore(JoinPoint joinPoint){
      String method =  joinPoint.getSignature().getName();
      String args = Arrays.toString(  joinPoint.getArgs()    );
      logger.info("Foo Antes : " + method + " con los argumentos " +  args);
  } 

  @After("GreetingServicePointcuts.greetingFooLoggerPointCur()")
  public void loggerAfter(JoinPoint joinPoint){
      String method =  joinPoint.getSignature().getName();
      String args = Arrays.toString(  joinPoint.getArgs()    );
      logger.info("Foo Despues : " + method + " con los argumentos " +  args);
  } 

}
 