package com.virjanand.bowlinggame;

import java.util.List;

public class BowlingGame {

    List<String> rolls;

    public BowlingGame(List<String> rolls) {
        this.rolls = rolls;
    }

    public int getScore() {
        return rolls.stream().filter(roll -> !roll.equals("-")).mapToInt(Integer::valueOf).sum();
    }
}
