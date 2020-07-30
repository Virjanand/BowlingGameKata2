package com.virjanand.bowlinggame;

import java.util.List;

public class BowlingGame {

    List<String> rolls;

    public BowlingGame(List<String> rolls) {
        this.rolls = rolls;
    }

    public int getScore() {
        int sum = 0;
        for (int index = 0; index < rolls.size(); index++) {
            String roll = rolls.get(index);
                int valueOf = convertRollToNumber(index, 0);
                sum += valueOf;
                if (roll.equals("X")) {
                    sum += convertRollToNumber(index, 1) + convertRollToNumber(index, 2);
                }
            if (roll.equals("/")) {
                sum -= convertRollToNumber(index, -1);
            }
        }
        return sum;
    }

    private int convertRollToNumber(int index, int increment) {
        return Integer.parseInt(resolveSpecialCharacter(rolls.get(index + increment)));
    }

    private String resolveSpecialCharacter(String roll) {
        if (roll.equals("-")) {
            return "0";
        }
        if (roll.equals("X")) {
            return "10";
        }
        if (roll.equals("/")) {
            return "10";
        }
        return roll;
    }
}
