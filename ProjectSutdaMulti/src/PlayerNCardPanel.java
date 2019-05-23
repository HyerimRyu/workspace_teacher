import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

class PlayerNCardPanel extends JPanel{
		
		Image cardImg1, cardImg2, avatar;
		int width,height;
		
		Jokbo jokbo;
		int x,y;
		Card playerCard1, playerCard2;
		
		public PlayerNCardPanel(Card c1, Card c2) {
			// TODO Auto-generated constructor stub
			playerCard1 = c1;
			playerCard2 = c2;
			
			setLayout(new BorderLayout());
		}
		
		
			
		
		
		public void isFirstGameSet() {
			if (playerCard1.num > playerCard2.num) {
				Card temp;
				
				temp = playerCard1;
				playerCard1 = playerCard2;
				playerCard2 = temp;
			}
			
			
			cardImg1 = playerCard1.getCardImg();
			cardImg2 = playerCard2.getCardImg();
			cardImg1 = cardImg1.getScaledInstance(60, 120, Image.SCALE_SMOOTH);
			cardImg2 = cardImg2.getScaledInstance(60, 120, Image.SCALE_SMOOTH);
			
		}
}
