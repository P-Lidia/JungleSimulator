package ru.plidia.simapp.entity;

public class Gecko {

    private int health = 100;
    private int energy = 100;
    private double nutrition = 1.5;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public double getNutrition() {
        return this.nutrition;
    }
}

