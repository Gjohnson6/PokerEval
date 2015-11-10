import java.util.*;

public class Deck
{
	ArrayList<Card> cards = new ArrayList<>();
	
	private void generateDeck() throws Exception
	{
		for(int i = 0; i < 13; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				cards.add(new Card(i, j));
			}
		}
		Random rand = new Random();
		for(int i = 0; i < 52; i++)
		{
			int randNum = Math.abs(rand.nextInt() % 51);
			Collections.swap(cards, i, randNum);
		}
	}
	
	public Deck() throws Exception
	{
		generateDeck();
	}
	
	public void printDeck()
	{
		for(Card card : cards)
		{
			System.out.println(card.display());
		}
	}
	
	public int getSize()
	{
		return cards.size();
	}
	
	public ArrayList<Card> DealCards(int size) throws Exception
	{
		ArrayList<Card> cardsToReturn = new ArrayList<>(size);
		if(cards.size() >= size)
		{
			
			for(int i = cards.size() - 1; i > cards.size() - 1 - size; i--)
			{
				cardsToReturn.add(cards.get(i));
			}
			
			cards.removeAll(cardsToReturn);
		}
		else
		{
			throw new Exception("Not enough cards in the deck.");
		}
		return cardsToReturn;
	}
}
