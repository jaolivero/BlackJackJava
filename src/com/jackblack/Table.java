package com.jackblack;

import java.util.List;
import java.util.Scanner;

public class Table {
    boolean isDealCard;
    public byte seats = 6;
    Player player;
    Dealer dealer;
    Hand hand;
    private List<Player> allPlayers;
    private List<Card> myHand;
    Scanner scan = new Scanner(System.in);

    public void game() {
        Deck deck = new Deck();
        deck.shuffle();
        while (player.getMoney() > 0) {
            //displayPlayerInfo();
            System.out.println(player.toString());
            System.out.print("How much would you like to bet? ");
            int betAmount = scan.nextInt();
            player.placeBet(betAmount);
            deal();
            System.out.println(myHand);
            System.out.println("Enter hit or stand?");
            String choice = scan.next();
            if (choice.equals("Stand")) {
                break;
            } else {
                deal();
            }
//            dealer.checkScore();
//            player.checkScore();
        }
    }

    public void deal() {
        if (isDealCard) {
            for (Player play: allPlayers) {

            }
        }
    }

    public void checkScore() {
        if (hand.getScore() > 21) {
            System.out.println("Bust!!!");

            //player.money - player.currentBet;
        }
    }

    public void addPlayer(Player newPlayer) {
        if (allPlayers.size() < seats) {
            allPlayers.add(newPlayer);
            System.out.println(allPlayers);
        }
    }
}
