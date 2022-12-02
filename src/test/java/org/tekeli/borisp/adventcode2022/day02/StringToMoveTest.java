package org.tekeli.borisp.adventcode2022.day02;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
    void shouldProduceInteger() {
        final var input = "A";

        final var output = unitUnderTest.apply(input);

        assertThat(output).isInstanceOf(Integer.class);
    }

    @Test
    void shouldProduceOneInCaseOfNull() {
        final var output = unitUnderTest.apply(null);

        assertThat(output).isEqualTo(0);
    }

    @Test
    void shouldProduceOneInCaseOfA() {
        final var input = "A";

        final var output = unitUnderTest.apply(input);

        assertThat(output).isEqualTo(1);
    }

    @Test
    void shouldProduceOneInCaseOfX() {
        final var input = "X";

        final var output = unitUnderTest.apply(input);

        assertThat(output).isEqualTo(1);
    }

    @Test
    void shouldProduceTwoInCaseOfB() {
        final var input = "B";

        final var output = unitUnderTest.apply(input);

        assertThat(output).isEqualTo(2);
    }

    @Test
    void shouldProduceTwoInCaseOfY() {
        final var input = "Y";

        final var output = unitUnderTest.apply(input);

        assertThat(output).isEqualTo(2);
    }

    @Test
    void shouldProduceTwoInCaseOfC() {
        final var input = "C";

        final var output = unitUnderTest.apply(input);

        assertThat(output).isEqualTo(3);
    }

    @Test
    void shouldProduceTwoInCaseOfZ() {
        final var input = "Z";

        final var output = unitUnderTest.apply(input);

        assertThat(output).isEqualTo(3);
    }

    @Test
    void shouldProduceZeroOtherwise() {
        final var input = "Boom!";

        final var output = unitUnderTest.apply(input);

        assertThat(output).isEqualTo(0);
    }
}
