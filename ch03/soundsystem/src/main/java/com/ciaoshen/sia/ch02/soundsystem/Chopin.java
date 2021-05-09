package com.ciaoshen.sia.ch03.soundsystem;

import java.util.List;
import java.util.Arrays;

public class Chopin extends CompactDisc {

    public Chopin() {
        super.songs = Arrays.asList(
            "Larghetto from Piano Concerto No. 2 in F minor, Op.",
            "Nocturne in B-flat minor, Op. 9, No. 1",
            "Nocturne in E-flat major, Op. 9, No. 2"
        );
        super.artist = "Chopin";
    }

    public void play() {
        for (String song : songs) {
            System.out.println("Playing " + song + " by " + artist);
        }
    }

}