import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class NorthernPlayers extends JPanel{
	
	
	Card player3Card1, player3Card2, player4Card1, player4Card2;
	Player3CardPanel player3CardPanel;
	Player4CardPanel player4CardPanel; 
	GameManager gameManager;
	int player3MoneyLeft;
	int player4MoneyLeft;
	int player3isConnected;
	int player4isConnected;
	AIBetting aiBettingplayer3;
	AIBetting aiBettingplayer4;
	
	public NorthernPlayers(Card p3Card1, Card p3Card2, Card p4Card1, Card p4Card2, GameManager gm) {
		// TODO Auto-generated constructor stub
		player3Card1 = p3Card1;
		player3Card2 = p3Card2;
		player4Card1 = p4Card1;
		player4Card2 = p4Card2;
		gameManager = gm;
		
		setPreferredSize(new Dimension(0, 220));
		setBackground(new Color(255, 0, 0,0));
		setLayout(new GridLayout(0, 2));
		
		player3CardPanel = new Player3CardPanel(player3Card1, player3Card2);
		player4CardPanel = new Player4CardPanel(player4Card1, player4Card2);
		
		aiBettingplayer3 = new AIBetting(player3Card1, player3Card2);
		aiBettingplayer4 = new AIBetting(player4Card1, player4Card2);
		
		add(player4CardPanel);
		add(player3CardPanel);
		
		
	}
	
	class Player4CardPanel extends PlayerNCardPanel{
		
		boolean P4turn = false;

		
		public Player4CardPanel(Card c1, Card c2) {
			super(c1, c2);
			Toolkit tool = Toolkit.getDefaultToolkit();
			avatar=tool.getImage("images/avatar4.png");
			avatar = avatar.getScaledInstance(100, 140, Image.SCALE_SMOOTH);
			
			player4MoneyLeft = 1000000000;
			isFirstGameSet();
			
			player4MoneyLeft = player4MoneyLeft - gameManager.notifyBasicBet();
			gameManager.collectBasicBet();

		}


		
		@Override
		protected void paintComponent(Graphics g) {
			
			g.drawRoundRect(180, 15, 300, 200, 25, 25);		
			g.drawImage(avatar, 195, 55, this);	
			g.setFont(new Font(null, Font.BOLD, 20));
			g.drawString(player4MoneyLeft+"¿ø", 335, 195);	
		}	
	}
	
	
	
	class Player3CardPanel extends PlayerNCardPanel{
		
		boolean P3turn = false;

		
		public Player3CardPanel(Card c1, Card c2) {
			// TODO Auto-generated constructor stub
			super(c1, c2);
			Toolkit tool = Toolkit.getDefaultToolkit();
			avatar=tool.getImage("images/avatar3.png");
			avatar = avatar.getScaledInstance(100, 140, Image.SCALE_SMOOTH);
			
			player3MoneyLeft = 1000000000;
			isFirstGameSet();

			player3MoneyLeft = player3MoneyLeft - gameManager.notifyBasicBet();
			gameManager.collectBasicBet();

		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.drawRoundRect(60, 15, 300, 200, 25, 25);
			g.drawImage(avatar, 75, 55, this);
			g.setFont(new Font(null, Font.BOLD, 20));
			g.drawString(player3MoneyLeft+"¿ø", 215, 195);	
		}
		
	}
	
}
