package com.marssim.rooms;

import com.marssim.Astronaut;
import com.marssim.BaseResources;
import com.marssim.Const;
import com.marssim.R;

import java.io.Serializable;

/**
 * Created by pg on 23/04/16.
 */
public class Bedroom extends AbstractRoom implements Serializable{
    @Override
    public void getResourcesChange(BaseResources baseResources, int timeTicksPassed) {
        defaultEnergySubtract(baseResources);
    }

    @Override
    public int getImage(){
        return R.drawable.mala_sypialnia;
    }

    @Override
    public int getButton(){
        return R.id.imageButtonBedroom;
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
