import java.util.*;
public class Card
{
	private Integer num;
	private Integer suit;
	
	
	
	public Card()
	{
		
	}
	
	public Card(int num, int suit) throws Exception
	{
		this.num = num;
		this.suit = suit;
		
		if (num > 12 || num < 0)
		{
			throw new Exception("Invalid num");
		}
		if(suit > 3 || suit < 0)
		{
			throw new Exception("Invalid suit");
		}
	}
	
	public int getNumVal()
	{
		return num;
	}
	
	public String getNum()
	{
		String retVal = num.toString();
		
		switch(num)
		{
		case 0:
			retVal = "A";
			break;
		case 10:
			retVal = "J";
			break;
		case 11:
			retVal = "Q";
			break;
		case 12:
			retVal = "K";
			break;
			default:
			retVal = Integer.toString(( num + 1));
			break;
		}
		return retVal;
	}
	
	public String getSuit()
	{
		
		String retVal = "";
		switch(suit){
		
		case 0:
			retVal = "Spades";
			break;
		case 1:
			retVal = "Clubs";
			break;
		case 2:
			retVal = "Hearts";
			break;
		case 3:
			retVal = "Diamonds";		
			break;
		}
		
		return retVal;
	}
	
	public int getSuitNum()
	{
		return suit;
	}
	
	public String display()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append(getNum());
		builder.append(" of ");
		builder.append(getSuit());
		
		return builder.toString();
	}

	public static Comparator<Card> CardComparator = new Comparator<Card>()
	{
		public int compare(Card card1, Card card2)
		{
			return card1.compareTo(card2);
		}
	};

	public int compareTo(Card card)
	{
		// TODO Auto-generated method stub
		if(getSuitNum() < card.getSuitNum())
		{
			return 0;
		}
		else if (getSuitNum() == card.getSuitNum())
		{
			return (getNumVal() > (card.getNumVal())) ? 1 : 0;
		}
		else 
		{
			return 1;
		}
		
	}
}
