package com.ciaoshen.sia.ch03.soundsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.ciaoshen.sia.ch03.soundsystem.CompactDisc;
import com.ciaoshen.sia.ch03.soundsystem.Beatles;
import com.ciaoshen.sia.ch03.soundsystem.LowRoar;
import com.ciaoshen.sia.ch03.soundsystem.Chopin;
import com.ciaoshen.sia.ch03.soundsystem.Mozart;
import com.ciaoshen.sia.ch03.soundsystem.condition.PlayPop;
import com.ciaoshen.sia.ch03.soundsystem.condition.PlayClassic;

@Configuration
@ComponentScan(basePackages = "com.ciaoshen.sia.ch03.soundsystem")
public class CdConfig {
    @Bean
    @Profile("dev")
    @Conditional(PlayPop.class)
    public CompactDisc beatles() {
        return new Beatles();
    }

    @Bean
    @Profile("dev")
    @Conditional(PlayClassic.class)
    public CompactDisc chopin() {
        return new Chopin();
    }

    @Bean
    @Profile("prod")
    @Conditional(PlayPop.class)
    public CompactDisc lowroar() {
        return new LowRoar();
    }

    @Bean
    @Profile("prod")
    @Conditional(PlayClassic.class)
    public CompactDisc mozart() {
        return new Mozart();
    }
}