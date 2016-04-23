package com.marssim.rooms;

import com.marssim.Astronaut;
import com.marssim.BaseResources;
import com.marssim.Const;

/**
 * Created by pg on 23/04/16.
 */
public abstract class AbstractRoom implements java.io.Serializable {
    int condition;
    int level;

    /**
      * modifies Astronaut and BaseResources, simulating one step in martian base simulation
      */
    public abstract void getResourcesChange(BaseResources baseResources, int timeTicksPassed);

    /**
     * modifies Astronaut
     * @return time that has passed doing the action
     */
    public abstract int doAction(Astronaut astronaut);


    /**
     * modifies Astronaut
     * @return time that has passed doing the action
     */
    public abstract int upgrade(Astronaut astronaut, BaseResources resources);

    public void defaultEnergySubtract(BaseResources baseResources){
        baseResources.getEnergy().subtract(-1*level/ Const.TICKS_PER_HOUR);
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
