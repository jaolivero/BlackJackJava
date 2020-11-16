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
    Dealer dealer;
    static Hand hand;
    public List<Player> allPlayers = new ArrayList<Player>();
    List<Hand> allHands;

    public Table(byte seats) {
        this.seats = seats;
    }

    public void game() {
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(deck);
        Dealer dealerOne = new Dealer();
        addPlayer();
        for (Player playerOne : allPlayers) {
            while (playerOne.getMoney() > 0) {
                //displayPlayerInfo();
                System.out.print("How much would you like to bet? ");
                int betAmount = scan.nextInt();
                playerOne.placeBet(betAmount);
                System.out.println(allPlayers);
                Hand playerHand = new Hand(playerOne);
                allHands.add(playerHand);
                for(int i = 0; i < 2; i++) {
                    Card removed = deck.removeCard(0);
                    System.out.println(removed);
                    playerHand.addCard(removed);
                    System.out.println(playerHand.getScore());
                }
                /*playerOne.doubleBet();
                checkScore();
                System.out.println(myHand);
                System.out.println("Enter hit or stand?");
                String choice = scan.next();
                if (choice.equals("Stand")) {
                    break;
                } else {
                    deal();
                }*/
//            dealer.checkScore();
//            player.checkScore();
            }
        }
    }

    public static void deal() {
    }

    public static void checkScore() {
        Scanner scan = new Scanner(System.in);
        if (hand.getScore() > 21) {
            System.out.println("Bust!!!");
        } else if (hand.getScore() == 21) {
            System.out.println("21 congratulations, you won");
        } else {
            System.out.println("Enter (1) for Hit, (2) Stand or (3)Double");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    deal();
                case 2:
                    System.out.println("");
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
