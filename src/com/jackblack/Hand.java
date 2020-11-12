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
        myHand.add(card);
    }

    public byte getScore() {
        for(Card myCard: myHand){
            score = (byte) + card.getValue();
        }
        return score;
    }
}
