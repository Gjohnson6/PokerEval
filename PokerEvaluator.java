import java.util.ArrayList;
import java.util.Collections;


public class PokerEvaluator
{
	ArrayList<Integer> handTypes;
	
	public PokerEvaluator()
	{
		handTypes = new ArrayList<Integer>(Collections.nCopies(10, 0));
			
	}
	
	public void beginEvaluating(int divisor) throws Exception
	{
		 
		for(int i = 0; i < divisor; i++)
		{
			Hand hand = new Hand(5);
			Deck deck = new Deck();

			for(Card card : deck.DealCards(hand.getSize()))
			{
				hand.addCard(card);
			}
			
			hand.sort();
			Evaluate(hand);
		}

		System.out.println("Chance of getting a Royal Flush is %" + 100 * (handTypes.get(0) / (float)divisor));
		System.out.println("Chance of getting a Straight Flush is %" + 100 * (handTypes.get(1) / (float)divisor));
		System.out.println("Chance of getting a Four of a Kind is %" + 100 * (handTypes.get(2) / (float)divisor));
		System.out.println("Chance of getting a Full House is %" + 100 * (handTypes.get(3) / (float)divisor));
		System.out.println("Chance of getting a Flush is %" + 100 * (handTypes.get(4) / (float)divisor));
		System.out.println("Chance of getting a Straight is %" + 100 * (handTypes.get(5) / (float)divisor));
		System.out.println("Chance of getting a Three of a Kind is %" + 100 * (handTypes.get(6) / (float)divisor));
		System.out.println("Chance of getting a Two Pair is %" + 100 * (handTypes.get(7) / (float)divisor));
		System.out.println("Chance of getting a Pair is %" + 100 * (handTypes.get(8) / (float)divisor));
		System.out.println("Chance of getting a High Card is %" + 100 * (handTypes.get(9) / (float)divisor));
	}
	
	private void Evaluate(Hand hand) throws Exception
	{
		if(RoyalFlush(hand))
		{
			handTypes.set(0, handTypes.get(0) + 1);
			System.out.println("Royal flush");
			RoyalFlush(hand);
			hand.printHand();
		}
		else if(StraightFlush(hand))
		{
			handTypes.set(1, handTypes.get(1) + 1);
			
		}
		else if(FourOfAKind(hand))
		{
			handTypes.set(2, handTypes.get(2) + 1);
			
		}
		else if(FullHouse(hand))
		{
			handTypes.set(3, handTypes.get(3) + 1);
			
		}
		else if(Flush(hand))
		{
			handTypes.set(4, handTypes.get(4) + 1);
			
		}
		else if(Straight(hand))
		{
			handTypes.set(5, handTypes.get(5) + 1);
		}
		else if(ThreeOfAKind(hand))
		{
			handTypes.set(6, handTypes.get(6) + 1);
		}
		else if(TwoPair(hand))
		{
			handTypes.set(7, handTypes.get(7) + 1);
		}
		else if(Pair(hand))
		{
			handTypes.set(8, handTypes.get(8) + 1);
		}
		else
		{
			handTypes.set(9, handTypes.get(9) + 1);
		}
	}

	private Boolean RoyalFlush(Hand hand)
	{
		int counter = 0;
		for(int i = 0; i < hand.getHand().size() - 1; i++)
		{
			if (hand.getHand().get(i).getSuitNum() == hand.getHand().get(i+1).getSuitNum())
			{
				counter++;
				if(counter == 4)
				{
					if(hand.getHand().get(i - 2).getNumVal() == 9 && hand.getHand().get(i - 3).getNumVal() == 0)
					{
						return true;
					}
				}
			}
			else 
			{
				counter = 0;
			}
		}
		
		return false;
	}
	private Boolean StraightFlush(Hand hand)
	{
		int counter = 0;
		for(int i = 0; i < hand.getHand().size() - 1; i++)
		{
			if (hand.getHand().get(i).getSuitNum() == hand.getHand().get(i+1).getSuitNum())
			{
				counter++;
				if(counter == 4)
				{
					if(hand.getHand().get(i - 3).getNumVal() == hand.getHand().get(i + 1).getNumVal() - 4)
					{
						return true;
					}
				}
			}
			else 
			{
				counter = 0;
			}
		}
		
		return false;
	}
	private Boolean FourOfAKind(Hand hand)
	{
		int counter = 0;
		for(Card card : hand.getHand())
		{
			for(Card card2 : hand.getHand())
			{
				if(card2.getNumVal() == card.getNumVal())
				{
					counter++;
					if(counter == 4)
					{
						return true;
					}
				}
			}
			counter = 0;
		}
		return false;
	}
	private Boolean FullHouse(Hand hand) throws Exception
	{
		Boolean isPair = false;
		Boolean isThree = false;
		for(Card card : hand.getHand())
		{
			Hand hand2 = new Hand(5);
			for(Card card2 : hand.getHand())
			{
				if(card2.getNumVal() == card.getNumVal())
				{
					hand2.addCard(card2);
					
				}
			}
			
			if(hand2.getHand().size() == 2)
			{
				isPair = true;
			}
			else if (hand2.getHand().size() == 3)
			{
				isThree = true;
			}
		}
		
		return (isPair && isThree);
	}
	private Boolean Flush(Hand hand)
	{
		int counter = 0;
		for(int i = 0; i < hand.getHand().size() - 1; i++)
		{
			if (hand.getHand().get(i).getSuitNum() == hand.getHand().get(i+1).getSuitNum())
			{
				counter++;
				if(counter == 4)
				{
					return true;
				}
			}
			else 
			{
				return false;
			}
		}
		return false;
	}
	private Boolean Straight(Hand hand)
	{
		int lowestNum = 15;
		for(Card card : hand.getHand())
		{
			if(card.getNumVal() < lowestNum)
			{
				lowestNum = card.getNumVal();
			}
		}
		
		int findNum = lowestNum;
		int counter = 0;
		
		for(int i = 0; i < 5; i++)
		{
			for(Card card : hand.getHand())
			{
				if(card.getNumVal() == findNum + i)
				{
					counter++;
					break;
				}
			}
		}
		
		if (counter == 5)
		{
			return true;
		}
		
		return false;
	}
	private Boolean ThreeOfAKind(Hand hand) throws Exception
	{
		Boolean isThree = false;
		for(Card card : hand.getHand())
		{
			Hand hand2 = new Hand(5);
			for(Card card2 : hand.getHand())
			{
				if(card2.getNumVal() == card.getNumVal())
				{
					hand2.addCard(card2);
					
				}
			}
			if (hand2.getHand().size() == 3)
			{
				isThree = true;
			}
		}
		return isThree;
	}
	private Boolean TwoPair(Hand hand) throws Exception
	{
		int pairCounter = 0;
		for(Card card : hand.getHand())
		{
			Hand hand2 = new Hand(5);
			for(Card card2 : hand.getHand())
			{
				if(card2.getNumVal() == card.getNumVal())
				{
					hand2.addCard(card2);
				}
			}
			
			if(hand2.getHand().size() == 2)
			{
				pairCounter++;
				if(pairCounter == 3)
				{
					return true;
				}
			}
		}
		return false;
	}

	private Boolean Pair(Hand hand) throws Exception
	{

		Boolean isPair = false;
		for(Card card : hand.getHand())
		{
			Hand hand2 = new Hand(5);
			for(Card card2 : hand.getHand())
			{
				if(card2.getNumVal() == card.getNumVal())
				{
					hand2.addCard(card2);
				}
			}
			
			if(hand2.getHand().size() == 2)
			{
				isPair = true;
			}
		}
		return isPair;
	}
}
