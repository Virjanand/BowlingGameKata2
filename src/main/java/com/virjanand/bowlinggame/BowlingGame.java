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
        int sum = 0;
        for (int i = 0; i < rolls.size(); i++) {
            String roll = rolls.get(i);
            if (hitPins(roll)) {
                String s = resolveStrike(roll);
                int valueOf = Integer.parseInt(s);
                sum += valueOf;
                if (roll.equals("X") && !rolls.get(i + 1).equals("-") && !rolls.get(i + 2).equals("-")) {
                    sum += Integer.parseInt(rolls.get(i + 1)) + Integer.parseInt(rolls.get(i + 2));
                }
            }
        }
        return sum;
    }

    private String resolveStrike(String roll) {
        if (roll.equals("X")) {
            return "10";
        }
        return roll;
    }
}
