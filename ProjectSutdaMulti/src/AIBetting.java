
public class AIBetting {
	
	Jokbo jokbo;
	Card card1, card2;
	
	
	public AIBetting(Card c1, Card c2) {
		// TODO Auto-generated constructor stub
		card1 = c1;
		card2 = c2;
		jokbo = new Jokbo(c1, c2);
	}
	
	public int firstBet() {
		if ((card1.num==8 && card1.isKwang == true) || card1.num==1 || card1.num==2 || (card1.num==3 && card1.isKwang == true) || card1.num==4 || card1.num==9 || card1.num==10) {
			return 1;
		}
		else return 2;
	}
	
	public int SecondBet() {
		if (jokbo.whoistheWinner()<=1870) return 2;
		else return 1;
		
		
		
	}
	
	
	
}
