package com.jackblack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {
    private static Scanner scan = new Scanner(System.in);
    private byte rounds = 1;
    boolean isDealCard;
    public byte seats;
    static Player player;
    Deck tableDeck;
    Dealer dealer;
    Hand dealerHand;
    static Hand hand;
    public List<Player> allPlayers = new ArrayList<Player>();
    public List<Hand> allHands = new ArrayList<>();

    public Table(byte seats) {
        this.seats = seats;
    }

    public void game() {
        Deck tableDeck = new Deck();
        tableDeck.shuffle();
        Dealer dealerOne = new Dealer();
        Hand dealersHand = new Hand(dealerOne);
        allHands.add(dealersHand);
        deal(2, tableDeck, dealersHand);
        System.out.println(allHands);
        addPlayer();
        for (Player playerOne : allPlayers) {
            Hand playerHand = new Hand(playerOne);
            while (playerOne.getMoney() > 0) {
                allHands.add(playerHand);
                playerHand.setScore((byte) 0);
                System.out.println("How much would you like to bet? ");
                int betAmount = scan.nextInt();
                playerOne.placeBet(betAmount);
                System.out.println(allPlayers.get(0));
                deal(2,tableDeck, playerHand);
                playerHand.calculateScore();
                System.out.println(playerHand);
                printScore(playerHand);
                checkScore(playerHand, tableDeck, playerOne);
                // create hand for deal
                //break down method so that we would have less parameters
//            dealer.checkScore();
            }
        }
    }

    public static void deal(int cardsDealt, Deck currentDeck, Hand currentHand) {
        for(int i = 0; i < cardsDealt; i++) {
            Card gettingCard = currentDeck.getCard(0);
            currentDeck.removeCard(0);
            currentHand.addCard(gettingCard);
            System.out.println(gettingCard);
        }
    }

    public void checkScore(Hand currentHand, Deck currentDeck, Player myPlayer) {
        if (currentHand.getScore() > 21) {
            System.out.println("Bust!!!");
        } else if (currentHand.getScore() == 21) {
            currentHand.setScore((byte) 0);
            System.out.println("21 congratulations, you won");

        } else {
            System.out.println("Enter (1) for Hit, (2) Stand or (3)Double");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    deal(1, currentDeck, currentHand);
                    currentHand.setScore((byte) 0);
                    currentHand.calculateScore();
                    printScore(currentHand);
                case 2:
                    compareScoreToDealer(currentHand, dealerHand);
                case 3:
                    myPlayer.doubleBet();
            }
        }
        currentHand.setScore((byte) 0);
    }

    public void addPlayer() {
        System.out.println("Please enter your username");
        String user = scan.nextLine();
        System.out.println("Please enter the total amount of money you would like to use ");
        int balance = scan.nextInt();
        allPlayers.add(new Player(user, balance));
    }

    public void printScore(Hand myHand) {
        System.out.println("SCORE");
        System.out.println("----");
        System.out.println(" " + myHand.getScore() + " ");
        System.out.println("----");
    }

    public void compareScoreToDealer(Hand myHand, Hand myDealer) {
        if (myHand.getScore() == myDealer.getScore()) {
            System.out.println("Push");
        }
        else if (myDealer.getScore() > 21) {
            myHand.getMyPlayer().wonBet();
        }
    }
}
