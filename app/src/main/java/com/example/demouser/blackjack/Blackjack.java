package com.example.demouser.blackjack;

import java.util.ArrayList;

/**
 * Created by demouser on 1/13/17.
 */

public class Blackjack {

    Deck deck;

    ArrayList<Card> playerCards = new ArrayList<Card>();
    ArrayList<Card> dealerCards = new ArrayList<Card>();

    int bet;
    final int MAX_BET = 500;
    final int MIN_BET = 10;


    public Blackjack() {
        deck = new Deck();
        bet = 1000;
    }

    public void startGame() {

        betGame(0);

        playerCards.add(deck.drawCard());
        playerCards.add(deck.drawCard());

        dealerCards.add(deck.drawCard());
        dealerCards.add(deck.drawCard());


    }

    public void betGame(int betAmount) {
        bet = bet - betAmount;
    }

    public void stand() {

    }

    public void hit() {}

    public void doubleBet() {

    }

    public void split() {}

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public ArrayList<Card> getDealerCards() {
        return dealerCards;
    }

}
