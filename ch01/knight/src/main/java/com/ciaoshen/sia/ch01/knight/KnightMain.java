package com.ciaoshen.sia.ch01.knight;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContextException;

import com.ciaoshen.sia.ch01.knight.config.KnightConfig;

public class KnightMain {

    public static void main(String[] args) {
        try {
            /* load spring context */
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
            /* get beans */
            Knight knight = context.getBean(Knight.class);
            /* use beans */
            knight.embarkOnQuest();
            context.close();
        } catch (ApplicationContextException ace) {
            System.out.println("Error when initializing ApplicationContext.");
            System.out.println(ace.getMessage());
        }
    }

}