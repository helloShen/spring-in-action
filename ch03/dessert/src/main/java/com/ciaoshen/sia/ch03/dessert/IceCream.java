package com.ciaoshen.sia.ch03.dessert;

/* spring framework */
import org.springframework.stereotype.Component;
/* local dessert project */
import com.ciaoshen.sia.ch03.dessert.annotation.Cold;
import com.ciaoshen.sia.ch03.dessert.annotation.Creamy;

@Component
@Cold
@Creamy
public class IceCream implements Dessert {

    public String consumed() {
        return "Ice cream consumed!";
    }

}