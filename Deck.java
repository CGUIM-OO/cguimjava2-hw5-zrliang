import java.util.ArrayList;
import java.util.Random;

public class Deck {
	public ArrayList<Card> usedCard=new ArrayList<Card>();  // 新增usedCard field並實體化
	public int nUsed;                // 新增 nUsed field
	private ArrayList<Card> cards;
	private ArrayList openCard= new ArrayList<Card>();
	
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//確認可以印出每一張牌
		for(int n=nDeck; n>0;n--) {
			    for(int suit=1;suit<=4; suit++) {
					   for(int rank=1;rank<=13;rank++) {
						 
						   if(suit==1) { 
					   Card card =new Card(Card.Suit.Club,rank);
						   cards.add(card); }
					   else if(suit==2) {
						   Card card =new Card(Card.Suit.Diamond,rank);
						   cards.add(card); }
					   
					   else if(suit==3) {
						   Card card =new Card(Card.Suit.Heart,rank);
						   cards.add(card); }
					   
					   else if(suit==4) {
						   Card card =new Card(Card.Suit.Spade,rank);
						   cards.add(card); }
					   
						 
					    // first, print the same suit 1 to 13
					    // second,print all the suits
					   
						//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
						//Hint: Use new Card(x,y) and 3 for loops to add card into deck
						//Sample code start
						//Card card=new Card(1,1); ->means new card as clubs ace
						//cards.add(card);
						//Sample code end
				   }
					   shuffle(); // 重新洗牌
			    }
			}
			
		
	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		 for(int n=0;n<cards.size();n++) { 
				cards.get(n).printCard();
				// print the number of deck
	}}
	
	public ArrayList<Card> getAllCards(){
		return cards;
	}
		
	public Card getOneCard(boolean isOpened) {
		
		
	if(cards.size()==0)	
		shuffle();
		Card temp=cards.get(0);     // 
		cards.remove(0);            // 移除發過的牌
		usedCard.add(temp);         // 把發過的牌放進去usedCard
		nUsed++;                    // 每新增一張,+1
		
		if(isOpened==true)
			openCard.add(temp)	;
	
		
	return temp;
	}
	


	
	public ArrayList getOpenedCard() {
		
		return openCard;
	}
	public void shuffle() { //洗牌
	 
	 for(int i=0;i<nUsed;i++) {          //把發回去的牌拿回來
	 cards.add(usedCard.get(i));
	 }
	 nUsed=0;	//把已經發出去的牌歸零
	 usedCard.clear();
	 openCard.clear();
	 
	 
	 for(int i=0; i<999;i++) { //洗999次牌
		Random rnd = new Random(); 
		int x = rnd.nextInt(cards.size()); //隨機選一張牌，從整副牌裡
	 Card temp=cards.get(x);               //隨機選的那一張牌放進暫存的地方
	 cards.remove(x);                      //移掉選出來的那張牌
	 cards.add(temp);                      //最後把暫存的那張牌放回去牌裡
	 }

/**
 * Description: TODO: please add description here
 */

	}
	}


