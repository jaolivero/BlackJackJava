package com.jackblack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private Card card;
    final static int cardAmount = 52;
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public void createDeck() {
        for (String suitType : Card.getSuite()) {
            for (int i = 0; i < cardAmount; i++) {
                cards.add(new Card(value, suitType))
            }
        }
    }

    public void shuffle() {
        ArrayList<Card> shuffledDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomIndex = 0;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i++) {
            randomIndex = random.nextInt((this.cards.size()));
            shuffledDeck.add(this.cards.get(randomIndex));
            this.cards.remove(randomIndex);
        }
        this.cards = shuffledDeck;
    }

    public void removeCard(int i) {
        cards.remove(i);
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }

    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }


}
