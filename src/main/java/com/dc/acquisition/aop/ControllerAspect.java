package com.dc.acquisition.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.dc.acquisition.bean.Result;

@Component
@Aspect
public class ControllerAspect {
    public static final Logger log = LoggerFactory.getLogger(ControllerAspect.class);

    @Around("execution(* com.dc.acquisition.controller..*.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) {
    	StopWatch stopWatch = new StopWatch();
    	stopWatch.start();
        Result result;
        try {
            log.info("执行Controller开始: " + pjp.getSignature() + " 参数：" + pjp.getArgs().toString());
            result = (Result) pjp.proceed(pjp.getArgs());
            log.info("执行Controller结束: " + pjp.getSignature() + "， 返回值：" + result.toString());
            stopWatch.stop();
            log.info("耗时：" + stopWatch.getTotalTimeMillis() + "(毫秒).");
        } catch (Throwable throwable) {
        	result = handlerException(pjp, throwable);
        }

        return result;
    }

    private Result handlerException(ProceedingJoinPoint pjp, Throwable e) {
        Result result = null;
        if (e instanceof RuntimeException) {
            log.error("RuntimeException{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            result = new Result(false,e.getMessage());
        } else {
            log.error("异常{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            result = new Result(false,e.getMessage());
        }

        return result;
    }
}