package com.jackblack;

import java.util.ArrayList;

public class Hand {
    private byte score;
    private ArrayList<Card> myHand;
    private Player myPlayer;


    private Dealer dealer;

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
        for(var card: myHand) {
            byte cardValue = card.getValue();
            if(cardValue == 13 && score < 11) {
                score += 11;
            }
            else if(cardValue == 13 && score > 11) {
                score += 1;
            }
            else if(cardValue > 9 && cardValue < 13) {
                score += 10;
            }
            else {
                score += cardValue;
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

    private void setScore(byte reset) {
       score = reset;
    }

    public Dealer getDealer() {
        return dealer;
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
