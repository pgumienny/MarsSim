package com.marssim;

import com.marssim.rooms.AbstractRoom;

/**
 * Created by pg on 23/04/16.
 */
public class Astronaut implements java.io.Serializable {
    Property satiety;
    Property wellRested;
    Property health;
    Property entertainmentLevel;

    public Astronaut() {
        satiety = new Property();
        wellRested = new Property();
        health = new Property();
        entertainmentLevel = new Property();
    }

    public Property getEntertainmentLevel() {
        return entertainmentLevel;
    }

    public void setEntertainmentLevel(Property entertainmentLevel) {
        this.entertainmentLevel = entertainmentLevel;
    }

    public Property getSatiety() {
        return satiety;
    }

    public void setSatiety(Property satiety) {
        this.satiety = satiety;
    }

    public Property getWellRested() {
        return wellRested;
    }

    public void setWellRested(Property wellRested) {
        this.wellRested = wellRested;
    }

    public Property getHealth() {
        return health;
    }

    public void setHealth(Property health) {
        this.health = health;
    }


    // glod 2/h
    // zdrowie 0.5/h
    // sen 1/h
    // rozrywka
    public void deteriorate(int numberOfTicksPassed, int numberOfTickTotal){
        satiety.subtract(2/Const.TICKS_PER_HOUR);
        health.subtract(0.5f/Const.TICKS_PER_HOUR);
        wellRested.subtract(1/Const.TICKS_PER_HOUR);
        entertainmentLevel.subtract((0.5f + numberOfTickTotal) / Const.TICKS_PER_HOUR);
    }

}
