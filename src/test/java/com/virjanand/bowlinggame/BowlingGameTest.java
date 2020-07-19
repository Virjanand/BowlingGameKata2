package com.virjanand.bowlinggame;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    void sumRolls() {
        BowlingGame game = new BowlingGame(asList("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"));
        assertThat(game.getScore()).isEqualTo(20);
    }
}
