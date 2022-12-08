package org.tekeli.borisp.adventcode2022.day02;

import java.util.Optional;
import java.util.function.Predicate;

public class LineToRoundImpl implements LineToRound {

    private final StringToMove stringToMove = new StringToMoveImpl();
    @Override
    public Round apply(final String line) {
        return Optional.ofNullable(line)
                .filter(Predicate.not(String::isBlank))
                .map(String::trim)
                .filter(this::isReadyForMapping)
                .map(this::map)
                .orElseThrow(IllegalArgumentException::new);
    }

    private Round map(final String line) {
        final var split = line.split(" ");
        final var first = stringToMove.apply(split[0]);
        final var second = stringToMove.apply(split[1]);
        return new Round(first, second);
    }

    private boolean isReadyForMapping(final String line) {
       return line.matches("[ABC]\s[YXZ]");
    }
}
