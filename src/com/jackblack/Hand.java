package com.jackblack;

import java.util.ArrayList;

public class Hand {

    private byte score;
    private ArrayList<Card> myHand;
    private Player myPlayer;
    private Dealer dealer;
    private boolean hasAce;
    private Card card;

    public Hand(Player myPlayer) {
        this.myPlayer = myPlayer;
        this.myHand = new ArrayList<>();
    }

    public Hand(Dealer tableDealer) {
        this.dealer = tableDealer;
        this.myHand = new ArrayList<>();
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
            if(card.getValue() == 13 && score < 11) {
                score =+ 11;
            }
            else if(card.getValue() == 13 && score > 11) {
                score += 1;
            }
            else {
                score += card.getValue();
            }
        }
        return score;
    }

    public void removeAllCards() {
        for(int i = myHand.size() - 1; i >= 0; i--) {
            myHand.remove(i);
        }
    }

    public Player getMyPlayer() {
        return myPlayer;
    }

    public void setScore(byte reset) {
       score = reset;
    }


    @Override
    public String toString() {
        String output = "";
        for (Card aCard : myHand) {
            output += aCard + " ";
        }
        System.out.println(getMyPlayer());
        return output;
    }
}
