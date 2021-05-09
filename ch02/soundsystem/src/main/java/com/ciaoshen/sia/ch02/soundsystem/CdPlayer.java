package com.ciaoshen.sia.ch02.soundsystem;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CdPlayer implements MediaPlayer{

    private CompactDisc cd;

    @Autowired
    public void insertCd(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();        
    }

}