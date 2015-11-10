import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Hand
{
	private ArrayList <Card> hand;
	private int size = 0;
	
	public Hand(int size) throws Exception
	{
		if(size == 5 || size == 7)
		{
			hand = new ArrayList<>(size);
			this.size = size;
		}
		else
		{
			throw new Exception("Invalid hand size");
		}
		
	}
	
	public void sort()
	{
		boolean isSorted = false;
		while(!isSorted)
		{
			isSorted = true;
			for(int i = 1; i < hand.size(); i++)
			{
				if(hand.get(i).compareTo(hand.get(i-1)) == 0)
				{
					isSorted = false;
					Collections.swap(hand, i, i-1);
				}
			}
		}
	}
	
	public void addCard(Card card) throws Exception
	{
		if(hand.size() + 1 <= size)
		{
			hand.add(card);
		}
		else
		{
			throw new Exception("Too many cards");
		}
	}
	
	public ArrayList<Card> getHand()
	{
		return hand;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void printHand()
	{
		for(Card card : hand)
		{
			System.out.println(card.display());
		}
	}
}
