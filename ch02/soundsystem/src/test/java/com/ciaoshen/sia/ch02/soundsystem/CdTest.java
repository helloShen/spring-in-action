package com.ciaoshen.sia.ch02.soundsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
// import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ciaoshen.sia.ch02.soundsystem.config.CdConfig;

// @RunWith(SpringJUnit4ClassRunner.class) // doesn't work on junit jupiter
/**
 * SpringExtension will initialize a spring context in cache.
 * The context is available for all test in this class.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CdConfig.class)
public class CdTest {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private CdPlayer player;
    
    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void playerShouldNotBeNull() {
        assertNotNull(player);
    }

}