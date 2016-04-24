package com.marssim;

import com.marssim.rooms.AbstractRoom;
import com.marssim.rooms.Bedroom;
import com.marssim.rooms.DiningRoom;
import com.marssim.rooms.EntertainmentRoom;
import com.marssim.rooms.Greenhouse;
import com.marssim.rooms.Gym;
import com.marssim.rooms.Laboratory;
import com.marssim.rooms.Rover;
import com.marssim.rooms.SolarPanels;
import com.marssim.rooms.Workshop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pg on 23/04/16.
 */
public class RoomCollection implements java.io.Serializable {
    public ArrayList<AbstractRoom> rooms;

    public RoomCollection() {
        rooms = new ArrayList<>();
        rooms.add(new Bedroom());
        rooms.add(new DiningRoom());
        rooms.add(new EntertainmentRoom());
        rooms.add(new Greenhouse());
        rooms.add(new Gym());
        rooms.add(new Laboratory());
        rooms.add(new Rover());
        rooms.add(new SolarPanels());
        rooms.add(new Workshop());
    }

    public void passTime(BaseResources baseResources, int time) {
        for (AbstractRoom room : rooms) {
            room.getResourcesChange(baseResources, time);
        }
    }

    public List<AbstractRoom> getRooms() {
        return rooms;
    }

}
