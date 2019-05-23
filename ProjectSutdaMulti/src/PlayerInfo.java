import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PlayerInfo extends JPanel{
	
	
	JTextArea textArea = new JTextArea(10,10);
	PlayerCardPanel playerCardPanel;
	Image cardImg1, cardImg2, avatar;
	Card playerCard1, playerCard2;
	ChattingPanel chattingPanel;
	JTextField tfMsg;
	JButton btnSend;
	PlayerBettingPanel playerBettingPanel;	
	
	MyJButton[] btns = new MyJButton[6];
	
	BettingButtonListener bettingButtonListener;
	
	int moneyLeft;

	GameManager gameManager;
	
	boolean myTurn;
	int isconnected =0;
	int count;
	
	public PlayerInfo(Card p1Card1, Card p1Card2, GameManager gm) {
		// TODO Auto-generated constructor stub
		playerCard1 = p1Card1;
		playerCard2 = p1Card2;
		gameManager = gm;
		
		
		
		setBackground(new Color(255, 0, 0,0));
		setLayout(new GridLayout(0, 3));
		playerCardPanel = new PlayerCardPanel();
		playerBettingPanel = new PlayerBettingPanel();
		chattingPanel = new ChattingPanel();
		add(chattingPanel);
		add(playerCardPanel);
		add(playerBettingPanel);
		
		
	}
	
	
	
	
	class PlayerBettingPanel extends JPanel{
		
		public PlayerBettingPanel() {
			// TODO Auto-generated constructor stub
			bettingButtonListener = new BettingButtonListener();
			setPreferredSize(new Dimension(250, 170));
			setSize(250, 170);
			setBackground(new Color(255, 0, 0,0));
			
			setLayout(null);
			
			
			btns[0] = new MyJButton("삥");btns[0].setLocation(50,33);
			btns[1] = new MyJButton("따당");btns[1].setLocation(140,33);
			btns[2] = new MyJButton("체크");btns[2].setLocation(230,33);
			btns[3] = new MyJButton("하프");btns[3].setLocation(50,115);
			btns[4] = new MyJButton("콜");btns[4].setLocation(140,115);
			btns[5] = new MyJButton("다이");btns[5].setLocation(230,115);
			
			for (int i=0;i<6;i++) {
				btns[i].setFont(new Font(null, Font.BOLD, 20));
				btns[i].setBackground(new Color(93,93,93,255));
				btns[i].setForeground(new Color(255,255,255,255));
				btns[i].setFocusPainted(false);
				btns[i].setSize(80,60);
				btns[i].addActionListener(bettingButtonListener);
				add(btns[i]);
			}
			
			
			
		}
		
		
		
		
		
		
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(new Color(0,0,0,130));
			g.drawRoundRect(30, 5, 300, 200, 25, 25);
			
			
		}
		
		
	}
	
	class BettingButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			
			
			
			
			
			
			
			if (e.getActionCommand() == "삥" && myTurn == true && isconnected == 0) {
				if (moneyLeft > gameManager.notifyBasicBet()) {
					moneyLeft = moneyLeft - gameManager.notifyBasicBet();
					gameManager.collectBasicBet();
	
					myTurn = false;
				}else if (moneyLeft < gameManager.notifyBasicBet()) {
					if (moneyLeft == 0) {
						myTurn = false;
						isconnected = -1;
					}else {
						btns[4].doClick();
					}
				}
			}
			
			if (e.getActionCommand() == "하프" && myTurn == true && isconnected == 0) {
				if (moneyLeft > gameManager.notifyHalf()) {
					moneyLeft = moneyLeft - gameManager.notifyHalf();
					gameManager.collectHalf();
					myTurn = false;
				}else if (moneyLeft < gameManager.notifyHalf()) { 
					btns[4].doClick();
				}
			}
			
			if (e.getActionCommand() == "체크" && myTurn == true && isconnected == 0) {
				myTurn = false;
			}
			
			if (e.getActionCommand() == "다이" && myTurn == true && isconnected == 0) {
					myTurn = false;
					isconnected = -1;
			}
			
			if (e.getActionCommand() == "따당" && myTurn == true && isconnected == 0) {
				if(gameManager.moneyCollection == 500000) {}
				else if (moneyLeft > gameManager.notifyDadang()) {
					moneyLeft = moneyLeft - gameManager.notifyDadang();
					gameManager.collectDadang();
					myTurn = false;
				}else if (moneyLeft < gameManager.notifyDadang()) {
					btns[4].doClick();
				}
			}
			
			if (e.getActionCommand() == "콜" && myTurn == true && isconnected == 0) {
				if(gameManager.moneyCollection == 500000) {}
				else if (moneyLeft > gameManager.notifyCall()) {
					moneyLeft = moneyLeft - gameManager.notifyCall();
					gameManager.collectCall();
					myTurn = false;
				}else if(moneyLeft < gameManager.notifyCall()) {
					moneyLeft = 0;
					gameManager.collectCall(moneyLeft);
					myTurn = false;
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
	}
	
	
	
	
	class PlayerCardPanel extends JPanel{
		
		int width,height;
		
		Jokbo jokbo;
		
	
		int x,y;
		
		
		public PlayerCardPanel() {
			// TODO Auto-generated constructor stub
			setLayout(new BorderLayout());
			
			Toolkit tool = Toolkit.getDefaultToolkit();
			avatar=tool.getImage("images/avatar.png");
			avatar = avatar.getScaledInstance(100, 140, Image.SCALE_SMOOTH);
			
			moneyLeft = 1000000000;
			
			isFirstGameStarted();
			
			moneyLeft = moneyLeft - gameManager.notifyBasicBet();
			gameManager.collectBasicBet();

		}
		
		
			
		
		
		void isFirstGameStarted() {
			
			if (playerCard1.num > playerCard2.num) {
				Card temp;
				
				temp = playerCard1;
				playerCard1 = playerCard2;
				playerCard2 = temp;
			}
			
			jokbo = new Jokbo(playerCard1, playerCard2);
			
			cardImg1 = playerCard1.getCardImg();
			cardImg2 = playerCard2.getCardImg();
			cardImg1 = cardImg1.getScaledInstance(60, 120, Image.SCALE_SMOOTH);
			cardImg2 = cardImg2.getScaledInstance(60, 120, Image.SCALE_SMOOTH);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
		
			g.drawRoundRect(30, 5, 300, 200, 25, 25);
			g.drawImage(avatar, 40, 40, this);
			g.setFont(new Font(null, Font.BOLD, 20));
			g.drawString(moneyLeft+"원", 180, 190);
			
			
		}	
	}
	
	
	class ChattingPanel extends JPanel{
		public ChattingPanel() {
			// TODO Auto-generated constructor stub
			
			setLayout(new BorderLayout());
			setBackground(new Color(255, 0, 0,0));

			textArea.setEditable(false);
			
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setBorder(BorderFactory.createBevelBorder(1));
			add(scrollPane, BorderLayout.CENTER);
			

			JPanel msgpanel = new JPanel();
			msgpanel.setLayout(new BorderLayout());
			tfMsg = new JTextField();
			tfMsg.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyReleased(KeyEvent k) {
			
				}
				
				@Override
				public void keyPressed(KeyEvent k) {
					if(k.getKeyCode() == 10) {
						btnSend.doClick();
					}
				}
			});
			
			
			msgpanel.add(tfMsg,BorderLayout.CENTER);
			btnSend = new JButton("SEND");
			msgpanel.add(btnSend,BorderLayout.EAST);
			add(msgpanel, BorderLayout.SOUTH);
			btnSend.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					sendMsg();
				}
			});	
		}
		
		void sendMsg() {
			String msg = tfMsg.getText();
			tfMsg.setText("");
			//내 메세지창에 글 추가
			textArea.append("Player1 : "+msg+"\n");
			textArea.setCaretPosition(textArea.getText().length());
		}
	}
}
