package com.jackblack;

import java.util.ArrayList;
import java.util.Arrays;

public class Hand {

    private byte score;
    private ArrayList<Card> myHand = new ArrayList<>();
    private Player myPlayer;
    private Dealer dealer;
    private boolean hasAce;
    private Card card;

    public Hand(Player myPlayer) {
        this.myPlayer = myPlayer;
        this.myHand = new ArrayList<Card>();
    }

    public Hand(Dealer tableDealer) {
        this.dealer = tableDealer;
    }


    public void addCard (Card dealt) {
        myHand.add(dealt);
    }

    public byte getScore() {
        return score;
    }

    public byte calculateScore() {
        score = 0;
        hasAce = false;
        for(var card: myHand) {
            score += card.getValue();
        }
        if (score > 21 && hasAce) {
            score -= 10;
            hasAce = false;
        }
        return score;
    }

    public Player getMyPlayer() {
        return myPlayer;
    }

    public void setScore(byte reset) {
       score = reset;
    }

//    @Override
//    public String toString() {
//        int i++;
//        return myHand.get(i);
//    }
}
