package ru.plidia.simapp._main;

import ru.plidia.simapp.entity.Gecko;
import ru.plidia.simapp.util.EventSimulator;

public class _Main {
    public static void main(String[] args) throws InterruptedException {
        Gecko gecko = new Gecko();
        EventSimulator eventSimulator = new EventSimulator();
        try {
            eventSimulator.StartSimulation(gecko);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
