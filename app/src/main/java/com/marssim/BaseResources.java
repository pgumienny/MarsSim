package com.marssim;

/**
 * Created by pg on 23/04/16.
 */
public class BaseResources {
    Property energy;
    Property water;
    Property oxygen;
    Property technologyPoints;
    Property food;

    public BaseResources() {
        energy = new Property();
        water = new Property();
        oxygen = new Property();
        technologyPoints = new Property();
        food = new Property();
    }

    public Property getEnergy() {
        return energy;
    }

    public void setEnergy(Property energy) {
        this.energy = energy;
    }

    public Property getWater() {
        return water;
    }

    public void setWater(Property water) {
        this.water = water;
    }

    public Property getOxygen() {
        return oxygen;
    }

    public void setOxygen(Property oxygen) {
        this.oxygen = oxygen;
    }

    public Property getTechnologyPoints() {
        return technologyPoints;
    }

    public void setTechnologyPoints(Property technologyPoints) {
        this.technologyPoints = technologyPoints;
    }

    public Property getFood() {
        return food;
    }

    public void setFood(Property food) {
        this.food = food;
    }
}
