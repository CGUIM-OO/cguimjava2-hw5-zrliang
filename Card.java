

public class Card {
	enum Suit {Club,Diamond,Heart,Spade} //enumerated type
	private Suit suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(Suit s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		
		String rankarray[]= {"Ace","Two","Three","FOUR","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
		// 確認每一張牌都有印出
		if(Card.Suit.Club==suit)		
		    System.out.println(Card.Suit.Club+","+rankarray[rank-1]);
		if(Card.Suit.Diamond==suit)		
			System.out.println(Card.Suit.Diamond+","+rankarray[rank-1]);
		if(Card.Suit.Heart==suit)		
			System.out.println(Card.Suit.Heart+","+rankarray[rank-1]);
		if(Card.Suit.Spade==suit)		
			System.out.println(Card.Suit.Spade+","+rankarray[rank-1]);
		
		
		
		// define suit 1=clubs, 2=Diamonds, 3=Hearts, 4=Spades
	    //  transfer rank from number to word 
		//print all the cards
		
	}
	public Suit getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}

}
