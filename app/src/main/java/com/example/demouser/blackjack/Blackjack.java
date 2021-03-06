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

    protected int bet;
    protected int currentBet;
<<<<<<< HEAD
//    boolean revealDealerCards = false;
=======
    boolean revealDealerCards = false;
    boolean dealerWins = false;
    boolean playerWins = true;
>>>>>>> origin/master



    public Blackjack() {
        deck = new Deck();
        bet = 1000;
    }

    public void startGame() {
        deck = new Deck();

        betGame();

        playerCards.add(deck.drawCard());
        playerCards.add(deck.drawCard());

        dealerCards.add(deck.drawCard());
        //dealerCards.add(deck.drawCard());
    }

    public void checkTurn() {
        //dealer wins
        if (playerScore()>21 && dealerScore() <=21) {
//            revealDealerCards = true;
            dealerWins();
        }
        //player wins
        else if (dealerScore() > 21 && playerScore() <= 21) {
//            revealDealerCards = true;
            playerWins();
        }
    }

    public void betGame() {
        bet = bet - currentBet;
    }

    public void stand() {
        dealerCards.add(deck.drawCard());
        checkTurn();
        dealerTurn();
        int pScore  = 21 - playerScore();
        int dScore = 21 - dealerScore();

        if (playerScore() > 21)
            dealerWins();
        else if (dealerScore() > 21)
            playerWins();

        else if (pScore>dScore) {
            dealerWins();
//            revealDealerCards = true;
        }
        else if (dScore > pScore) {
//            revealDealerCards = true;
            playerWins();
        }
        //what if score is the same
        else if (dealerScore() == playerScore()){
//            revealDealerCards = true;
            tie();
        }
    }

    public void tie() {
        bet += currentBet;
    }

<<<<<<< HEAD
    public void dealerWins() {
=======
    public String dealerWins() {
        return "Dealer won! You lost "+Integer.toString(currentBet);
>>>>>>> origin/master
    }

    public void playerWins() {
        bet += currentBet *2;
<<<<<<< HEAD
=======
        return "You won "+Integer.toString(currentBet*2);
>>>>>>> origin/master
    }

    public void hit() {
        checkTurn();
        playerCards.add(deck.drawCard());
    }

    public void doubleBet() {
        checkTurn();
        //currentBet = currentBet * 2;
        //bet = bet - currentBet;
        playerCards.add(deck.drawCard());
        dealerTurn();
        int pScore  = 21 - playerScore();
        int dScore = 21 - dealerScore();

        if (playerScore() > 21)
            dealerWins();
        else if (dealerScore() > 21)
            playerWins();

        else if (pScore>dScore) {
            dealerWins();
        }
        else if (dScore > pScore) {
            playerWins();
        }
        //what if score is the same
        else if (dealerScore() == playerScore()){
            tie();
        }
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
