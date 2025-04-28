package com.example.pms.aspect;


import com.example.pms.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Slf4j
@Component
public class GeneralInterceptorAspect  {
    @Pointcut("@annotation(com.example.pms.annotation.CustomAnnotation)")
    public void loggingPointCut(){}

    @Before("loggingPointCut()")
    public void before(JoinPoint joinPoint) {
        log.info("Before method invoked::" + joinPoint.getSignature());
    }
    @AfterReturning(value = "execution(* com.example.pms.controller.*.*(..))",
            returning = "product")
    public void after( JoinPoint joinPoint, Product product ){
        log.info("After method invoked::"+product);
    }
}
