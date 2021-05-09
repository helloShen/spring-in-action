package com.ciaoshen.sia.ch03.dessert;

/* spring framework */
import org.springframework.stereotype.Component;
/* local dessert project */
import com.ciaoshen.sia.ch03.dessert.annotation.Soft;

@Component
@Soft
public class Cake implements Dessert {

    public String consumed() {
        return "Cake consumed!";
    }

}