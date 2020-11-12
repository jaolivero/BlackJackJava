package com.jackblack;

public class Card {
    private byte value;
    private Suite suite;

    public Card(byte value, Suite suite) {
        this.suite = suite;
        this.value = value;
    }

    public byte getValue() {
        return this.value;
    }

    public Suite getSuite() {
        return this.suite;
    }

    public String toString() {
        return this.suite.toString() + " " + value;
    }
}
