package org.tekeli.borisp.adventcode2022.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineToRoundTest {

    private LineToRound unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = new LineToRoundImpl();
    }

    @Test
    void shouldConsumeString() {
        final var line = "A Y";

        assertDoesNotThrow(() -> unitUnderTest.apply(line));
    }

    @Test
    void shouldProduceRound() {
        final var line = "A Y";

        final Round apply = unitUnderTest.apply(line);

        assertThat(apply).isInstanceOf(Round.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "Boom!"})
    void shouldThrowIllegalArgumentExceptionInCaseLineInvalid(final String invalidLine) {
        assertThrows(IllegalArgumentException.class, () -> unitUnderTest.apply(invalidLine));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void shouldProduceRoundWithMoves(final String line, final  Round expected) {
        final Round apply = unitUnderTest.apply(line);

        assertThat(apply).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of("A X", new Round(Move.ROCK, Move.ROCK)),
                Arguments.of("A Y", new Round(Move.ROCK, Move.PAPER)),
                Arguments.of("A Z", new Round(Move.ROCK, Move.SCISSORS)),
                Arguments.of("B X", new Round(Move.PAPER, Move.ROCK)),
                Arguments.of("B Y", new Round(Move.PAPER, Move.PAPER)),
                Arguments.of("B Z", new Round(Move.PAPER, Move.SCISSORS)),
                Arguments.of("C X", new Round(Move.SCISSORS, Move.ROCK)),
                Arguments.of("C Y", new Round(Move.SCISSORS, Move.PAPER)),
                Arguments.of("C Z", new Round(Move.SCISSORS, Move.SCISSORS))
        );
    }
}
