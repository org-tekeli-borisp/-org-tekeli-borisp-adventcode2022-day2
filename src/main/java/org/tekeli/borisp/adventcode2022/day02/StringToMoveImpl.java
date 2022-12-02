package org.tekeli.borisp.adventcode2022.day02;

import java.util.Optional;

public class StringToMoveImpl implements StringToMove {
    @Override
    public Integer apply(final String input) {
       return Optional.ofNullable(input)
                .map(this::map)
                .orElse(0);

    }

    private Integer map(final String input) {
        return switch (input) {
            case "A", "X" -> 1;
            case "B", "Y" -> 2;
            case "C", "Z" -> 3;
            default -> 0;
        };
    }
}
