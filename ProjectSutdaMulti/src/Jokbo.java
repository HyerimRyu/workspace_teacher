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
			jokbo = "���ȱ���";
		}else if(c1.num == 1 && c2.num == 3&& c1.isKwang==true && c2.isKwang == true) {
			jokboNum = 1990;
			jokbo = "1,3 ����";
		}else if(c1.num == 1 && c2.num == 8 && c1.isKwang==true && c2.isKwang == true) {
			jokboNum = 1980;
			jokbo = "1,8 ����";
		}else if(c1.num == 10 && c2.num == 10) {
			jokboNum = 1970;
			jokbo = "�嶯";
		}else if(c1.num == 9 && c2.num == 9) {
			jokboNum = 1960;
			jokbo = "����";
		}else if(c1.num == 8 && c2.num ==8) {
			jokboNum = 1950;
			jokbo = "�ȶ�";
		}else if(c1.num == 7 && c2.num ==7) {
			jokboNum = 1940;
			jokbo = "ĥ��";
		}else if(c1.num == 6 && c2.num ==6) {
			jokboNum = 1930;
			jokbo = "����";
		}else if(c1.num == 5 && c2.num == 5) {
			jokboNum = 1920;
			jokbo = "����";
		}else if(c1.num == 4 && c2.num == 4) {
			jokboNum = 1910;
			jokbo = "�綯";
		}else if(c1.num == 3 && c2.num == 3) {
			jokboNum = 1900;
			jokbo = "�ﶯ";
		}else if(c1.num == 2 && c2.num == 2) {
			jokboNum = 1890;
			jokbo = "�̶�";
		}else if(c1.num == 1 && c2.num == 1) {
			jokboNum = 1880;
			jokbo = "�涯";
		}else if((c1.num == 1 && c2.num == 2)) {
			jokboNum = 1870;
			jokbo = "�˸�";
		}else if((c1.num == 1 && c2.num == 4)) {
			jokboNum = 1860;
			jokbo = "����";
		}else if((c1.num == 1 && c2.num == 9)) {
			jokboNum = 1850;
			jokbo = "����";
		}else if((c1.num == 1 && c2.num == 10)) {
			jokboNum = 1840;
			jokbo = "���";
		}else if((c1.num == 4 && c2.num == 10)) {
			jokboNum = 1830;
			jokbo = "���";
		}else if((c1.num == 4 && c2.num == 6)) {
			jokboNum = 1820;
			jokbo = "����";
		}else if((c1.num == 4 && c2.num == 9 && c2.isMoreThan10 == true) || (c1.num == 4 && c2.num == 9 && c1.isMoreThan10 == true) || 
				(c1.num == 4 && c2.num == 9 && c1.isMoreThan10 == true && c2.isMoreThan10 == true)) {
			jokboNum = -10;
			jokbo = "�籸";
		}else if(c1.num == 4 && c2.num == 9) {
			jokboNum = -20;
			jokbo = "���ֱ��� �籸";
		}else {
			if ((c1.num + c2.num) % 10 == 0) {
				jokboNum = 0;
				jokbo = "����";
			}else {
				jokboNum = (c1.num + c2.num) % 10;
				jokbo = jokboNum + "��";
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
