package org.tekeli.borisp.adventcode2022.day02;

public class MoveVsMoveToPoints {
    public static int apply(final Move first, final Move second) {
        int distance = first.getPoints() - second.getPoints();
        return Math.abs(distance) != 2 ? distance : -1 * distance/2;
    }
}
