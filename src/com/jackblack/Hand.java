package com.jackblack;

import java.util.ArrayList;

public class Hand {
    private byte score;
    private ArrayList<Card> myHand;

    private Player myPlayer;
    private Card card;
    private Deck thisDeck;

    public Hand(Player myPlayer) {
        this.myPlayer = myPlayer;
    }

    public void addCard (Card dealt) {
        this.myHand.add(dealt);
    }

    public byte getScore() {
        for(Card myCard: myHand) {
            score = (byte) + card.getValue();
        }
        return score;
    }

    public Player getMyPlayer() {
        return myPlayer;
    }
}
