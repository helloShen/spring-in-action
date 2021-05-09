package com.ciaoshen.sia.ch03.dessert.annotation;

/* spring framework */
import org.springframework.beans.factory.annotation.Qualifier;
/* java jkd */
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Fruity {}