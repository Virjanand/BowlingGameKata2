package com.virjanand.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    void sumRolls() {
        BowlingGame game = new BowlingGame();
        assertThat(game.getScore()).isEqualTo(20);
    }
}
