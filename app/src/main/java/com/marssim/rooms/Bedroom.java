package com.marssim.rooms;

import com.marssim.Astronaut;
import com.marssim.BaseResources;

/**
 * Created by pg on 23/04/16.
 */
public class Bedroom extends AbstractRoom {
    @Override
    public void getResourcesChange(BaseResources baseResources, int timeTicksPassed) {

    }

    @Override
    public int doAction(Astronaut astronaut) {
        return 0;
    }

    @Override
    public int upgrade(Astronaut astronaut, BaseResources resources) {
        return 0;
    }
}