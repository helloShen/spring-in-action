package com.ciaoshen.sia.ch03.soundsystem;

import java.util.List;
import java.util.Arrays;

public class LowRoar extends CompactDisc {

    public LowRoar() {
        super.songs = Arrays.asList(
            "Give up",
            "Bones",
            "Don't Be So Serious",
            "Just a Habit"
        );

        super.artist = "Low Roar";
    }

    public void play() {
        for (String song : songs) {
            System.out.println("Playing " + song + " by " + artist);
        }
    }

}