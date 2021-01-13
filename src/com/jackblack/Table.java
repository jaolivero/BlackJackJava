package com.jackblack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {
    private static Scanner scan = new Scanner(System.in);
    private byte rounds = 1;
    public byte seats;
    static Player player;
    Deck tableDeck;
    Dealer dealer;
    Hand dealerHand;
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
        System.out.println(dealersHand);
        System.out.println("Dealer's hand");
        addPlayer();
        for (Player playerOne : allPlayers) {
            Hand playerHand = new Hand(playerOne);
            allHands.add(playerHand);
                while(playerOne.getMoney() > 0) {
                    System.out.println("How much would you like to bet? ");
                    int betAmount = scan.nextInt();
                    playerOne.placeBet(betAmount);
                    deal(2,tableDeck, playerHand);
                    playerHand.calculateScore();
                    System.out.println(playerHand);
                    printScore(playerHand);
                    while(playerHand.getScore() <= 21) {
                        System.out.println(playerHand);
                        checkScore(playerHand, tableDeck, playerOne);
                    }
                }
            System.out.println(playerHand);
                // create hand for deal
                //break down method so that we would have less parameters
//            dealer.checkScore();
        }
    }

    public static void deal(int cardsDealt, Deck currentDeck, Hand currentHand) {
        for(int i = 0; i < cardsDealt; i++) {
            Card gettingCard = currentDeck.getCard(0);
            currentDeck.removeCard(0);
            currentHand.addCard(gettingCard);
        }
    }

//      if (currentHand.getScore() > 21) {
//        System.out.println("Bust!!!");
//        System.out.println(currentHand);
//    } else if (currentHand.getScore() == 21) {
//        System.out.println("21 congratulations, you won");
//    } else {

    public boolean checkScore(Hand currentHand, Deck currentDeck, Player myPlayer) {
        System.out.println("Enter (1) for Hit, (2) Stand or (3)Double");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                deal(1, currentDeck, currentHand);
                System.out.println(currentHand);
                currentHand.calculateScore();
                printScore(currentHand);
                if (currentHand.getScore() > 21) {
                    System.out.println("Bust!!!");
                    myPlayer.betResults('L');
                    System.out.println("Available balance is now " + myPlayer.getMoney());
                   return true;
                }
                else if (currentHand.getScore() == 21) {
                    System.out.println("21 congratulations, you won");
                    System.out.println("Available balance is now " + myPlayer.getMoney());
                    myPlayer.betResults('W');
                }
            case 2:
                compareScoreToDealer(currentHand, dealerHand);
                return true;
            case 3:
                myPlayer.doubleBet();
            default:
                System.out.println("error!");
                return true;
        }
    }

    public void addPlayer() {
        System.out.println("Please enter your username");
        String user = scan.nextLine();
        System.out.println("Please enter the total amount of money you would like to use ");
        int balance = scan.nextInt();
        allPlayers.add(new  Player(user, balance));
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
            myHand.getMyPlayer().betResults('L');
        }
    }
}
