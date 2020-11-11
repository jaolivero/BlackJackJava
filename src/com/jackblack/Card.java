package com.jackblack;

import java.util.Random;

public class Card {
    private int value;
    private Suite suite;

    public Card(int value, Suite suite) {
        this.suite = suite;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public Suite getSuite() {
        return this.suite;
    }

    public String toString() {
        return this.suite.toString() + "" + value;
    }
}
