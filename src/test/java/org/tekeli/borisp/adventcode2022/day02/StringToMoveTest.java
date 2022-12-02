package org.tekeli.borisp.adventcode2022.day02;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringToMoveTest {
    private StringToMove unitUnderTest;

    @BeforeEach
    void setUp() {
        unitUnderTest = new StringToMoveImpl();
    }

    @Test
    void shouldConsumeString() {
        final var input = "A";

        assertDoesNotThrow(() -> unitUnderTest.apply(input));
    }

    @Test
    void shouldProduceMove() {
        final var input = "A";

        final var output = unitUnderTest.apply(input);

        assertThat(output).isInstanceOf(Move.class);
    }

    @Test
    void shouldProduceOneInCaseOfNull() {
        assertThrows(IllegalArgumentException.class, () -> unitUnderTest.apply(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "X"})
    void shouldProduceRockInCaseAorX(final String input) {

        final var output = unitUnderTest.apply(input);

        assertThat(output).isEqualTo(Move.ROCK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"B", "Y"})
    void shouldProducePaperInCaseBorY(final String input) {

        final var output = unitUnderTest.apply(input);

        assertThat(output).isEqualTo(Move.PAPER);
    }
    @ParameterizedTest
    @ValueSource(strings = {"C", "Z"})
    void shouldProduceScissorsInCaseCorZ(final String input) {

        final var output = unitUnderTest.apply(input);

        assertThat(output).isEqualTo(Move.SCISSORS);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionOtherwise() {
        assertThrows(IllegalArgumentException.class, () -> unitUnderTest.apply("INVALID"));
    }
}
