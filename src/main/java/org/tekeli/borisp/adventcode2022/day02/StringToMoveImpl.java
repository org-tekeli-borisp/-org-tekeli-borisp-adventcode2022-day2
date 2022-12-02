package org.tekeli.borisp.adventcode2022.day02;

import java.util.Optional;

public class StringToMoveImpl implements StringToMove {
    @Override
    public Move apply(final String input) {
       return Optional.ofNullable(input)
                .map(this::map)
                .orElseThrow(IllegalArgumentException::new);

    }

    private Move map(final String input) {
        return switch (input) {
            case "A", "X" -> Move.ROCK;
            case "B", "Y" -> Move.PAPER;
            case "C", "Z" -> Move.SCISSORS;
            default ->  throw new IllegalArgumentException("Boom!");
        };
    }
}
