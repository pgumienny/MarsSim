package com.marssim;

import java.util.ArrayList;

/**
 * Created by pg on 23/04/16.
 */
public class GameState implements java.io.Serializable {
    private static GameState gameState;

    private RoomCollection roomCollection;
    private BaseResources baseResources;
    private Astronaut astronaut;
    private Integer ticksPassed;

    public Integer getCurrentRoomId() {
        return currentRoomId;
    }

    public void setCurrentRoomId(Integer currentRoomId) {
        this.currentRoomId = currentRoomId;
    }

    private Integer currentRoomId;

    public ArrayList<MarsNotification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<MarsNotification> notifications) {
        this.notifications = notifications;
    }

    private ArrayList<MarsNotification> notifications;

    public Integer getTicksPassed() {
        return ticksPassed;
    }

    public void setTicksPassed(Integer ticksPassed) {
        this.ticksPassed = ticksPassed;
    }

    private GameState() {
        roomCollection = new RoomCollection();
        baseResources = new BaseResources();
        astronaut = new Astronaut();
        notifications = new ArrayList<>();
        ticksPassed = 0;
        currentRoomId = 0;
    }

    static public GameState getGameState(){
        if(gameState == null){
            gameState = new GameState();
        }
        return gameState;
    }

    public RoomCollection getRoomCollection() {
        return roomCollection;
    }

    public void setRoomCollection(RoomCollection roomCollection) {
        this.roomCollection = roomCollection;
    }

    public BaseResources getBaseResources() {
        return baseResources;
    }

    public void setBaseResources(BaseResources baseResources) {
        this.baseResources = baseResources;
    }

    public Astronaut getAstronaut() {
        return astronaut;
    }

    public void setAstronaut(Astronaut astronaut) {
        this.astronaut = astronaut;
    }

    private String twoDecUtil(int x){
        return String.format("%02d", x);
    }

    public String getTimeString(){
        int decimals = ticksPassed % 10;
        int seconds = (ticksPassed / 10) % 60;
        int minutes = (ticksPassed / (60*10)) % 60;
        int hours = (ticksPassed / (60*60*10)) % 24;
        int days = (ticksPassed / (24*60*60*10));
        StringBuilder strb = new StringBuilder();
        strb.append(days);
        strb.append(":");
        strb.append(twoDecUtil(hours));
        strb.append(":");
        strb.append(twoDecUtil(minutes));
        strb.append(":");
        strb.append(twoDecUtil(seconds));
        strb.append(":");
        strb.append(decimals);
        return strb.toString();
    }

    public void tick(){
        ticksPassed++;
        astronaut.deteriorate(1, ticksPassed);
        roomCollection.passTime(baseResources, 1);
        baseResources.deteriorate(1);
    }

}
