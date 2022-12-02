package org.tekeli.borisp.adventcode2022.day02;

public enum Move {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    Move(int points) {
        this.points = points;
    }
    private final int points;

    public int getPoints() {
        return points;
    }
}
