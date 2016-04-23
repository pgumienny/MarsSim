package com.marssim;

/**
 * Created by pg on 23/04/16.
 */
public class Property {
    public static final int MAX_VALUE = 100;
    private int value;
    private int max;

    public Property() {
        this.max = MAX_VALUE;
    }

    public void add(int operand){
        value += operand;
        if (value > max) {
            value = max;
        }
        if (value < 0) {
            value = 0;
        }
    }
}
