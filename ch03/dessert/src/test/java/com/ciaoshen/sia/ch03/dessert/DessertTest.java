package com.ciaoshen.sia.ch03.dessert;

/* junit jupiter */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
/* spring framework */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
/* local dessert project */
import com.ciaoshen.sia.ch03.dessert.config.DessertConfig;
import com.ciaoshen.sia.ch03.dessert.annotation.Cold;
import com.ciaoshen.sia.ch03.dessert.annotation.Creamy;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DessertConfig.class)
public class DessertTest {

    @Autowired
    @Cold
    @Creamy
    private Dessert dessert;

    @Test
    public void shouldEatIceCream() {
        assertEquals(dessert.consumed(), "Ice cream consumed!");
    }

}