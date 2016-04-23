package com.marssim;

/**
 * Created by pg on 23/04/16.
 */
public class Property implements java.io.Serializable {
    public static final float MAX_VALUE = 100;
    private float value;
    private float max;

    public Property() {
        this.max = MAX_VALUE;
    }

    public void add(float operand) {
        value += operand;
        if (value > max) {
            value = max;
        }
        if (value < 0) {
            value = 0;
        }
    }

    public void subtract(float operand) {
        add(-1 * operand);
    }
}
