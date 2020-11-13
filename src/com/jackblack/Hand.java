package com.jackblack;

import java.util.ArrayList;

public class Hand {
    private byte score;
    private ArrayList<Card> myHand;
    private Player myPlayer;
    private Card card;

    public Hand(Player myPlayer) {
        this.myPlayer = myPlayer;
    }

    public void deal (Deck deck, Player myPlayer) {
        Card removed = deck.removeCard(0);
        myHand.addCard(removed);
    }

    public byte getScore() {
        for(Card myCard: myHand) {
            score = (byte) + card.getValue();
        }
        return score;
    }
}
