import static org.junit.Assert.*;

import org.junit.Test;


public class CardTest
{

	@Test
	public void ctorTest()
	{
		Card card;
		try
		{
			card = new Card(1, 3);
			assertEquals("2", card.getNum());
			assertEquals("Diamonds", card.getSuit());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			Card card2 = new Card(3, 50);
			fail();
		}
		catch(Exception e)
		{
			
		}
		//fail("Not yet implemented");
	}
	
	@Test
	public void printTest()
	{
		try
		{
			Card card = new Card(1, 3);
			assertEquals("2 of Diamonds", card.display());
			///assertTrue(card.display().equals("1 of Diamonds"));
		} catch (Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void deckTest()
	{
		try
		{
			Deck deck = new Deck();
			Deck deck2 = new Deck();
		}
		catch (Exception e)
		{
			fail(e.getMessage());
		}
	}
	
	@Test
	public void handTest()
	{
		try
		{
			Hand hand = new Hand(5);
			assertEquals(5, hand.getSize());
			
			Hand hand2 = new Hand(7);
			assertEquals(7, hand2.getSize());
			
			Hand hand3 = new Hand(3);
			fail();
		} catch (Exception e)
		{
			
		}
	}
	
	@Test
	public void DealTest()
	{
		try
		{
			Deck deck = new Deck();
			int beforeSize = deck.getSize();
			
			Hand hand = new Hand(5);
			Hand hand2 = new Hand(7);
			
			for(Card card : deck.DealCards(hand.getSize()))
			{
				hand.addCard(card);
			}
			
			for(Card card : deck.DealCards(hand2.getSize()))
			{
				hand2.addCard(card);
			}
			
			int afterSize = deck.getSize();
			
			assertEquals(beforeSize, hand.getSize() + hand2.getSize() + afterSize);
			
		} catch (Exception e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	@Test
	public void CompareTest()
	{
		try
		{
			Card card1 = new Card(0, 3);
			Card card2 = new Card(3, 0);
			assertEquals(1, card1.compareTo(card2));
		} catch (Exception e)
		{
			fail(e.getMessage());
		}
	}
	
	@Test
	public void sortTest()
	{
		try
		{
			Deck deck = new Deck();
			int beforeSize = deck.getSize();
			
			Hand hand = new Hand(7);
			
			for(Card card : deck.DealCards(hand.getSize()))
			{
				hand.addCard(card);
			}
			
			
			hand.sort();
		} catch (Exception e)
		{
			fail(e.getMessage());
		}
	}
	
	@Test
	public void evalTest()
	{
		try
		{
			PokerEvaluator evaluator = new PokerEvaluator();
			evaluator.beginEvaluating(10000);
		} catch (Exception e)
		{
			fail(e.getMessage());
		}
	}
}
