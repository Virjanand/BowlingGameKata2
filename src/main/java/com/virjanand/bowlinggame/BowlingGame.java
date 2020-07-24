package com.virjanand.bowlinggame;

import java.util.List;

public class BowlingGame {

    List<String> rolls;

    public BowlingGame(List<String> rolls) {
        this.rolls = rolls;
    }

    private static boolean hitPins(String roll) {
        return !roll.equals("-");
    }

    public int getScore() {
        return rolls.stream()
                .filter(BowlingGame::hitPins)
                .map(this::resolveStrike)
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private int resolveStrike(String s) {
        if (s.equals("X")) {
            return 10;
        }
        return Integer.parseInt(s);
    }
}
