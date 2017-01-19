package com.example.demouser.blackjack;
import android.widget.ImageView;

/**
 * Holds methods for each card.
 */
public class Card
{
	/*
	 * Int representation of value in the card.
	 */
	private int value;
		
	/*
	 * Int representation of shape in the card.
	 */
	private int shape;

	/**
	 * Constructor takes in two ints as value and shape.
	 * @param value
	 * @param shape
	 */
	public Card(int value, int shape)
	{
		this.value = value;
		this.shape = shape;
	}
	
	/**
	 * Get value of each card.
	 * @return int
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * Get shape of each card.
	 * @return int
	 */
	public int getShape()
	{
		return shape;
	}
	
	/**
	 * String representation of each card.
	 * @return String
	 */
	public String toString()
	{
		return "value is " + value + ", shape is " + shape;
	}
}