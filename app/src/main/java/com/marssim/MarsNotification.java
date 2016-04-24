package com.marssim;

import java.io.Serializable;

/**
 * Created by Franek on 2016-04-24.
 */
public class MarsNotification implements Serializable {
    private String text;
    private int time;

    public MarsNotification(String text, int time) {
        this.text = text;
        this.time = time;
    }

    public int getTime() {

        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
