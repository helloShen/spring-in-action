package com.ciaoshen.sia.ch01.knight;

import com.ciaoshen.sia.ch01.knight.aop.MinstrelAround;

public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    /**
     * Implement @MinstrelAroundAdvice aspect.
     */
    @MinstrelAround
    public void embarkOnQuest() {
        quest.embark();
    }
}