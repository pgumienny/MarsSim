package com.marssim.rooms;

import com.marssim.Astronaut;
import com.marssim.BaseResources;

/**
 * Created by pg on 23/04/16.
 */
public class SolarPanels extends AbstractRoom {
    public static final int ENERGY_DELTA = 10;

    @Override
    public void getResourcesChange(Astronaut astronaut, BaseResources baseResources) {
        baseResources.getEnergy().add(ENERGY_DELTA);
    }
}
