package com.example.demouser.blackjack;
import java.util.Collections;
import java.util.Stack;

/**
 * Holds a standard deck of 52 cards.
 */
public class Deck
{
	/*
	 * Instance of array of Cards.
	 */
	public Card[] cards;
	
	/*
	 * Stack of a deck of cards.
	 */
	public Stack<Card> deck;
	
	/*
	 * All possible values of cards.
	 */
	protected String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	
	/*
	 * All possible shapes of cards.
	 */
	protected String[] shapes = {"clover", "diamond", "heart", "spade"};
		
	/**
	 * Assigns values and shapes for each card using a nested for loop.
	 * Store all cards into a stack, and randomize the stack.
	 */
	public Deck()
	{
		cards = new Card[52];
		
		deck = new Stack<Card>();

		int c = 0;
		for (int i = 0; i < values.length; i ++)
		{
			for (int j = 0; j < shapes.length; j++)
			{
				cards[c] = new Card(i,j);
				c++;
			}
		}
		
		for (int k = 0; k <= 51; k++)
		{
			deck.push(cards[k]);
		}
		
		Collections.shuffle(deck);
	}
	
	/**
	 * Pops out a card from the stack.
	 * @return Card
	 */
	public Card drawCard()
	{
		return deck.pop();
	}
}