package com.jackblack;

public class Dealer extends Moves {
    static String name = "Dealer";
    static byte hit = 1;
    static byte option = 17;
    static byte stand = 2;

    public static String getName() {
        return name;
    }

    public byte logic(byte score) {
        return score < option ? hit : stand;
    }
}
