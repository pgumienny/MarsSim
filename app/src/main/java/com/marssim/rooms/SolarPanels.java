package com.marssim.rooms;

import com.marssim.Astronaut;
import com.marssim.BaseResources;
import com.marssim.R;

import java.io.Serializable;
import java.util.ResourceBundle;

/**
 * Created by pg on 23/04/16.
 */
public class SolarPanels extends AbstractRoom implements Serializable{
    public static final int ENERGY_DELTA = 5;
    public static final int ENERGY_DELTA_PER_LEVEL = 3;
    public static final int UPGRADE_TIME = 50;
    public static final int ACTION_TIME = 10;

    @Override
    public void getResourcesChange(BaseResources baseResources, int timePassed) {
        baseResources.getEnergy().add(ENERGY_DELTA + ENERGY_DELTA_PER_LEVEL * level);
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

    @Override
    public int getImage(){
        return R.drawable.panele_sloneczne;
    }
}
