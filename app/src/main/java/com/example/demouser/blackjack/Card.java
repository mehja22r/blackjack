package com.example.demouser.blackjack;
import android.widget.ImageView;

import javax.swing.*;


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
	
	/**
	 * Assigns corresponding image for each card.
	 * @return image depending on the card.
	 */
	public void paintCard()
	{
		ImageView p1 = ((ImageView) findViewById(R.id.p1));

		ImageIcon twoD = new ImageIcon("cards/2d.gif");
		ImageIcon twoH = new ImageIcon("cards/2h.gif");
		ImageIcon twoS = new ImageIcon("cards/2s.gif");
		ImageIcon threeC = new ImageIcon("cards/3c.gif");
		ImageIcon threeD = new ImageIcon("cards/3d.gif");
		ImageIcon threeH = new ImageIcon("cards/3h.gif");
		ImageIcon threeS = new ImageIcon("cards/3s.gif");
		ImageIcon fourC = new ImageIcon("cards/4c.gif");
		ImageIcon fourD = new ImageIcon("cards/4d.gif");
		ImageIcon fourH = new ImageIcon("cards/4h.gif");
		ImageIcon fourS = new ImageIcon("cards/4s.gif");
		ImageIcon fiveC = new ImageIcon("cards/5c.gif");
		ImageIcon fiveD = new ImageIcon("cards/5d.gif");
		ImageIcon fiveH = new ImageIcon("cards/5h.gif");
		ImageIcon fiveS = new ImageIcon("cards/5s.gif");
		ImageIcon sixC = new ImageIcon("cards/6c.gif");
		ImageIcon sixD = new ImageIcon("cards/6d.gif");
		ImageIcon sixH = new ImageIcon("cards/6h.gif");
		ImageIcon sixS = new ImageIcon("cards/6s.gif");
		ImageIcon sevenC = new ImageIcon("cards/7c.gif");
		ImageIcon sevenD = new ImageIcon("cards/7d.gif");
		ImageIcon sevenH = new ImageIcon("cards/7h.gif");
		ImageIcon sevenS = new ImageIcon("cards/7s.gif");
		ImageIcon eightC = new ImageIcon("cards/8c.gif");
		ImageIcon eightD = new ImageIcon("cards/8d.gif");
		ImageIcon eightH = new ImageIcon("cards/8h.gif");
		ImageIcon eightS = new ImageIcon("cards/8s.gif");
		ImageIcon nineC = new ImageIcon("cards/9c.gif");
		ImageIcon nineD = new ImageIcon("cards/9d.gif");
		ImageIcon nineH = new ImageIcon("cards/9h.gif");
		ImageIcon nineS = new ImageIcon("cards/9s.gif");
		ImageIcon tenC = new ImageIcon("cards/10c.gif");
		ImageIcon tenD = new ImageIcon("cards/10d.gif");
		ImageIcon tenH = new ImageIcon("cards/10h.gif");
		ImageIcon tenS = new ImageIcon("cards/10s.gif");
		ImageIcon jC = new ImageIcon("cards/jc.gif");
		ImageIcon jD = new ImageIcon("cards/jd.gif");
		ImageIcon jH = new ImageIcon("cards/jh.gif");
		ImageIcon jS = new ImageIcon("cards/js.gif");
		ImageIcon qC = new ImageIcon("cards/qc.gif");
		ImageIcon qD = new ImageIcon("cards/qd.gif");
		ImageIcon qH = new ImageIcon("cards/qh.gif");
		ImageIcon qS = new ImageIcon("cards/qs.gif");
		ImageIcon kC = new ImageIcon("cards/kc.gif");
		ImageIcon kD = new ImageIcon("cards/kd.gif");
		ImageIcon kH = new ImageIcon("cards/kh.gif");
		ImageIcon kS = new ImageIcon("cards/ks.gif");
		ImageIcon aC = new ImageIcon("cards/ac.gif");
		ImageIcon aD = new ImageIcon("cards/ad.gif");
		ImageIcon aH = new ImageIcon("cards/ah.gif");
		ImageIcon aS = new ImageIcon("cards/as.gif");

		if (this.getValue()==0 && this.getShape()==0)
			return twoC;
		else if (this.getValue()==0 && this.getShape()==1)
			return twoD;
		else if (this.getValue()==0 && this.getShape()==2)
			return twoH;
		else if (this.getValue()==0 && this.getShape()==3)
			return twoS;
		else if (this.getValue()==1 && this.getShape()==0)
			return threeC;
		else if (this.getValue()==1 && this.getShape()==1)
			return threeD;
		else if (this.getValue()==1 && this.getShape()==2)
			return threeH;
		else if (this.getValue()==1 && this.getShape()==3)
			return threeS;
		else if (this.getValue()==2 && this.getShape()==0)
			return fourC;
		else if (this.getValue()==2 && this.getShape()==1)
			return fourD;
		else if (this.getValue()==2 && this.getShape()==2)
			return fourH;
		else if (this.getValue()==2 && this.getShape()==3)
			return fourS;
		else if (this.getValue()==3 && this.getShape()==0)
			return fiveC;
		else if (this.getValue()==3 && this.getShape()==1)
			return fiveD;
		else if (this.getValue()==3 && this.getShape()==2)
			return fiveH;
		else if (this.getValue()==3 && this.getShape()==3)
			return fiveS;
		else if (this.getValue()==4 && this.getShape()==0)
			return sixC;
		else if (this.getValue()==4 && this.getShape()==1)
			return sixD;
		else if (this.getValue()==4 && this.getShape()==2)
			return sixH;
		else if (this.getValue()==4 && this.getShape()==3)
			return sixS;
		else if (this.getValue()==5 && this.getShape()==0)
			return sevenC;
		else if (this.getValue()==5 && this.getShape()==1)
			return sevenD;
		else if (this.getValue()==5 && this.getShape()==2)
			return sevenH;
		else if (this.getValue()==5 && this.getShape()==3)
			return sevenS;
		else if (this.getValue()==6 && this.getShape()==0)
			return eightC;
		else if (this.getValue()==6 && this.getShape()==1)
			return eightD;
		else if (this.getValue()==6 && this.getShape()==2)
			return eightH;
		else if (this.getValue()==6 && this.getShape()==3)
			return eightS;
		else if (this.getValue()==7 && this.getShape()==0)
			return nineC;
		else if (this.getValue()==7 && this.getShape()==1)
			return nineD;
		else if (this.getValue()==7 && this.getShape()==2)
			return nineH;
		else if (this.getValue()==7 && this.getShape()==3)
			return nineS;
		else if (this.getValue()==8 && this.getShape()==0)
			return tenC;
		else if (this.getValue()==8 && this.getShape()==1)
			return tenD;
		else if (this.getValue()==8 && this.getShape()==2)
			return tenH;
		else if (this.getValue()==8 && this.getShape()==3)
			return tenS;
		else if (this.getValue()==9 && this.getShape()==0)
			return jC;
		else if (this.getValue()==9 && this.getShape()==1)
			return jD;
		else if (this.getValue()==9 && this.getShape()==2)
			return jH;
		else if (this.getValue()==9 && this.getShape()==3)
			return jS;
		else if (this.getValue()==10 && this.getShape()==0)
			return qC;
		else if (this.getValue()==10 && this.getShape()==1)
			return qD;
		else if (this.getValue()==10 && this.getShape()==2)
			return qH;
		else if (this.getValue()==10 && this.getShape()==3)
			return qS;
		else if (this.getValue()==11 && this.getShape()==0)
			return kC;
		else if (this.getValue()==11 && this.getShape()==1)
			return kD;
		else if (this.getValue()==11 && this.getShape()==2)
			return kH;
		else if (this.getValue()==11 && this.getShape()==3)
			return kS;
		else if (this.getValue()==12 && this.getShape()==0)
			return aC;
		else if (this.getValue()==12 && this.getShape()==1)
			return aD;
		else if (this.getValue()==12 && this.getShape()==2)
			return aH;
		else if (this.getValue()==12 && this.getShape()==3)
			return aS;
		return null;
	}
}