package org.tekeli.borisp.adventcode2022.day02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MoveVsMoveToPointsTest {

    @Test
    void shouldConsumeMoveAndMove() {
        assertDoesNotThrow(() -> MoveVsMoveToPoints.apply(Move.ROCK, Move.ROCK));
    }

    @Test
    void shouldProduceInteger() {
        final var apply = MoveVsMoveToPoints.apply(Move.ROCK, Move.ROCK);

        assertThat(apply).isInstanceOf(Integer.class);
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void shouldReturnRightInteger(final Move first, final Move second, final Integer expected) {
        final var apply = MoveVsMoveToPoints.apply(first, second);

        assertThat(apply).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(Move.ROCK, Move.ROCK, 0),
                Arguments.of(Move.ROCK, Move.PAPER, -1),
                Arguments.of(Move.ROCK, Move.SCISSORS, 1),
                Arguments.of(Move.PAPER, Move.ROCK, 1),
                Arguments.of(Move.PAPER, Move.PAPER, 0),
                Arguments.of(Move.PAPER, Move.SCISSORS, -1),
                Arguments.of(Move.SCISSORS, Move.ROCK, -1),
                Arguments.of(Move.SCISSORS, Move.PAPER, 1),
                Arguments.of(Move.SCISSORS, Move.SCISSORS, 0)
        );
    }
}
