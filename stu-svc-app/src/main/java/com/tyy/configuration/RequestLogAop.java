package com.tyy.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class RequestLogAop {

    @Pointcut(value = "@within(org.springframework.web.bind.annotation.RequestMapping)")
    public void reqPointCut() {
    }


    @Around("reqPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            log.info(
                    "receive request {} {} ,user = {}, args = {}",
                    request.getMethod(),
                    request.getRequestURI(),
                    request.getUserPrincipal().getName(),
                    joinPoint.getArgs()
            );
            long startMills = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            log.info(
                    "method {}.{} cost {} ms",
                    joinPoint.getSignature().getDeclaringType().getSimpleName(),
                    joinPoint.getSignature().getName(),
                    System.currentTimeMillis() - startMills
            );
            return result;
        } else {
            return joinPoint.proceed();
        }
    }


}
