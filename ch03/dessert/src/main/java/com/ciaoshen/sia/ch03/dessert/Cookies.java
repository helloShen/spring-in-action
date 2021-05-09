package com.ciaoshen.sia.ch03.dessert;

/* spring framework */
import org.springframework.stereotype.Component;
/* local dessert project */
import com.ciaoshen.sia.ch03.dessert.annotation.Crispy;

@Component
@Crispy
public class Cookies implements Dessert {

    public String consumed() {
        return "Cookies consumed!";
    }

}