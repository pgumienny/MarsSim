package com.marssim.rooms;

import com.marssim.Astronaut;
import com.marssim.BaseResources;

/**
 * Created by pg on 23/04/16.
 */
public class SolarPanels extends AbstractRoom {
    public static final int ENERGY_DELTA = 10;

    @Override
    public void getResourcesChange(BaseResources baseResources, int timePassed) {
        baseResources.getEnergy().add(ENERGY_DELTA);
    }

    @Override
    public int doAction(Astronaut astronaut) {
        return 1;
    }

    @Override
    public int upgrade() {
        return 1;
    }
}
