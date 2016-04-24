package com.marssim.rooms;

import com.marssim.Astronaut;
import com.marssim.BaseResources;
import com.marssim.Property;
import com.marssim.R;

import java.io.Serializable;

/**
 * Created by pg on 23/04/16.
 */
public class Greenhouse extends AbstractRoom implements Serializable{
    private Property numberOfPlants;


    public Greenhouse() {
        super();
        this.numberOfPlants = new Property();
    }

    @Override
    public int getImage(){
        return R.drawable.szklarnia;
    }

    public Property getNumberOfPlants() {
        return numberOfPlants;
    }

    public void setNumberOfPlants(Property numberOfPlants) {
        this.numberOfPlants = numberOfPlants;
    }

    @Override
    public void getResourcesChange(BaseResources baseResources, int timeTicksPassed) {
        defaultEnergySubtract(baseResources);
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
