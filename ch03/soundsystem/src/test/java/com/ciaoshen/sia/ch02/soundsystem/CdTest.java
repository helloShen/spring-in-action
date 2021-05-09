package com.ciaoshen.sia.ch03.soundsystem;

/* junit jupiter */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
/* spring framework */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.ActiveProfiles;
/* local soundsystem project */
import com.ciaoshen.sia.ch03.soundsystem.config.CdConfig;

/**
 * SpringExtension will initialize a spring context in cache.
 * The context is available for all test in this class.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CdConfig.class)
/* activate "dev" profile */
@ActiveProfiles("dev")
/* set environment property "music-type" to "pop" */
@TestPropertySource(properties = {"music-type = classic"})  
public class CdTest {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private CdPlayer player;
    
    @Test
    public void shouldPlayChopin() {
        assertNotNull(cd);
        assertEquals(cd.getArtist(), "Chopin");
    }

    @Test
    public void shouldPlayChopin() {
        assertNotNull(player);
    }

}