package com.jackblack;

import java.util.Scanner;

public class Player extends Moves {
    private int rounds;
    private String username;
    private int money;
    private int currentBet;
    boolean doubleBet = false;
    Scanner input = new Scanner(System.in);


    public Player(String username, int money) {
        this.money = money;
        this.username = username;
    }

    public void doubleBet () {
        if(doubleBet && rounds == 1) {
            currentBet *= 2;
            // deal card after
        }
    }

    public void placeBet(int amount) {
        if (this.getMoney() < amount) {
            System.out.println("Please enter an valid amount.");
        }
        else {
            currentBet =+ amount;
            money -= amount;
        }
    }

    public int wonBet() {
        return money + currentBet;
    }

    public int getMoney() {
        return money;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    @Override
    public String toString() {
        return
                "username = " + username +
                " money = " + money +
                " currentBet = " + currentBet;
    }

//   public String toString()  {
//    return currentBet + " "  + " " + username + " " + money;
//   }
}
