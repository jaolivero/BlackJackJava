package com.jackblack;

import java.util.ArrayList;

public class Hand extends Moves {
    private byte score;
    private Player myPlayer;
    private Dealer dealer;

    public Hand(Player myPlayer) {
        this.myPlayer = myPlayer;
        this.cards = new ArrayList<>();
    }

    public Hand(Dealer tableDealer) {
        this.dealer = tableDealer;
        this.cards = new ArrayList<>();
    }

    public byte getScore() {
        return score;
    }

    public byte calculateScore() {
        score = 0;
        for(var card: cards) {
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

    public Player getMyPlayer() {
        return myPlayer;
    }

    public Dealer getDealer() {
        return dealer;
    }

    @Override
    public String toString() {
        String output = "";
        for (Card aCard : cards) {
            output += aCard + " ";
        }
        return output;
    }
}
