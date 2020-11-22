package com.jackblack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {
    private static Scanner scan = new Scanner(System.in);
    private byte round = 1;
    boolean isDealCard;
    public byte seats;
    static Player player;
    Deck tableDeck;
    Dealer dealer;
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
        addPlayer();
        for (Player playerOne : allPlayers) {
            Hand playerHand = new Hand(playerOne);
            allHands.add(playerHand);
            while (playerOne.getMoney() > 0) {
                //displayPlayerInfo();
                System.out.println("How much would you like to bet? ");
                int betAmount = scan.nextInt();
                playerOne.placeBet(betAmount);
                System.out.println(allPlayers.get(0));
                deal(2,tableDeck, playerHand);
                playerHand.calculateScore();
                System.out.println("Score");
                System.out.println("----");
                System.out.println(" " + playerHand.getScore()+ " ");
                System.out.println("----");
                checkScore(playerHand, tableDeck);
                // create hand for deal
                //break down method so that we would have less parameters
//            dealer.checkScore();
//            player.checkScore();
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

    public static void checkScore(Hand currentHand, Deck currentDeck) {
        if (currentHand.getScore() > 21) {
            System.out.println("Bust!!!");
            currentHand.setScore((byte) 0);
        } else if (currentHand.getScore() == 21) {
            currentHand.setScore((byte) 0);
            System.out.println("21 congratulations, you won");

        } else {
            System.out.println("Enter (1) for Hit, (2) Stand or (3)Double");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    deal(1, currentDeck, currentHand);
                case 2:
                    currentHand.calculateScore();
                case 3:
                    player.doubleBet();
                    System.out.println(player.getCurrentBet());
            }
        }
    }

    public void addPlayer() {
        System.out.println("Please enter your username");
        String user = scan.nextLine();
        System.out.println("Please enter the total amount of money you would like to use ");
        int balance = scan.nextInt();
        allPlayers.add(new Player(user, balance));
    }
}
