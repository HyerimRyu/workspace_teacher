import java.util.ArrayList;

public class Jokbo {
	
	CardDeck cardDeck = new CardDeck();
	Card card;
	int jokboNum;
	String jokbo;
	
	public Jokbo(Card c1, Card c2) {
		// TODO Auto-generated constructor stub
		ArrayList<Card> card = cardDeck.getAll();
		
		
		
		
		if (c1.num ==3 && c2.num ==8 && c1.isKwang==true && c2.isKwang == true) {
			jokboNum = 2000;
			jokbo = "伙迫堡动";
		}else if(c1.num == 1 && c2.num == 3&& c1.isKwang==true && c2.isKwang == true) {
			jokboNum = 1990;
			jokbo = "1,3 堡动";
		}else if(c1.num == 1 && c2.num == 8 && c1.isKwang==true && c2.isKwang == true) {
			jokboNum = 1980;
			jokbo = "1,8 堡动";
		}else if(c1.num == 10 && c2.num == 10) {
			jokboNum = 1970;
			jokbo = "厘动";
		}else if(c1.num == 9 && c2.num == 9) {
			jokboNum = 1960;
			jokbo = "备动";
		}else if(c1.num == 8 && c2.num ==8) {
			jokboNum = 1950;
			jokbo = "迫动";
		}else if(c1.num == 7 && c2.num ==7) {
			jokboNum = 1940;
			jokbo = "磨动";
		}else if(c1.num == 6 && c2.num ==6) {
			jokboNum = 1930;
			jokbo = "腊动";
		}else if(c1.num == 5 && c2.num == 5) {
			jokboNum = 1920;
			jokbo = "坷动";
		}else if(c1.num == 4 && c2.num == 4) {
			jokboNum = 1910;
			jokbo = "荤动";
		}else if(c1.num == 3 && c2.num == 3) {
			jokboNum = 1900;
			jokbo = "伙动";
		}else if(c1.num == 2 && c2.num == 2) {
			jokboNum = 1890;
			jokbo = "捞动";
		}else if(c1.num == 1 && c2.num == 1) {
			jokboNum = 1880;
			jokbo = "绘动";
		}else if((c1.num == 1 && c2.num == 2)) {
			jokboNum = 1870;
			jokbo = "舅府";
		}else if((c1.num == 1 && c2.num == 4)) {
			jokboNum = 1860;
			jokbo = "刀荤";
		}else if((c1.num == 1 && c2.num == 9)) {
			jokboNum = 1850;
			jokbo = "备绘";
		}else if((c1.num == 1 && c2.num == 10)) {
			jokboNum = 1840;
			jokbo = "厘绘";
		}else if((c1.num == 4 && c2.num == 10)) {
			jokboNum = 1830;
			jokbo = "厘荤";
		}else if((c1.num == 4 && c2.num == 6)) {
			jokboNum = 1820;
			jokbo = "技氟";
		}else if((c1.num == 4 && c2.num == 9 && c2.isMoreThan10 == true) || (c1.num == 4 && c2.num == 9 && c1.isMoreThan10 == true) || 
				(c1.num == 4 && c2.num == 9 && c1.isMoreThan10 == true && c2.isMoreThan10 == true)) {
			jokboNum = -10;
			jokbo = "荤备";
		}else if(c1.num == 4 && c2.num == 9) {
			jokboNum = -20;
			jokbo = "港胖备府 荤备";
		}else {
			if ((c1.num + c2.num) % 10 == 0) {
				jokboNum = 0;
				jokbo = "噶烹";
			}else {
				jokboNum = (c1.num + c2.num) % 10;
				jokbo = jokboNum + "昌";
			}
		}
		
		
		
	}
	
	
	public String jokboToString() {
		return jokbo;	
	}
	
	public int whoistheWinner() {
		return jokboNum;
	}
	
}
