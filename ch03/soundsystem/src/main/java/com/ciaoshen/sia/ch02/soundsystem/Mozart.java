package com.ciaoshen.sia.ch03.soundsystem;

import java.util.List;
import java.util.Arrays;

public class Mozart extends CompactDisc {

    public Mozart() {
        super.songs = Arrays.asList(
            "Serenade No. 13",
            "Symphony No. 40, 1st Movement Allegro",
            "Overture to The Marriage of Figaro",
            "Rondo Alla Turca"
        );
        super.artist = "Mozart";
    }

    public void play() {
        for (String song : songs) {
            System.out.println("Playing " + song + " by " + artist);
        }
    }

}