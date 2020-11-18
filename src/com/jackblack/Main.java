package com.jackblack;

public class Main {

    public static void main(String[] args) {
        Table table = new Table((byte )6);
        Deck myDeck = new Deck();
        //myDeck.shuffle();
        System.out.print(myDeck);
        table.game();
    }
}
