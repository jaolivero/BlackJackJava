package com.jackblack;

import java.util.List;
import java.util.Scanner;

public class Table {
    boolean isDealCard;
    Player player;
    private List<List<Player>> allPlayers ;
    private List<Card> myHand;
    Scanner scan = new Scanner(System.in);

    public void game() {
        while (player.getMoney() > 0) {
            System.out.print("How much would you like to bet? ") ;
            int betAmount = scan.nextInt();
            player.placeBet(betAmount);
        }
    }

    public void deal() {
        if(isDealCard) {
            for(Player player: allPlayers) {
                Card myCard = Card();
                player.add(myCard);
            }
        }
    }

    public void addPlayer() {
        // new Player.add(Player);
    }
}
