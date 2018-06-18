package com.reger.test.aspect;


import com.reger.test.annotation.BusinessLog;
import org.apache.commons.lang3.Validate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static com.netflix.hystrix.contrib.javanica.utils.AopUtils.getMethodFromTarget;

/**
 * 业务日志切面
 * @author MrDu
 * @date 16/5/31
 */
@Aspect
@Component
public class BusinessLogAspect {
    private Logger logger = LoggerFactory.getLogger(BusinessLogAspect.class);

    @Pointcut("@annotation(com.reger.test.annotation.BusinessLog)")
    public void businessLogAnnotationPointcut() {

    }

    @Around(value = "businessLogAnnotationPointcut()")
    public Object methodsAnnotatedWithBusinessLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = getMethodFromTarget(joinPoint);
        Validate.notNull(method, "failed to get method from joinPoint: %s", joinPoint);
        Annotation p = method.getAnnotation(BusinessLog.class);
        Method m = p.getClass().getDeclaredMethod("logInfo");
        String values = (String) m.invoke(p);
        String name = joinPoint.getSignature().getName();
        String clazz = joinPoint.getTarget().getClass().toString();
        clazz = clazz.substring(5);
        logger.info("耗时统计：" + clazz + "." + name + "()" +  values + " 开始处理...");
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("耗时统计：" + clazz + "." + name + "()" +  values + " -> 耗时" + (endTime - startTime) + "ms");
        return obj;
    }
}
