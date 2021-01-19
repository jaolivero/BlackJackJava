package com.jackblack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {
    private static Scanner scan = new Scanner(System.in);
    public byte seats;
    Dealer dealer = new Dealer();
    Deck tableDeck = new Deck();
    Hand dealersHand = new Hand(dealer);
    public List<Player> allPlayers = new ArrayList<>();
    public List<Hand> allHands = new ArrayList<>();

    public Table(byte seats) {
        this.seats = seats;
    }

    public void game() {
        tableDeck.shuffle();
        allHands.add(dealersHand);
        deal(2, tableDeck, dealersHand);
        dealersHand.calculateScore();
        printScore(dealersHand);
        addPlayer();
        for (Player playerOne : allPlayers) {
            Hand playerHand = new Hand(playerOne);
            allHands.add(playerHand);
                while(playerOne.getMoney() > 0) {
                    playerOne.placeBet();
                    deal(2,tableDeck, playerHand);
                    playerHand.calculateScore();
                    printScore(playerHand);
                    while(true) {
                        checkScore(playerHand, tableDeck, playerOne);
                    }
                }
            System.out.println(playerHand);
        }
    }

    public static void deal(int cardsDealt, Deck currentDeck, Hand currentHand) {
        for(int i = 0; i < cardsDealt; i++) {
            Card gettingCard = currentDeck.getCard(0);
            currentDeck.removeCard(0);
            currentHand.addCard(gettingCard);
        }
            System.out.println(currentHand);
    }

    public boolean checkScore(Hand currentHand, Deck currentDeck, Player myPlayer) {
        System.out.println("Enter (1) to Hit, (2) to Stand or (3) to Double");
        byte choice = scan.nextByte();
        switch (choice) {
            case 1:
                deal(1, currentDeck, currentHand);
                currentHand.calculateScore();
                printScore(currentHand);
                if (currentHand.getScore() > 21) {
                    System.out.println("Bust!!!");
                    myPlayer.betResults('L');
                    System.out.println("Available balance is now " + myPlayer.getMoney());
                }
                else if (currentHand.getScore() == 21) {
                    System.out.println("21 congratulations, you won");
                    System.out.println("Available balance is now " + myPlayer.getMoney());
                    myPlayer.betResults('W');

                }
                break;
            case 2:
                compareScoreToDealer(currentHand, dealersHand);
                break;
            case 3:
                myPlayer.doubleBet();
            default:
                System.out.println("error!");
        }
        currentHand.removeAllCards();
        return false;
    }

    public void addPlayer() {
        System.out.println("Please enter your username");
        String user = scan.nextLine();
        System.out.println("Please enter the total amount of money you would like to use ");
        int balance = scan.nextInt();
        allPlayers.add(new Player(user, balance));
    }

    public void printScore(Hand myHand) {
        if(myHand.getMyPlayer() instanceof Player) {
            System.out.println(myHand.getMyPlayer().getUsername().toUpperCase() + "'S" + " SCORE");
        }
        else{
            System.out.println(myHand.getDealer().getName().toUpperCase() + "'S" + " SCORE");
        }
        System.out.println("----");
        System.out.println(" " + myHand.getScore() + " ");
        System.out.println("----");
    }

    public void compareScoreToDealer(Hand myHand, Hand myDealer) {
        byte playerScore = myHand.getScore();
        byte dealerScore = myDealer.getScore();
        while(dealersHand.getScore() < 17) {
            deal(1, tableDeck, dealersHand);
            dealersHand.calculateScore();
        }
        printScore(dealersHand);
        if (playerScore == dealerScore) {
            System.out.println("Push");
        } else if (dealerScore > 21) {
            myHand.getMyPlayer().betResults('W');
            System.out.println("Dealer Busted " + dealerScore);
        } else if (playerScore < dealerScore) {
            myHand.getMyPlayer().betResults('L');
            System.out.println("Dealer wins " + dealerScore);
        }
        else {
            System.out.println("You won !!");
            myHand.getMyPlayer().betResults('W');
            System.out.println("Your Current Balance is " + myHand.getMyPlayer().getMoney());
        }
    }
}
