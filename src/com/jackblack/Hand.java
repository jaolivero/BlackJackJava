package com.jackblack;

import java.util.ArrayList;

public class Hand {
    private byte score;
    private ArrayList<Card> myHand;
    private Player myPlayer;

    private Card card;

    public Hand(Player myPlayer) {
        this.myPlayer = myPlayer;
        this.myHand = new ArrayList<Card>();
    }


    public void addCard (Card dealt) {
        this.myHand.add(dealt);
    }

    public byte getScore() {
        for(Card myCard: myHand) {
            score += myCard.getValue();
        }
        return score;
    }

    public Player getMyPlayer() {
        return myPlayer;
    }
}
