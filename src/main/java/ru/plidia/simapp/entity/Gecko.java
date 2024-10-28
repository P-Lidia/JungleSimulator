package ru.plidia.simapp.entity;

public class Gecko {

    private int health = 100;
    private int energy = 100;
    public final double NUTRICION = 1.5;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }
}

