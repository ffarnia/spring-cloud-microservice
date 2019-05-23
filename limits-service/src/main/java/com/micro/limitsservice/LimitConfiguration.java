package com.micro.limitsservice;

/**
 * Created by Fazel on 5/9/2019.
 */
public class LimitConfiguration {

    private int minimum;
    private int maximum;

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public LimitConfiguration(int minimum, int maximum) {

        this.minimum = minimum;
        this.maximum = maximum;
    }
}
