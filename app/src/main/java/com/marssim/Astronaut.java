package com.marssim;

import com.marssim.rooms.AbstractRoom;

/**
 * Created by pg on 23/04/16.
 */
public class Astronaut {
    Property satiety;
    Property wellRested;
    Property psychicalShape;
    Property entertainmentLevel;
    AbstractRoom location;

    public Astronaut() {
        satiety = new Property();
        wellRested = new Property();
        psychicalShape = new Property();
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

    public Property getPsychicalShape() {
        return psychicalShape;
    }

    public void setPsychicalShape(Property psychicalShape) {
        this.psychicalShape = psychicalShape;
    }

    public AbstractRoom getLocation() {
        return location;
    }

    public void setLocation(AbstractRoom location) {
        this.location = location;
    }

}
