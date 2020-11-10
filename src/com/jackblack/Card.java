package com.jackblack;

import java.util.Random;

public class Card {
    private int [] value;
    private static String [] suite = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private Random random = new Random();

    public Card(int value, String suite) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static String[] getSuite() {
        return this.suite;
    }
}
