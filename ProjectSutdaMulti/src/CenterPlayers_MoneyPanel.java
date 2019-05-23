import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CenterPlayers_MoneyPanel extends JPanel {
	
	
	
	
	Player2CardPanel player2CardPanel;
	Player5CardPanel player5CardPanel;
	MoneyPanel moneyPanel;
	GameManager gameManager;
	int player2MoneyLeft;
	int player5MoneyLeft;
	int player2isConnected=0;
	int player5isConnected=0;
	int pot;
	AIBetting aiBettingplayer5;
	AIBetting aiBettingplayer2;

	Card player2Card1, player2Card2, player5Card1, player5Card2;
	
	
	
	
	public CenterPlayers_MoneyPanel(Card p2Card1, Card p2Card2, Card p5Card1, Card p5Card2, GameManager gm) {
		// TODO Auto-generated constructor stub
		player2Card1 = p2Card1;
		player2Card2 = p2Card2;
		player5Card1 = p5Card1;
		player5Card2 = p5Card2;
		gameManager = gm;
		
		
		setBackground(new Color(255, 0, 0,0));
		setLayout(new GridLayout(0, 3));
		player5CardPanel = new Player5CardPanel(player5Card1, player5Card2);
		player2CardPanel = new Player2CardPanel(player2Card1, player2Card2);
		moneyPanel = new MoneyPanel();
		aiBettingplayer5 = new AIBetting(player5Card1, player5Card2);
		aiBettingplayer2 = new AIBetting(player2Card1, player2Card2);
		add(player5CardPanel);
		add(moneyPanel);
		add(player2CardPanel);
		
		
		
	}
	
	class MoneyPanel extends JPanel{
			
		public MoneyPanel() {
			
			pot=gameManager.getMoneyCollection();
			
		}
		
		public void givePot() {
			pot=gameManager.getMoneyCollection();
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			//g.setColor(new Color(0,0,0,130));
			g.drawRoundRect(30, 45, 300, 200, 25, 25);
			g.setColor(new Color(0,0,0,255));
			g.setFont(new Font(null, Font.BOLD, 20));
			givePot();
			g.drawString("ÆÇµ· : "+pot+"¿ø", 105, 235);
			
		}
			
	}
	
	
	
	class Player2CardPanel extends PlayerNCardPanel{
		
		boolean P2turn = false;
		
		
		public Player2CardPanel(Card c1, Card c2) {
			// TODO Auto-generated constructor stub
			super(c1, c2);
			Toolkit tool = Toolkit.getDefaultToolkit();
			avatar=tool.getImage("images/avatar2.png");
			avatar = avatar.getScaledInstance(100, 140, Image.SCALE_SMOOTH);
			
			player2MoneyLeft = 1000000000;
			isFirstGameSet();
			
			player2MoneyLeft = player2MoneyLeft - gameManager.notifyBasicBet();
			gameManager.collectBasicBet();
		}	
		
		@Override
		protected void paintComponent(Graphics g) {
			
			g.drawRoundRect(30, 45, 300, 200, 25, 25);
			g.drawImage(avatar, 45, 85, this);	
			g.setFont(new Font(null, Font.BOLD, 20));
			g.drawString(player2MoneyLeft+"¿ø", 185, 230);
			
		}
		
	}
	
	class Player5CardPanel extends PlayerNCardPanel{
		
		boolean P5turn = false;

		
		public Player5CardPanel(Card c1, Card c2) {
			// TODO Auto-generated constructor stub
			super(c1, c2);
			
			Toolkit tool = Toolkit.getDefaultToolkit();
			avatar=tool.getImage("images/avatar5.png");
			avatar = avatar.getScaledInstance(100, 140, Image.SCALE_SMOOTH);
			
			player5MoneyLeft = 1000000000;
			isFirstGameSet();
			
			player5MoneyLeft = player5MoneyLeft - gameManager.notifyBasicBet();
			gameManager.collectBasicBet();
		}
		
		
		
		@Override
		protected void paintComponent(Graphics g) {		
			g.drawRoundRect(35, 45, 300, 200, 25, 25);
			g.drawImage(avatar, 50, 85, this);	
			g.setFont(new Font(null, Font.BOLD, 20));
			g.drawString(player5MoneyLeft+"¿ø", 185, 230);	
		}	
	}
		
}

