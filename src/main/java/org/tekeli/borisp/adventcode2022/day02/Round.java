package org.tekeli.borisp.adventcode2022.day02;

import java.util.Objects;

public class Round {
    private final Move first;
    private final Move second;

    public Round(final Move first, final Move second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return first == round.first && second == round.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
