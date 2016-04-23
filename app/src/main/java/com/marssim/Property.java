package com.marssim;

/**
 * Created by pg on 23/04/16.
 */
public class Property implements java.io.Serializable {
    public static final float MAX_VALUE = 100;
    private float value;
    private float max;

    public Property() {
        this.value = 50;
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }
}
