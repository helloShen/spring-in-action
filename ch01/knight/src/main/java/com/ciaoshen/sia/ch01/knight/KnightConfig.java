package com.ciaoshen.sia.ch01.knight;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import com.ciaoshen.sia.ch01.knight.Knight;
import com.ciaoshen.sia.ch01.knight.BraveKnight;
import com.ciaoshen.sia.ch01.knight.Quest;
import com.ciaoshen.sia.ch01.knight.SlayDragonQuest;

@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}