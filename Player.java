

import java.util.ArrayList;

public class Player extends Person {

	
	
	private String name; //姓名
	private int chips;   //玩家有的籌碼
	private int bet;     //玩家此局下注的籌碼
	
	
	public Player(String name, int chips) {
		this.name=name;  //constructor 用到外面
		this.chips=chips;
		
	}
	public String getName() {
		
		return name;	
	}
	public int makeBet() {
		bet=1;
		return bet;	
	}
	
	public boolean hit_me(Table table) {
		
		
		
	if(getTotalValue()<=16)  //用總值來判斷
		return true;
	else
		return false;
	} 
	
	
	//public int getTotalValue() {
	//	int total=0;               //將每局拿到的牌的rank加起來
	//	for(Card p:oneRoundCard)
	//		total+=p.getRank();
	//	return total;
			
			
			
	//}
	public int getCurrentChips() {
		
		return chips;
	}
	public void increaseChips (int diff) {
		chips+=diff;
		
	}
	public void sayHello() {
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
	}

}

