package com.virjanand.bowlinggame;

import java.util.List;

public class BowlingGame {

    List<String> rolls;

    public BowlingGame(List<String> rolls) {
        this.rolls = rolls;
    }

    public int getScore() {
        return rolls.stream().mapToInt(Integer::valueOf).sum();
    }
}
