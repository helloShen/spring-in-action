package com.ciaoshen.sia.ch01.knight.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ciaoshen.sia.ch01.knight.Knight;
import com.ciaoshen.sia.ch01.knight.BraveKnight;
import com.ciaoshen.sia.ch01.knight.Quest;
import com.ciaoshen.sia.ch01.knight.SlayDragonQuest;
import com.ciaoshen.sia.ch01.knight.Minstrel;
import com.ciaoshen.sia.ch01.knight.aop.MinstrelAroundAdvice;

@Configuration
@EnableAspectJAutoProxy
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }

    @Bean
    public Minstrel minstrel() {
        return new Minstrel(System.out);
    }

    @Bean 
    public MinstrelAroundAdvice minstrelAroundAdvice() {
        return new MinstrelAroundAdvice();
    }
}