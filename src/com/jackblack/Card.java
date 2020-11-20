package com.jackblack;

public class Card {
    private byte value;
    private String suit;

    public Card(byte value, String suit) {
        this.suit = suit;
        this.value = value;
    }

    public byte getValue() {
        return this.value;
    }

    public String getSuite() {
        return this.suit;
    }

    public String toString() {
        return this.suit.toString() + " " + value;
    }
}
