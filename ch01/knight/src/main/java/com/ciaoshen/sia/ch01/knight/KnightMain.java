package com.ciaoshen.sia.ch01.knight;

/* ApplicationContext doesn't have close() methond, its sub-class GenericApplicationContext has. */
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContextException;

public class KnightMain {

    public static void main(String[] args) {
        try {
            /* load spring context, defined by annotation in 'KnightConfig.java' */
            GenericApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
            /* get knight bean */
            Knight knight = context.getBean(Knight.class);
            /* use knight bean */
            knight.embarkOnQuest();
            context.close();
        } catch (ApplicationContextException ace) {
            System.out.println("Error when initializing ApplicationContext.");
            System.out.println(ace.getMessage());
        }
    }
}