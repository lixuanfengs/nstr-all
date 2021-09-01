package com.nstr.system.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author: cactusli
 * @date: 2021.08.12
 */
public class BaseAspectSupport {

    Method resolveMethod(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Class<?> targetClass = point.getTarget().getClass();

        Method declaredMethod = getDeclaredMethod(targetClass, signature.getName(),
                signature.getMethod().getParameterTypes());
        if (declaredMethod == null) {
            throw new IllegalStateException("无法解析目标方法：" + signature.getMethod().getName());
        }
        return declaredMethod;
    }

    private Method getDeclaredMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            Class<?> superclass = clazz.getSuperclass();
            if (superclass != null) {
                return getDeclaredMethod(superclass, name, parameterTypes);
            }
        }
        return null;
    }
}
