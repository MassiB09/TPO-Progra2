package org.example.classes;

public class Montecarlo {

    public double execute() {
        double accepted = 0;
        final int cardinal = 1000;
        for (int i = 0; i <= cardinal; i++) {
            Axis axis = new Axis(Math.random(), Math.random());
            if (Math.pow(axis.getX(), 2) + Math.pow(axis.getY(), 2) < 1) {
                accepted++;
            }
        }
        return 4 * accepted / cardinal;
    }
}
