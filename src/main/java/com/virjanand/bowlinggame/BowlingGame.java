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
            sum += extraPointsStrike(index);
            sum += extraPointsSpare(index);
        }
        return sum;
    }

    /**
     * Strike is 10 points for knocking all pins down in 1 throw
     * The next 2 rolls are added to the strike as bonus score
     */
    private int extraPointsStrike(int index) {
        if (rollIsStrike(index) && rollIsNotAnExtraRoll(index)) {
            return convertRollWithOffset(index, 1) + convertRollWithOffset(index, 2);
        }
        return 0;
    }

    private boolean rollIsNotAnExtraRoll(int index) {
        return index < rolls.size() - 2;
    }

    private boolean rollIsStrike(int index) {
        return rolls.get(index).equals("X");
    }

    /**
     * Spare is 10 points for knocking all pins down in 2 throws
     * "/" is converted to 10 points. Need to remove previous roll
     * The next roll is added to the spare as bonus score
     */
    private int extraPointsSpare(int index) {
        if (rollIsSpare(index)) {
            return -convertRollWithOffset(index, -1) + convertRollWithOffset(index, 1);
        }
        return 0;
    }

    private boolean rollIsSpare(int index) {
        return rolls.get(index).equals("/");
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
