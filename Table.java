import java.util.ArrayList;

public class Table {
 public static final int MAXPLAYER =4;
 private Deck deck;
 private Player[] players;
 private Dealer dealer=new Dealer();
 private int[] pos_betArray=new int[MAXPLAYER];
 private int nDecks;
 public Table (int nDecks) {
	 this.nDecks=nDecks;
	 deck=new Deck(nDecks);
	 players= new Player[MAXPLAYER];
 }
 public void set_player(int pos,Player p) 
 {
	 players[pos]=p;
 }
 public Player[]get_player(){
	 return players;
 }
 public void set_dealer(Dealer d) {
	 dealer=d;
 }
 public Card get_face_up_card_of_dealer() {
	 ArrayList<Card>oneRoundCard;
	 oneRoundCard=dealer.getOneRoundCard();
	 return oneRoundCard.get(1);
 }
 private void ask_each_player_about_bets() {
	 for(int i=0;i<MAXPLAYER;i++) {
		 players[i].sayHello();
		 pos_betArray[i]=players[i].makeBet();
	 }
	 
 }
 private void distribute_cards_to_dealer_and_players() {
	 for(int i=0;i<MAXPLAYER;i++) {
		 ArrayList<Card> playerCard = new ArrayList<Card>();
		 playerCard.add(deck.getOneCard(true));
		 playerCard.add(deck.getOneCard(true));
		 players[i].setOneRoundCard(playerCard);
	 }
	 ArrayList<Card> dealerCard = new ArrayList<Card>();
	 dealerCard.add(deck.getOneCard(false));
	 dealerCard.add(deck.getOneCard(true));
	 dealer.setOneRoundCard(dealerCard);
	 
	 System.out.print("Dealer's face up card is ");
	 Card c = get_face_up_card_of_dealer();
	 c.printCard();
	 
		 
 }
 private void ask_each_player_about_hits() {
	 ArrayList<Card> playerCard =new ArrayList<Card>();
	 for(int i=0;i<MAXPLAYER;i++) {
		 boolean hit = false;
		 System.out.print(players[i].getName()+"'s Cards now:");
		 players[i].printAllCard();
		 do {
			 hit=players[i].hit_me(this);
			 if(hit) {
				 
				 playerCard =players[i].getOneRoundCard();
				 playerCard.add(deck.getOneCard(true));
				 players[i].setOneRoundCard(playerCard);
				 System.out.println("Hit!");
				 System.out.println(players[i].getName()+"'s Cards now:");
				 for(Card c : players[i].getOneRoundCard()) {
					 c.printCard();
				 }
				
					 
				 } else {
					 System.out.println("Pass hit!");
					 System.out.println(players[i].getName()+"'s hit is over!");
					 
			 }
			 
			 
		 } while(hit);
	 }
 }
 private void ask_dealer_about_hits() {
	
		 boolean hit = false;
		 do {
			 hit=dealer.hit_me(this);
			 if(hit) {
				 ArrayList<Card> DealerCard =new ArrayList<Card>();
				 DealerCard =dealer.getOneRoundCard();
				 DealerCard.add(deck.getOneCard(true));
				 dealer.setOneRoundCard(DealerCard);
				 System.out.println("Hit!");
				 System.out.println("Dealer's Cards now:");
				 for(Card c : dealer.getOneRoundCard()) {
					 c.printCard();
				 }
			 }
			 else {
				 System.out.println("Dealer's hit is over!");
				 System.out.println("Dealer's Cards now:");
				 for(Card c : dealer.getOneRoundCard()) {
					 c.printCard();
				 }				 
			 }		 		 
				 }while(hit);
			 }
 private void calculate_chips() {
	 int DealerChip;
	 DealerChip = dealer.getTotalValue();
	 System.out.println("Dealer's card value is "+DealerChip+",Cards:");
	 dealer.printAllCard();
	 for(int i=0; i<MAXPLAYER;i++) {
		 players[i].getTotalValue();
		 System.out.println(players[i].getName()+"'s Card:");
		 players[i].printAllCard();
		 System.out.print(players[i].getName()+"'s Card value is "+players[i].getTotalValue());
		 if(players[i].getTotalValue()<=21&&dealer.getTotalValue()>21) {
			 players[i].increaseChips(pos_betArray[i]);
			 System.out.print(",Get "+pos_betArray[i]+" Chips, the Chips now is:");
			  }
		 else if(players[i].getTotalValue()>21&&dealer.getTotalValue()<=21) {
			 players[i].increaseChips(-pos_betArray[i]);
			 System.out.print(",Loss "+pos_betArray[i]+" Chips, the Chips now is:");
			  }
		 else if(players[i].getTotalValue()>dealer.getTotalValue()&&players[i].getTotalValue()<=21) {
			 players[i].increaseChips(pos_betArray[i]);
			 System.out.print(",Get "+pos_betArray[i]+" Chips, the Chips now is:");
			   }
		 else if(players[i].getTotalValue()<dealer.getTotalValue()&&dealer.getTotalValue()<=21) {
			 players[i].increaseChips(-pos_betArray[i]);
			 System.out.print(",Loss "+pos_betArray[i]+" Chips, the Chips now is:");
			   }
		 else {
			 System.out.print(",chips has no change! The Chips now is: ");
		 }System.out.println(players[i].getCurrentChips());
	 }    
	 
 }
 public int[] get_players_bet() {
	 return pos_betArray;
 }
 public void play() {
 ask_each_player_about_bets();
 distribute_cards_to_dealer_and_players();
 ask_each_player_about_hits();
 ask_dealer_about_hits();
 calculate_chips();
}
}
