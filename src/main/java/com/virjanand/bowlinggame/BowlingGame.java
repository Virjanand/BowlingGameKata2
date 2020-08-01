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
            sum += convertRoll(index);
            sum += processStrike(index);
            sum -= processSpare(index);
        }
        return sum;
    }

    private int processSpare(int index) {
        if (rolls.get(index).equals("/")) {
            return convertRollWithOffset(index, -1);
        }
        return 0;
    }

    private int processStrike(int index) {
        if (rolls.get(index).equals("X")) {
            return convertRollWithOffset(index, 1) + convertRollWithOffset(index, 2);
        }
        return 0;
    }

    private int convertRoll(int index) {
        return convertRollWithOffset(index, 0);
    }

    private int convertRollWithOffset(int index, int offset) {
        return Integer.parseInt(resolveSpecialCharacter(rolls.get(index + offset)));
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
