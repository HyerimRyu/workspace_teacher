import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	
	ArrayList<Card> cards;
	
	public CardDeck() {
		// TODO Auto-generated constructor stub	
		cards = new ArrayList<>();

			for (int i=1;i<21;i++) {
				boolean k = false;
				if (i<11) {
					if (i==1||i==3||i==8) k = true;
					cards.add(new Card(i, k, i+"", false));
					
				}else cards.add(new Card(i-10, k, i+"", true));
				
			}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card getOne() {
    	return cards.remove(0);
    	
    }
    
    public int size(){
        return cards.size();
    }
    
    public ArrayList<Card> getAll() {
    	return cards;
    }
    
    public void resetCardDeck() {
    	cards.removeAll(cards);
    	
    	for (int i=1;i<21;i++) {
			boolean k = false;
			if (i<11) {
				if (i==1||i==3||i==8) k = true;
				cards.add(new Card(i, k, i+"", false));
				
			}else cards.add(new Card(i-10, k, i+"", true));
			
		}
    }
}



class Card{
	
	int num;
	boolean isKwang;
	Image cardImg;
	String a;
	boolean isMoreThan10;
	
	Card(int num, boolean isKwang, String cardname, boolean TF) {
		this.num = num;
		this.isKwang = isKwang;
		isMoreThan10 = TF;
		
		
			Toolkit tool = Toolkit.getDefaultToolkit();
			cardImg = tool.getImage("cardImages/"+cardname+".PNG");
		
					
			a=cardname;
			
		
	}
	
	public Image getCardImg() {
//		System.out.println("cardImages/"+a+".PNG"+ "   "+isMoreThan10);

		return cardImg;
	}
}
