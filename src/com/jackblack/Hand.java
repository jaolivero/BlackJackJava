package com.jackblack;

import java.util.ArrayList;

public class Hand {

    private byte score;
    private ArrayList<Card> myHand;
    private Player myPlayer;
    private Dealer dealer;
    private Card card;

    public Hand(Player myPlayer) {
        this.myPlayer = myPlayer;
        this.myHand = new ArrayList<Card>();
    }

    public Hand(Dealer tableDealer) {
        this.dealer = tableDealer;
    }


    public void addCard (Card dealt) {
        this.myHand.add(dealt);
    }

    public byte getScore() {
        return score;
    }

    public byte calculateScore() {
        for(Card myCard: myHand) {
            score += myCard.getValue();
            //TOTAL SCORE???
        }
        return score;
    }

    public Player getMyPlayer() {
        return myPlayer;
    }

    public void setScore(byte reset) {
       score = reset;
    }

    @Override
    public String toString() {
        return " ";
    }
}
