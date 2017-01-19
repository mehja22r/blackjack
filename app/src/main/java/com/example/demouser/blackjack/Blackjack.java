package com.example.demouser.blackjack;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by demouser on 1/13/17.
 */

public class Blackjack {

    private Deck deck;

    private ArrayList<Card> playerCards = new ArrayList<Card>();
    private ArrayList<Card> dealerCards = new ArrayList<Card>();

    private int bet;
    private final int MAX_BET = 500;
    private final int MIN_BET = 10;
    protected int currentBet;

    //cannot exceed 5
    private int hitCount;
    private boolean doubleBetBoolean;


    public Blackjack() {
        deck = new Deck();
        bet = 1000;

        hitCount = 0;
        doubleBetBoolean = false;
    }

    public void startGame() {

        //betGame(0);

        playerCards.add(deck.drawCard());
        playerCards.add(deck.drawCard());

        dealerCards.add(deck.drawCard());
        dealerCards.add(deck.drawCard());
    }

    public void checkTurn() {
        //dealer wins
        if (playerScore()>21 && dealerScore() <=21) {
            dealerWins();
        }
        //player wins
        else if (dealerScore() > 21 && playerScore() <= 21) {
            playerWins();
        }
    }

    public void betGame(int betAmount) {
        currentBet = betAmount;
        bet = bet - betAmount;
    }

    public void stand() {
        checkTurn();
        dealerTurn();
        int pScore  = 21 - playerScore();
        int dScore = 21 - dealerScore();

        if (pScore>dScore) {
            dealerWins();
        }
        else if (dScore > pScore) {
            playerWins();
        }
        //what if score is the same
        else {
            tie();

        }

    }

    public void tie() {
        bet = bet + currentBet;
    }

    public void dealerWins() {
    }

    public void playerWins() {
        bet += currentBet *2;
    }

    public void hit() {
        checkTurn();
        if (hitCount < 5) {
            playerCards.add(deck.drawCard());
            hitCount++;
        }
        else {
            System.out.println("Cannot hit more than five times");
        }
    }

    public void doubleBet() {
        checkTurn();
        doubleBetBoolean = true;
        bet = bet * 2;
        playerCards.add(deck.drawCard());
        stand();
    }

    public void dealerTurn() {
        while (dealerScore() < 16) {
            dealerCards.add(deck.drawCard());
        }
    }

    public ArrayList<Card> getPlayerCards() {

        return playerCards;
    }

    public ArrayList<Card> getDealerCards() {

        return dealerCards;
    }

    public int playerScore() {
        int playerTotal = 0;

        for (int i = 0; i < playerCards.size(); i++) {
            int realValues = playerCards.get(i).getValue();

            if (realValues <= 8) {
                playerTotal += realValues + 2;
            }
            else if (realValues >= 9 && realValues <= 11)
                playerTotal += 10;
            else {
                int temp = 21-playerTotal;
                if (temp <= 10) {
                    realValues = 1;
                    playerTotal += realValues;
                }
                else {
                    realValues = 11;
                    playerTotal += realValues;
                }
            }
        }
        return playerTotal;
    }

    public int dealerScore() {
        int dealerTotal = 0;

        for (int i = 0; i < dealerCards.size(); i++) {
            int realValues = dealerCards.get(i).getValue();

            if (realValues <= 8) {
                dealerTotal += realValues + 2;
            }
            else if (realValues >= 9 && realValues <= 11)
                dealerTotal += 10;
            else {
                int temp = 21-dealerTotal;
                if (temp <= 10) {
                    realValues = 1;
                    dealerTotal += realValues;
                }
                else {
                    realValues = 11;
                    dealerTotal += realValues;
                }
            }
        }
        return dealerTotal;
    }
}
