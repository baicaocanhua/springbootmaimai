package com.maimai.springbootlast.aop;

import com.maimai.springbootlast.annotation.EagleEye;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-25 10:17
 **/
@Aspect
@Component
public class LogAspect {
    //定义切点
    @Pointcut("@annotation(com.maimai.springbootlast.annotation.EagleEye)")
    public void eagleEye() {

    }

    @Around("eagleEye()")
    public Object aroundinfo(ProceedingJoinPoint proceedingJoinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("请求路径 : " + request.getRequestURL());
        System.out.println("请求方式 : " + request.getMethod());
        System.out.println("方法名 : " + proceedingJoinPoint.getSignature().getName());
        System.out.println("类路径 : " + proceedingJoinPoint.getSignature().getDeclaringTypeName());
        System.out.println("参数 : " + Arrays.toString(proceedingJoinPoint.getArgs()));
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("222"+method.getName());
        EagleEye eagleEye = method.getAnnotation(EagleEye.class);
        System.out.println("eagleEye"+eagleEye.desc());

        try {
            // 真实业务代码，这里是伪代码
            Object[] arr = proceedingJoinPoint.getArgs();
            for (Object o : arr) {
                System.out.println("###");
                System.out.println(o.toString());
            }
            Object o = proceedingJoinPoint.proceed();
            o = "aop";
            System.out.println("方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

}
