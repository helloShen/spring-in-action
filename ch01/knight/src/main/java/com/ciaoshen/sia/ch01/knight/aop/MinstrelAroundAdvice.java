package com.ciaoshen.sia.ch01.knight.aop;

import org.aspectj.lang.annotation.Aspect; 
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;

import org.springframework.beans.factory.annotation.Autowired;

import com.ciaoshen.sia.ch01.knight.Minstrel;

@Aspect
public class MinstrelAroundAdvice {

    /**
     * Using @Autowired annotation, 
     * spring context will create automatically an instance of Minstrel 
     */
    @Autowired
    private Minstrel minstrel;

    /**
     * Define the behavier of @MinstreAround annotation.
     * And bind @MinstrelAround annotation with MinstrelAroundAdvice aspect.
     */
    @Around("@annotation(MinstrelAround)")
    public Object minstrelAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        minstrel.singBeforeQuest();
        Object proceed = joinPoint.proceed();
        minstrel.singAfterQuest();
        return proceed;
    }

}
