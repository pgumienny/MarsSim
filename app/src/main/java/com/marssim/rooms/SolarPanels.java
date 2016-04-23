package com.marssim.rooms;

import com.marssim.Astronaut;
import com.marssim.BaseResources;

import java.util.ResourceBundle;

/**
 * Created by pg on 23/04/16.
 */
public class SolarPanels extends AbstractRoom {
    public static final int ENERGY_DELTA = 10;
    public static final int UPGRADE_TIME = 50;
    public static final int ACTION_TIME = 10;

    @Override
    public void getResourcesChange(BaseResources baseResources, int timePassed) {
        defaultEnergySubtract(baseResources);
    }

    @Override
    public int doAction(Astronaut astronaut) {
        return ACTION_TIME;
    }

    @Override
    public int upgrade(Astronaut astronaut, BaseResources resources) {
        level++;
        resources.getTechnologyPoints().add(-20);
        return UPGRADE_TIME;
    }
}
