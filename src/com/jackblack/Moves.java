package com.jackblack;

import java.util.ArrayList;

public class Moves {
    private Card card;
    ArrayList<Card> cards;

    public Card removeCard(int position) {
        return cards.remove(position);
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }

    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    public void removeAllCards() {
        for(int i = cards.size() - 1; i >= 0; i--) {
            cards.remove(i);
        }
    }
}
