package com.jackblack;

import java.util.ArrayList;
import java.util.Arrays;

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


    public Card addCard (Card dealt) {
        Card myCard = dealt;
        //myHand.add(dealt);
       return myCard;
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

//    @Override
//    public String toString() {
//        int i++;
//        return myHand.get(i);
//    }
}
