package com.ciaoshen.sia.ch03.soundsystem;

import java.util.List;

public abstract class CompactDisc {

    protected List<String> songs;
    protected String artist;

    public String getArtist() {
        return artist;
    }

    abstract public void play();
}