package com.ciaoshen.sia.ch03.soundsystem;

import java.util.List;
import java.util.Arrays;

public class Beatles extends CompactDisc {

    public Beatles() {
        super.songs = Arrays.asList(
            "Hey Jude",
            "Yellow Submarine",
            "Let it Be"
        );

        super.artist = "The Beatles";
    }

    public void play() {
        for (String song : songs) {
            System.out.println("Playing " + song + " by " + artist);
        }
    }

}