package com.jackblack;

import java.util.Scanner;

public class Player extends Moves {
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
        if(doubleBet) {
            currentBet *= 2;
            // deal card after
        }
    }

    public void placeBet() {
        System.out.println("Enter bet amount ");
        int betAmount = input.nextInt();
        if (this.getMoney() < betAmount) {
            System.out.println("Please enter an valid amount.");
        }
        else {
            currentBet =+ betAmount;
            money -= betAmount;
        }
    }

    public void betResults(char result) {
        if(result == 'W') {
            money += + currentBet;
        }
        else {
            money -= currentBet;
        }
    }

    public int getMoney() {
        return money;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public String getUsername() {
        return username;
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
