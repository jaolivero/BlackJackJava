package com.jackblack;

import java.util.Scanner;

public class Player extends Moves{
    public String username;
    public int money;
    public int currentBet;
    boolean doubleBet = false;
    Scanner input = new Scanner(System.in);


    public Player(String username, int money, int currentBet) {
        this.money = money;
        this.currentBet = currentBet;
        this.username = username;
    }

    public void doubleBet () {
        if(doubleBet) {
            currentBet *= 2;
            // deal card after
        }
    }
|
    public void placeBet(int amount) {
        if (amount >= money) {
            currentBet =+ amount;
            money -= amount;
        }
        else {
            System.out.println("Please enter an valid amount.");
        }
    }

    public int getMoney() {
        return money;
    }

}
