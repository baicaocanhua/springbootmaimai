package com.maimai.springboot.maimaiaop.bean;


import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Aspect
@Order(1000)
public class CacheAspect {

    // 定义切入点：带有Cache注解的方法
    @Pointcut("@annotation(Cache)")
    private void cache(){}

    // 临时存储区
    private static Map<String, Object> cacheList = new LinkedHashMap<String, Object>();

    // 定义环绕通知，处理接口/方法添加缓存
    @Around("cache()")
    private Object cacheAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object object = proceedingJoinPoint.getTarget();
        Object[] args = proceedingJoinPoint.getArgs();
        String className = object.getClass().getName();
        MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();

        // 组装cache key
        String cacheKey = className + "_" + method.getName() + "_" + JSONObject.toJSONString(args);
        if (cacheList.containsKey(cacheKey)){
            System.out.println("data get  cache");
            return cacheList.get(cacheKey);
        }else {
            System.out.println("data get  db");
            Object result = proceedingJoinPoint.proceed();
            cacheList.put(cacheKey, result);
            return result;
        }
    }
}