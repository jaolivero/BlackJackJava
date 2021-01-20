package com.jackblack;

import java.util.ArrayList;
import java.util.Random;

public class Deck extends Moves {
    private Card card;
    final static int cardAmount = 52;
    private final String[] suit = {"Hearts", "Club", "Diamond", "Spades"};
    private final static byte[] cardValue = {2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13};

    public Deck() {
        this.cards = new ArrayList<Card>();
        this.createDeck();
    }

    public void createDeck() {
        for (String s : suit) {
            for (byte suitValue : cardValue) {
                cards.add(new Card(suitValue, s));
            }
        }
    }

    public void shuffle() {
        ArrayList<Card> shuffledDeck = new ArrayList<>();
        Random random = new Random();
        int randomIndex = 0;
        int originalSize = cards.size();
        for (int i = 0; i < originalSize; i++) {
            randomIndex = random.nextInt((cards.size()));
            shuffledDeck.add(cards.get(randomIndex));
            cards.remove(randomIndex);
        }
        this.cards = shuffledDeck;
    }

    public Card draw() {
        this.cards.add(this.getCard(0));
        return this.removeCard(0);
    }

    public String toString() {
        String cardListOutput = "";
        int cardCount= 1;
        for (Card thisCard: this.cards) {
            cardListOutput += " \n" + "-" + thisCard.toString();

        }
        return cardListOutput;
    }
}
