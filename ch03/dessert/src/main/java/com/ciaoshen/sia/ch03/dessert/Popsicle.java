package com.ciaoshen.sia.ch03.dessert;

/* spring framework */
import org.springframework.stereotype.Component;
/* local dessert project */
import com.ciaoshen.sia.ch03.dessert.annotation.Cold;
import com.ciaoshen.sia.ch03.dessert.annotation.Fruity;

@Component
@Cold
@Fruity
public class Popsicle implements Dessert {

    public String consumed() {
        return "Popsicle consumed!";
    }

}