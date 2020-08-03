package com.virjanand.bowlinggame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    private static Stream<Arguments> rollsWithScores() {
        return Stream.of(
                Arguments.of(asList("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"), 20, "Sum the regular rolls"),
                Arguments.of(asList("-", "-", "-", "-","-", "-","-", "-","-", "-","-", "-","-", "-","-", "-","-", "-","-", "-"), 0, "Miss(-) is 0 points"),
                Arguments.of(asList("X", "-", "-", "-","-", "-","-", "-","-", "-","-", "-","-", "-","-", "-","-", "-","-", "-"), 10, "Strike(X) is 10 points"),
                Arguments.of(asList("X", "1", "1", "-","-", "-","-", "-","-", "-","-", "-","-", "-","-", "-","-", "-","-", "-"), 14, "Add next two rolls to strike"),
                Arguments.of(asList("X", "X", "1", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"), 33, "Strike after strike is added as 10 points"),
                Arguments.of(asList("1", "/", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"), 10, "Spare (roll and /) together ten points"),
                Arguments.of(asList("1", "/", "1", "1", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"), 13, "Add next roll to spare score"),
                Arguments.of(asList("-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "X", "X", "X"), 50, "Extra rolls for last strike are not treated as strikes")
        );
    }

    @ParameterizedTest(name = "{2}: {0} -> {1}")
    @MethodSource("rollsWithScores")
    void scoringRules(List<String> rolls, int expectedScore, String name) {
        BowlingGame game = new BowlingGame(rolls);
        assertThat(game.getScore()).isEqualTo(expectedScore);
    }
}
