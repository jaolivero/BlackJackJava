package com.jackblack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private Card card;
    final static int cardAmount = 52;
    private final static byte[] cardValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public void createDeck() {
        for (Suite suitType : Suite.values()) {
            for (byte suitValue : cardValue) {
                cards.add(new Card(suitValue,suitType));
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

    public void draw(Deck currentDeck) {
        this.cards.add(currentDeck.getCard(0));
        currentDeck.removeCard(0);
    }

    public String toString() {
        String cardListOutput = "";
        int cardCount= 1;
        for (Card thisCard: this.cards) {
            cardListOutput += " \n" + "-" + thisCard.toString();
            cardCount++;
        }
        return cardListOutput;
    }
}
