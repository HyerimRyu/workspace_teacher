import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

public class SinglePlay extends JPanel {
	Image imgBack;
	int width, height;
	PlayerInfo playerSide;
	CenterPlayers_MoneyPanel centerPlayers;
	NorthernPlayers northernPlayers;
	CardDistribute cardDistribute1;CardDistribute cardDistribute2;CardDistribute cardDistribute3;CardDistribute cardDistribute4;CardDistribute cardDistribute5;
	CardDistribute cardDistribute6;CardDistribute cardDistribute7;CardDistribute cardDistribute8;CardDistribute cardDistribute9;CardDistribute cardDistribute10;
	Image cardBack;Image manWon;	
	Card p1card;Card p2card;Card p3card;Card p4card;Card p5card;
	Card p1card2;Card p2card2;Card p3card2;Card p4card2;Card p5card2;
	CardDeck wholeCardDeck = new CardDeck();
	
	GameManager gameManager = new GameManager();
	int paintTurn = 0;
	
	Jokbo[] playersJokbo;
	
	RepaintThread repaintThread;
	GameThread gameThread;
	int count = 0;
	int threadCount = 0; 
	
	
	public SinglePlay() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		imgBack = toolkit.getImage("images/vintage-boards-1557993_1920.jpg");
		cardBack = toolkit.getImage("cardImages/CardImageBack.png");
		manWon = toolkit.getImage("moneyImages/10000won.png");
		
		setLayout(new BorderLayout());
		setBackground(new Color(255, 0, 0,255));
		
		
		wholeCardDeck.shuffle();
		
		p1card = wholeCardDeck.getOne();p1card2 = wholeCardDeck.getOne();
		if (p1card.num > p1card2.num) {
			Card temp;
			temp = p1card;
			p1card = p1card2;
			p1card2 = temp;
		}
		p2card = wholeCardDeck.getOne();p2card2 = wholeCardDeck.getOne();
		if (p2card.num > p2card2.num) {
			Card temp;	
			temp = p2card;
			p2card = p2card2;
			p2card2 = temp;
		}
		p3card = wholeCardDeck.getOne();p3card2 = wholeCardDeck.getOne();
		if (p3card.num > p3card2.num) {
			Card temp;	
			temp = p3card;
			p3card = p3card2;
			p3card2 = temp;
		}
		p4card = wholeCardDeck.getOne();p4card2 = wholeCardDeck.getOne();
		if (p4card.num > p4card2.num) {
			Card temp;	
			temp = p4card;
			p4card = p4card2;
			p4card2 = temp;
		}
		p5card = wholeCardDeck.getOne();p5card2 = wholeCardDeck.getOne();
		if (p5card.num > p5card2.num) {
			Card temp;
			temp = p5card;
			p5card = p5card2;
			p5card2 = temp;
		}
		
		playerSide = new PlayerInfo(p1card, p1card2, gameManager);
		northernPlayers = new NorthernPlayers(p3card, p3card2, p4card, p4card2, gameManager);
		centerPlayers = new CenterPlayers_MoneyPanel(p2card, p2card2, p5card, p5card2, gameManager);
		
		
		add(northernPlayers, "North");
		add(centerPlayers, "Center");
		add(playerSide, "South");


		
		cardDistribute1 = new CardDistribute(1,true);cardDistribute2 = new CardDistribute(2,true);cardDistribute3 = new CardDistribute(3,true);cardDistribute4 = new CardDistribute(4,true);cardDistribute5 = new CardDistribute(5,true);
		cardDistribute6 = new CardDistribute(1,false);cardDistribute7 = new CardDistribute(2,false);cardDistribute8 = new CardDistribute(3,false);cardDistribute9 = new CardDistribute(4,false);cardDistribute10 = new CardDistribute(5,false);
		playersJokbo = new Jokbo[5];
		
		repaintThread = new RepaintThread();
		repaintThread.start();
		gameThread = new GameThread();
		gameThread.start();
	}
	
	
	
	
	
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		
		if (width == 0 || height ==0) {
			 
			
			width = getWidth();
			height = getHeight();
			
			imgBack=imgBack.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
			cardBack = cardBack.getScaledInstance(60, 120, Image.SCALE_SMOOTH);
			manWon = manWon.getScaledInstance(60, 30, Image.SCALE_SMOOTH);
			
			g.drawImage(imgBack, 0, 0, this);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			g.drawImage(imgBack, 0, 0, this);
		
			if (cardDistribute10.getX() == 244 || cardDistribute5.getX() == 148) {
				g.drawImage(manWon, getWidth()/2-30, getHeight()/2-15, this);
				
			}else if (count==1) {
				g.drawImage(cardBack, 500, 300, this);
			}
			
			
			if (cardDistribute1.getPlayerNum() == 1 && cardDistribute1.getCardNum() == true) {
				
				if (cardDistribute1.getX()<523 && cardDistribute1.getY()<530) {
					cardDistribute1.startCardDistribution();
					g.drawImage(cardBack, cardDistribute1.getX(), cardDistribute1.getY(), this);
				}else {
					g.drawImage(playerSide.cardImg1, 525, 550, this);
				}
			}
			
			if (cardDistribute1.getX()==524 && cardDistribute2.getPlayerNum()==2 && cardDistribute2.getCardNum() == true) {
				
				if (cardDistribute2.getX()<885 && cardDistribute2.getY() < 301) {
					cardDistribute2.startCardDistribution();
					g.drawImage(cardBack, cardDistribute2.getX(), cardDistribute2.getY(), this);
				}else {
					g.drawImage(cardBack, 885, 300, this);
					//System.out.println(cardDistribute2.getX()); //x=900;
				}
			}
			
			if (cardDistribute2.getX() == 890 && cardDistribute3.getPlayerNum()==3 && cardDistribute3.getCardNum() == true) {
				if (cardDistribute3.getX()<735 && cardDistribute3.getY()>44) {
					cardDistribute3.startCardDistribution();
					g.drawImage(cardBack, cardDistribute3.getX(), cardDistribute3.getY(), this);
				}else {
					g.drawImage(cardBack, 735, 44, this);
					//System.out.println(cardDistribute3.getX()); //x=724
				}
			}
			
			if (cardDistribute3.getX()==724 && cardDistribute4.getPlayerNum()==4 && cardDistribute4.getCardNum()==true) {
				if (cardDistribute4.getX()>323 && cardDistribute4.getY()>44) {
					cardDistribute4.startCardDistribution();
					g.drawImage(cardBack, cardDistribute4.getX(), cardDistribute4.getY(), this);
				}else {
					g.drawImage(cardBack, 323, 44, this);
//					System.out.println(cardDistribute4.getX()); // x = 313
				}
			}
			
			if (cardDistribute4.getX()==313 && cardDistribute5.getPlayerNum()==5&&cardDistribute5.getCardNum()==true) {
				if (cardDistribute5.getX()>176 && cardDistribute5.getY()==300) {
					cardDistribute5.startCardDistribution();
					g.drawImage(cardBack, cardDistribute5.getX(), cardDistribute5.getY(), this);
				}else {
					g.drawImage(cardBack, 176, 300, this);
					//System.out.println(cardDistribute5.getX()); //x = 148
				}
				
			}		
		
		
		
		if (count>5) {
			if ( cardDistribute5.getX()==148&& cardDistribute6.getPlayerNum()==1 && cardDistribute6.getCardNum() == false) {
				if (cardDistribute6.getX()<595 && cardDistribute6.getY()<550) {
					cardDistribute6.startCardDistribution();
					g.drawImage(cardBack, cardDistribute6.getX(), cardDistribute6.getY(), this);
					
				}else {
					g.setFont(new Font(null, Font.BOLD, 20));
					
					g.drawString(playersJokbo[0].jokboToString(), 551, 540);

					
					g.drawImage(playerSide.cardImg2, 595, 550, this);
					//System.out.println(cardDistribute6.getX()); //x=539
				}
			}
				
			if ( cardDistribute6.getX()==539&& cardDistribute7.getPlayerNum()==2 && cardDistribute7.getCardNum() == false) {
				if (cardDistribute7.getX()<955 && cardDistribute7.getY()<301) {
					cardDistribute7.startCardDistribution();
					g.drawImage(cardBack, cardDistribute7.getX(), cardDistribute7.getY(), this);
					
				}else {
					g.drawImage(cardBack, 955, 300, this);
					//System.out.println(cardDistribute7.getX()); //x=980
				}
			}
			
			if (cardDistribute7.getX()==980&& cardDistribute8.getPlayerNum()==3 && cardDistribute8.getCardNum() == false) {
				if (cardDistribute8.getX()<805 && cardDistribute8.getY()>44) {
					cardDistribute8.startCardDistribution();
					g.drawImage(cardBack, cardDistribute8.getX(), cardDistribute8.getY(), this);
					
				}else {
					g.drawImage(cardBack, 805, 44, this);
					//System.out.println(cardDistribute8.getX()); //x=800
				}
			}
			
			if (cardDistribute8.getX()==800 && cardDistribute9.getPlayerNum()==4 && cardDistribute9.getCardNum() == false) {
				if (cardDistribute9.getX()>393 && cardDistribute9.getY()>44) {
					cardDistribute9.startCardDistribution();
					g.drawImage(cardBack, cardDistribute9.getX(), cardDistribute9.getY(), this);
				
				}else {
					g.drawImage(cardBack, 393, 44, this);
					//System.out.println(cardDistribute9.getX()); //x = 381
				}
			}
			
			if (cardDistribute9.getX()==381&& cardDistribute10.getPlayerNum()==5 && cardDistribute10.getCardNum() == false) {
				if (cardDistribute10.getX()>246 && cardDistribute10.getY()<301) {
					cardDistribute10.startCardDistribution();
					g.drawImage(cardBack, cardDistribute10.getX(), cardDistribute10.getY(), this);
					
				}else {
					g.drawImage(cardBack, 246, 300, this);
					//System.out.println(cardDistribute10.getX()); //x=244
					//System.out.println(count);
				}
			}
			
		}
		
		if (count == 10) {
			g.drawImage(centerPlayers.player2CardPanel.cardImg1, 885, 300, this);
			g.drawImage(centerPlayers.player2CardPanel.cardImg2, 955, 300, this);
			g.drawString(playersJokbo[1].jokboToString(), 911, 290);

			
			
			g.drawImage(northernPlayers.player3CardPanel.cardImg1, 735, 44, this);
			g.drawImage(northernPlayers.player3CardPanel.cardImg2, 805, 44, this);
			g.drawString(playersJokbo[2].jokboToString(), 761, 34);


			

			
			g.drawImage(northernPlayers.player4CardPanel.cardImg1, 323, 44, this);
			g.drawImage(northernPlayers.player4CardPanel.cardImg2, 393, 44, this);
			g.drawString(playersJokbo[3].jokboToString(), 349, 34);


			g.drawImage(centerPlayers.player5CardPanel.cardImg1, 176, 300, this);
			g.drawImage(centerPlayers.player5CardPanel.cardImg2, 246, 300, this);
			g.drawString(playersJokbo[4].jokboToString(), 202, 290);


		}
		
		
		
		

		
		
		
		
		
		
		
		
		
		
	}
	
	
	class CardDistribute{
	
		int playerNum;
		int variationX,variationY;	
		boolean cardNum;
		
		int x=500, y=300;
		
	
		public CardDistribute(int playerNum, boolean cardNum) {
			this.playerNum = playerNum;
			this.cardNum = cardNum;
			
			decideTurn();
		}
		
		void decideTurn() {
			if (playerNum == 1 && cardNum == true) {
				variationX = 2;
				variationY = 20;
			}else if (playerNum == 2 && cardNum == true) {
				variationX = 30;
				variationY = 0;
			}else if (playerNum == 3 && cardNum == true) {
				variationX = 28;
				variationY = -32;
			}else if (playerNum == 4 && cardNum == true) {
				variationX = -17;
				variationY = -25;
			}else if (playerNum == 5 && cardNum == true) {
				variationX = -32;
				variationY = 0;
				
			}else if (playerNum == 1 && cardNum == false) {
				variationX = 3;
				variationY = 20;
			}else if (playerNum == 2 && cardNum == false) {
				variationX = 30;
				variationY = 0;
			}else if (playerNum == 3 && cardNum == false) {
				variationX = 30;
				variationY = -26;
			}else if (playerNum == 4 && cardNum == false) {
				variationX = -17;
				variationY = -25;
			}else if (playerNum == 5 && cardNum == false) {
				variationX = -32;
				variationY = 0;
			}
		}
		
		
		public void startCardDistribution() {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				x += variationX;
				y += variationY;
					
				repaint();			
		
		}
		public void setPlayerNum(int playerNum) {
			this.playerNum = playerNum;
		}
		public void setCardNum(boolean cardNum) {
			this.cardNum = cardNum;
		}
		public int getPlayerNum() {
			return playerNum;
		}
		public boolean getCardNum() {
			return cardNum;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		
		public void resetAll(){
			x=500; 
			y=300;
		}
	}
	
	
	class RepaintThread extends Thread{

		
		public void run() {
			while(true) {
				
				repaint();
				
			}	
		}	
	}
	
	class GameThread extends Thread{
		
		@Override
		public void run() {
			
			while (true) {
				
				if (count < 5) {
					
				
				if (count == 0) {
					if (playerSide.isconnected == -1) {
						playerSide.myTurn = false;		
						count= 1;
					}else if (playerSide.isconnected == 0){
						playerSide.myTurn= true;
						count =1;
					}	
				}
				
				
				
				if (count == 1 && playerSide.myTurn == false) {
					centerPlayers.player2CardPanel.P2turn = true;
					if (centerPlayers.player2isConnected == 0) {
						
						if (centerPlayers.aiBettingplayer2.firstBet() == 1) {
							if (centerPlayers.player2MoneyLeft > gameManager.notifyHalf()) {
								centerPlayers.player2MoneyLeft = centerPlayers.player2MoneyLeft - gameManager.notifyHalf();
								gameManager.collectHalf();
								centerPlayers.player2CardPanel.P2turn = false;
								
							}else if(centerPlayers.player2MoneyLeft < gameManager.notifyHalf()) {
								gameManager.collectAllin(centerPlayers.player2MoneyLeft);
								centerPlayers.player2MoneyLeft = 0;
								centerPlayers.player2CardPanel.P2turn = false;
							}
						}else {
							if (centerPlayers.player2MoneyLeft > gameManager.notifyBasicBet()) {
								centerPlayers.player2MoneyLeft = centerPlayers.player2MoneyLeft - gameManager.notifyBasicBet();
								gameManager.collectBasicBet();
								centerPlayers.player2CardPanel.P2turn = false;
							}else if(centerPlayers.player2MoneyLeft < gameManager.notifyBasicBet()){
								gameManager.collectAllin(centerPlayers.player2MoneyLeft);
								centerPlayers.player2MoneyLeft = 0;
								centerPlayers.player2CardPanel.P2turn = false;
							}
						}
						
							count=2;
						
						
					}
					
				}
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (count ==2 && centerPlayers.player2CardPanel.P2turn == false) {
					northernPlayers.player3CardPanel.P3turn = true;
					if (northernPlayers.player3isConnected == 0) {
						
						if (northernPlayers.aiBettingplayer3.firstBet() == 1) {
							if (northernPlayers.player3MoneyLeft > gameManager.notifyHalf()) {
								northernPlayers.player3MoneyLeft = northernPlayers.player3MoneyLeft - gameManager.notifyHalf();
								gameManager.collectHalf();
								northernPlayers.player3CardPanel.P3turn = false;
								
							}else if(northernPlayers.player3MoneyLeft < gameManager.notifyHalf()) {
								gameManager.collectAllin(northernPlayers.player3MoneyLeft);
								northernPlayers.player3MoneyLeft = 0;
								northernPlayers.player3CardPanel.P3turn = false;
							}
						}else {
							if (northernPlayers.player3MoneyLeft > gameManager.notifyBasicBet()) {
								northernPlayers.player3MoneyLeft = northernPlayers.player3MoneyLeft - gameManager.notifyBasicBet();
								gameManager.collectBasicBet();
								northernPlayers.player3CardPanel.P3turn = false;
							}else if(northernPlayers.player3MoneyLeft < gameManager.notifyBasicBet()){
								gameManager.collectAllin(northernPlayers.player3MoneyLeft);
								northernPlayers.player3MoneyLeft = 0;
								northernPlayers.player3CardPanel.P3turn = false;
							}
							
						}
						
						
						
						count=3;
					}
				}
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (count ==3 && northernPlayers.player3CardPanel.P3turn == false) {
					northernPlayers.player4CardPanel.P4turn = true;
					if (northernPlayers.player4isConnected == 0) {
						
						if (northernPlayers.aiBettingplayer4.firstBet() == 1) {
							
							if (northernPlayers.player4MoneyLeft > gameManager.notifyHalf()) {
								northernPlayers.player4MoneyLeft = northernPlayers.player4MoneyLeft - gameManager.notifyHalf();
								gameManager.collectHalf();
								northernPlayers.player4CardPanel.P4turn = false;
								
							}else if(northernPlayers.player4MoneyLeft < gameManager.notifyHalf()) {
								gameManager.collectAllin(northernPlayers.player4MoneyLeft);
								northernPlayers.player4MoneyLeft = 0;
								northernPlayers.player4CardPanel.P4turn = false;
							}
						
						}else {
							if (northernPlayers.player4MoneyLeft > gameManager.notifyBasicBet()) {
								northernPlayers.player4MoneyLeft = northernPlayers.player4MoneyLeft - gameManager.notifyBasicBet();
								gameManager.collectBasicBet();
								northernPlayers.player4CardPanel.P4turn = false;
							}else if(northernPlayers.player4MoneyLeft < gameManager.notifyBasicBet()){
								gameManager.collectAllin(northernPlayers.player4MoneyLeft);
								northernPlayers.player4MoneyLeft = 0;
								northernPlayers.player4CardPanel.P4turn = false;
							}
						}
						
						
						
						count=4;
					}
				}
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (count ==4 && northernPlayers.player4CardPanel.P4turn == false) {
					centerPlayers.player5CardPanel.P5turn = true;
					if (centerPlayers.player5isConnected == 0) {
						
						if (centerPlayers.aiBettingplayer5.firstBet() == 1) {
							if (centerPlayers.player5MoneyLeft > gameManager.notifyHalf()) {
								centerPlayers.player5MoneyLeft = centerPlayers.player5MoneyLeft - gameManager.notifyHalf();
								gameManager.collectHalf();
								centerPlayers.player5CardPanel.P5turn = false;
								
							}else if(centerPlayers.player5MoneyLeft < gameManager.notifyHalf()) {
								gameManager.collectAllin(centerPlayers.player5MoneyLeft);
								centerPlayers.player5MoneyLeft = 0;
								centerPlayers.player5CardPanel.P5turn = false;
							}
							
						}else {
							if (centerPlayers.player5MoneyLeft > gameManager.notifyBasicBet()) {
								centerPlayers.player5MoneyLeft = centerPlayers.player5MoneyLeft - gameManager.notifyBasicBet();
								gameManager.collectBasicBet();
								centerPlayers.player5CardPanel.P5turn = false;
							}else if(centerPlayers.player5MoneyLeft < gameManager.notifyBasicBet()){
								gameManager.collectAllin(centerPlayers.player5MoneyLeft);
								centerPlayers.player5MoneyLeft = 0;
								centerPlayers.player5CardPanel.P5turn = false;
							}
						}
						count=5;
					}
				}
				}
				
				
				
				else if (4<count && count <10){
					
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (count == 5) {
					if (playerSide.isconnected == -1) {
						playerSide.myTurn = false;
						playersJokbo[0] = new Jokbo(p1card, p1card2);
						count= 6;
					}else if (playerSide.isconnected == 0){
						playerSide.myTurn= true;
						playersJokbo[0] = new Jokbo(p1card, p1card2);
						count =6;
					}	
					
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (count == 6 && playerSide.myTurn == false) {
					centerPlayers.player2CardPanel.P2turn = true;
					if (centerPlayers.player2isConnected == 0) {
						
						if (centerPlayers.aiBettingplayer2.SecondBet() == 1) {
							
							if (centerPlayers.player2MoneyLeft > gameManager.notifyHalf()) {
									centerPlayers.player2MoneyLeft = centerPlayers.player2MoneyLeft - gameManager.notifyHalf();
									gameManager.collectHalf();
									centerPlayers.player2CardPanel.P2turn = false;
									
							}else if(centerPlayers.player2MoneyLeft < gameManager.notifyHalf()) {
								gameManager.collectAllin(centerPlayers.player2MoneyLeft);
								centerPlayers.player2MoneyLeft = 0;
								centerPlayers.player2CardPanel.P2turn = false;
							}
						}else if(centerPlayers.aiBettingplayer2.SecondBet() == 2) {
							if (centerPlayers.player2MoneyLeft > gameManager.notifyHalf()) {
								centerPlayers.player2MoneyLeft = centerPlayers.player2MoneyLeft - gameManager.notifyHalf();
								gameManager.collectHalf();
								centerPlayers.player2CardPanel.P2turn = false;
							}else if(centerPlayers.player2MoneyLeft < gameManager.notifyHalf()) {
								gameManager.collectAllin(centerPlayers.player2MoneyLeft);
								centerPlayers.player2MoneyLeft = 0;
								centerPlayers.player2CardPanel.P2turn = false;
							}
						}
						playersJokbo[1] = new Jokbo(p2card, p2card2);
							count=7;
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (count ==7 && centerPlayers.player2CardPanel.P2turn == false) {
					northernPlayers.player3CardPanel.P3turn = true;
					if (northernPlayers.player3isConnected == 0) {
						
						if (northernPlayers.aiBettingplayer3.SecondBet() == 1) {
							if (northernPlayers.player3MoneyLeft > gameManager.notifyHalf()) {
								northernPlayers.player3MoneyLeft = northernPlayers.player3MoneyLeft - gameManager.notifyHalf();
									gameManager.collectHalf();
									northernPlayers.player3CardPanel.P3turn = false;
							}else if(northernPlayers.player3MoneyLeft < gameManager.notifyHalf()) {
								gameManager.collectAllin(northernPlayers.player3MoneyLeft);
								northernPlayers.player3MoneyLeft = 0;
								northernPlayers.player3CardPanel.P3turn = false;
							}
						}else if (northernPlayers.aiBettingplayer3.SecondBet() == 2) {
							if (northernPlayers.player3MoneyLeft > gameManager.notifyHalf()) {
								northernPlayers.player3MoneyLeft = northernPlayers.player3MoneyLeft - gameManager.notifyHalf();
									gameManager.collectHalf();
									northernPlayers.player3CardPanel.P3turn = false;
							}else if(northernPlayers.player3MoneyLeft < gameManager.notifyHalf()) {
								gameManager.collectAllin(northernPlayers.player3MoneyLeft);
								northernPlayers.player3MoneyLeft = 0;
								northernPlayers.player3CardPanel.P3turn = false;
							}
						}
						
						
						playersJokbo[2] = new Jokbo(p3card, p3card2);
						count=8;
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (count ==8 && northernPlayers.player3CardPanel.P3turn == false) {
					northernPlayers.player4CardPanel.P4turn = true;
					if (northernPlayers.player4isConnected == 0) {
						
						if (northernPlayers.aiBettingplayer4.SecondBet() == 1) {
							if (northernPlayers.player4MoneyLeft > gameManager.notifyHalf()) {
								northernPlayers.player4MoneyLeft = northernPlayers.player4MoneyLeft - gameManager.notifyHalf();
									gameManager.collectHalf();
									northernPlayers.player4CardPanel.P4turn = false;
							}else if(northernPlayers.player4MoneyLeft < gameManager.notifyHalf()) {
								gameManager.collectAllin(northernPlayers.player4MoneyLeft);
								northernPlayers.player4MoneyLeft = 0;
								northernPlayers.player4CardPanel.P4turn = false;
							}
						}else if(northernPlayers.aiBettingplayer4.SecondBet() == 2) {
							if (northernPlayers.player4MoneyLeft > gameManager.notifyHalf()) {
								northernPlayers.player4MoneyLeft = northernPlayers.player4MoneyLeft - gameManager.notifyHalf();
									gameManager.collectHalf();
									northernPlayers.player4CardPanel.P4turn = false;
							}else if(northernPlayers.player4MoneyLeft < gameManager.notifyHalf()) {
								gameManager.collectAllin(northernPlayers.player4MoneyLeft);
								northernPlayers.player4MoneyLeft = 0;
								northernPlayers.player4CardPanel.P4turn = false;
							}
						}
						
						
						
						playersJokbo[3] = new Jokbo(p4card, p4card2);
						count=9;
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (count ==9 && northernPlayers.player4CardPanel.P4turn == false) {
					centerPlayers.player5CardPanel.P5turn = true;
					
					if (centerPlayers.player5isConnected == 0) {
						
						if (centerPlayers.aiBettingplayer5.SecondBet() == 1) {
							
							if (centerPlayers.player5MoneyLeft > gameManager.notifyHalf()) {
									centerPlayers.player5MoneyLeft = centerPlayers.player5MoneyLeft - gameManager.notifyHalf();
									gameManager.collectHalf();
									centerPlayers.player5CardPanel.P5turn = false;
									
							}else if(centerPlayers.player5MoneyLeft < gameManager.notifyHalf()) {
								gameManager.collectAllin(centerPlayers.player5MoneyLeft);
								centerPlayers.player5MoneyLeft = 0;
								centerPlayers.player5CardPanel.P5turn = false;
							}
						}else if(centerPlayers.aiBettingplayer5.SecondBet() == 2) {
							if (centerPlayers.player5MoneyLeft > gameManager.notifyHalf()) {
								centerPlayers.player5MoneyLeft = centerPlayers.player5MoneyLeft - gameManager.notifyHalf();
								gameManager.collectHalf();
								centerPlayers.player5CardPanel.P5turn = false;	
							}else if(centerPlayers.player5MoneyLeft < gameManager.notifyHalf()) {
								gameManager.collectAllin(centerPlayers.player5MoneyLeft);
								centerPlayers.player5MoneyLeft = 0;
								centerPlayers.player5CardPanel.P5turn = false;
							}
							
						}
						
						playersJokbo[4] = new Jokbo(p5card, p5card2);
						count=10;
					}
				}
				
				}
				
				
				if (count == 10 ) {
					
					int[] playerNumList = new int[5];
					
					playerNumList[0] = playersJokbo[0].whoistheWinner();
					playerNumList[1] = playersJokbo[1].whoistheWinner();
					playerNumList[2] = playersJokbo[2].whoistheWinner();
					playerNumList[3] = playersJokbo[3].whoistheWinner();
					playerNumList[4] = playersJokbo[4].whoistheWinner();
					int max = 0;
					int restart49 = 0;
					int restartPowered49 = 0;
					int whetherisTieBreak=0;
					
				
					
					for (int i=0;i<5;i++) {
						
						
						if (playerNumList[max]<playerNumList[i]) {
							max = i;
						}
						
						if (playerNumList[i]==-10) {
							restart49 = playerNumList[i];
						}
						
						if (playerNumList[i] == -20) {
							restartPowered49 = playerNumList[i];
						}
						
						for (int k=0;k<i;k++) {
							if (playerNumList[i] == playerNumList[k]) {
								whetherisTieBreak++;
							}
						}
							
					}
					
					
					
					
					
					try {
						Thread.sleep(3500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					if(restart49  == -10) {
						for (int a=0;a<5;a++) {
							if (playerNumList[a]<=1870) {
								cardDistribute1.resetAll();cardDistribute2.resetAll();cardDistribute3.resetAll();cardDistribute4.resetAll();cardDistribute5.resetAll();
								cardDistribute6.resetAll();cardDistribute7.resetAll();cardDistribute8.resetAll();cardDistribute9.resetAll();cardDistribute10.resetAll();
								
								wholeCardDeck.resetCardDeck();
								
								wholeCardDeck.shuffle();
								
								
								
								p1card = wholeCardDeck.getOne();p1card2 = wholeCardDeck.getOne();
								if (p1card.num > p1card2.num) {
									Card temp;
									temp = p1card;
									p1card = p1card2;
									p1card2 = temp;
								}
								playerSide.playerCard1 = p1card; playerSide.playerCard2 = p1card2;
								playerSide.playerCardPanel.isFirstGameStarted();
								
								p2card = wholeCardDeck.getOne();p2card2 = wholeCardDeck.getOne();
								if (p2card.num > p2card2.num) {
									Card temp;	
									temp = p2card;
									p2card = p2card2;
									p2card2 = temp;
								}
								centerPlayers.player2Card1 = p2card; centerPlayers.player2CardPanel.playerCard1 = p2card; 
								centerPlayers.player2Card2 = p2card2; centerPlayers.player2CardPanel.playerCard2 = p2card2;
								centerPlayers.player2CardPanel.isFirstGameSet();
								
								p3card = wholeCardDeck.getOne();p3card2 = wholeCardDeck.getOne();
								if (p3card.num > p3card2.num) {
									Card temp;	
									temp = p3card;
									p3card = p3card2;
									p3card2 = temp;
								}
								northernPlayers.player3Card1 = p3card;northernPlayers.player3CardPanel.playerCard1 = p3card;
//								System.out.println("cardImages/"+p3card.a+".PNG"+"  , isMoreThan10 :   "+p3card.isMoreThan10);
								northernPlayers.player3Card2 = p3card2;northernPlayers.player3CardPanel.playerCard2 = p3card2;
//								System.out.println("cardImages/"+p3card2.a+".PNG"+"  , isMoreThan10 :   "+p3card2.isMoreThan10);
								northernPlayers.player3CardPanel.isFirstGameSet();
								
								p4card = wholeCardDeck.getOne();p4card2 = wholeCardDeck.getOne();
								if (p4card.num > p4card2.num) {
									Card temp;	
									temp = p4card;
									p4card = p4card2;
									p4card2 = temp;
								}
								northernPlayers.player4Card1 = p4card;northernPlayers.player4CardPanel.playerCard1 = p4card; 
								northernPlayers.player4Card2 = p4card2;northernPlayers.player4CardPanel.playerCard2 = p4card2;
								northernPlayers.player4CardPanel.isFirstGameSet();
								
								p5card = wholeCardDeck.getOne();p5card2 = wholeCardDeck.getOne();
								if (p5card.num > p5card2.num) {
									Card temp;
									temp = p5card;
									p5card = p5card2;
									p5card2 = temp;
								}
								centerPlayers.player5Card1 = p5card;centerPlayers.player5CardPanel.playerCard1 = p5card; 
								centerPlayers.player5Card2 = p5card2; centerPlayers.player5CardPanel.playerCard2 = p5card2;
								centerPlayers.player5CardPanel.isFirstGameSet();
								if (playerSide.isconnected ==-1) playerSide.isconnected = 0;

								count = 0;

							}
						}
						continue;
					}
					
					if (restartPowered49 == -20 ) {
						for (int b=0;b<5;b++) {
							if (playerNumList[b]<=1960) {
								cardDistribute1.resetAll();cardDistribute2.resetAll();cardDistribute3.resetAll();cardDistribute4.resetAll();cardDistribute5.resetAll();
								cardDistribute6.resetAll();cardDistribute7.resetAll();cardDistribute8.resetAll();cardDistribute9.resetAll();cardDistribute10.resetAll();
								
								wholeCardDeck.resetCardDeck();
								
								wholeCardDeck.shuffle();
								
								
								
								p1card = wholeCardDeck.getOne();p1card2 = wholeCardDeck.getOne();
								if (p1card.num > p1card2.num) {
									Card temp;
									temp = p1card;
									p1card = p1card2;
									p1card2 = temp;
								}
								playerSide.playerCard1 = p1card; playerSide.playerCard2 = p1card2;
								playerSide.playerCardPanel.isFirstGameStarted();
								
								p2card = wholeCardDeck.getOne();p2card2 = wholeCardDeck.getOne();
								if (p2card.num > p2card2.num) {
									Card temp;	
									temp = p2card;
									p2card = p2card2;
									p2card2 = temp;
								}
								centerPlayers.player2Card1 = p2card; centerPlayers.player2CardPanel.playerCard1 = p2card; 
								centerPlayers.player2Card2 = p2card2; centerPlayers.player2CardPanel.playerCard2 = p2card2;
								centerPlayers.player2CardPanel.isFirstGameSet();
								
								p3card = wholeCardDeck.getOne();p3card2 = wholeCardDeck.getOne();
								if (p3card.num > p3card2.num) {
									Card temp;	
									temp = p3card;
									p3card = p3card2;
									p3card2 = temp;
								}
								northernPlayers.player3Card1 = p3card;northernPlayers.player3CardPanel.playerCard1 = p3card;
								northernPlayers.player3Card2 = p3card2;northernPlayers.player3CardPanel.playerCard2 = p3card2;
								northernPlayers.player3CardPanel.isFirstGameSet();
								
								p4card = wholeCardDeck.getOne();p4card2 = wholeCardDeck.getOne();
								if (p4card.num > p4card2.num) {
									Card temp;	
									temp = p4card;
									p4card = p4card2;
									p4card2 = temp;
								}
								northernPlayers.player4Card1 = p4card;northernPlayers.player4CardPanel.playerCard1 = p4card; 
								northernPlayers.player4Card2 = p4card2;northernPlayers.player4CardPanel.playerCard2 = p4card2;
								northernPlayers.player4CardPanel.isFirstGameSet();
								
								p5card = wholeCardDeck.getOne();p5card2 = wholeCardDeck.getOne();
								if (p5card.num > p5card2.num) {
									Card temp;
									temp = p5card;
									p5card = p5card2;
									p5card2 = temp;
								}
								centerPlayers.player5Card1 = p5card;centerPlayers.player5CardPanel.playerCard1 = p5card; 
								centerPlayers.player5Card2 = p5card2; centerPlayers.player5CardPanel.playerCard2 = p5card2;
								centerPlayers.player5CardPanel.isFirstGameSet();
								if (playerSide.isconnected ==-1) playerSide.isconnected = 0;

								count = 0;

							}
						}
						continue;
						
					}
					
					
				
					
					
							
					if (max == 0) {
						
						playerSide.moneyLeft += gameManager.getMoneyCollection();
					}else if (max == 1) {
						centerPlayers.player2MoneyLeft += gameManager.getMoneyCollection();
					}else if (max == 2) {
						northernPlayers.player3MoneyLeft += gameManager.getMoneyCollection();
					}else if (max == 3) {
						northernPlayers.player4MoneyLeft += gameManager.getMoneyCollection();
					}else if (max == 4) {
						centerPlayers.player5MoneyLeft += gameManager.getMoneyCollection();
					}
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					gameManager.resetGameManager();
					
//					System.out.println("49여부 : "+restart);
//					System.out.println("몇번방 : "+max);
//					System.out.println("값 : "+playerNumList[max]);
					
					cardDistribute1.resetAll();cardDistribute2.resetAll();cardDistribute3.resetAll();cardDistribute4.resetAll();cardDistribute5.resetAll();
					cardDistribute6.resetAll();cardDistribute7.resetAll();cardDistribute8.resetAll();cardDistribute9.resetAll();cardDistribute10.resetAll();
					
					
					if (playerSide.moneyLeft > gameManager.notifyBasicBet()) {
						playerSide.moneyLeft = playerSide.moneyLeft - gameManager.notifyBasicBet();
						gameManager.collectBasicBet();
					}else if(playerSide.moneyLeft < gameManager.notifyBasicBet()){
						gameManager.collectCall(playerSide.moneyLeft);
						playerSide.moneyLeft = 0;
					}
					
					if (centerPlayers.player2MoneyLeft > gameManager.notifyBasicBet()) {
						centerPlayers.player2MoneyLeft = centerPlayers.player2MoneyLeft - gameManager.notifyBasicBet();
						gameManager.collectBasicBet();
					}else if(centerPlayers.player2MoneyLeft < gameManager.notifyBasicBet()){
						gameManager.collectCall(centerPlayers.player2MoneyLeft);
						centerPlayers.player2MoneyLeft = 0;
					}
					
					if (northernPlayers.player3MoneyLeft > gameManager.notifyBasicBet()) {
						northernPlayers.player3MoneyLeft = northernPlayers.player3MoneyLeft - gameManager.notifyBasicBet();
						gameManager.collectBasicBet();
					}else if(northernPlayers.player3MoneyLeft < gameManager.notifyBasicBet()){
						gameManager.collectCall(northernPlayers.player3MoneyLeft);
						northernPlayers.player3MoneyLeft = 0;
					}
					
					if (northernPlayers.player4MoneyLeft > gameManager.notifyBasicBet()) {
						northernPlayers.player4MoneyLeft = northernPlayers.player4MoneyLeft - gameManager.notifyBasicBet();
						gameManager.collectBasicBet();
					}else if(northernPlayers.player4MoneyLeft < gameManager.notifyBasicBet()){
						gameManager.collectCall(northernPlayers.player4MoneyLeft);
						northernPlayers.player4MoneyLeft = 0;
					}
					
					if (centerPlayers.player5MoneyLeft > gameManager.notifyBasicBet()) {
						centerPlayers.player5MoneyLeft = centerPlayers.player5MoneyLeft - gameManager.notifyBasicBet();
						gameManager.collectBasicBet();
					}else if(centerPlayers.player5MoneyLeft < gameManager.notifyBasicBet()){
						gameManager.collectCall(centerPlayers.player5MoneyLeft);
						centerPlayers.player5MoneyLeft = 0;
					}
					
					wholeCardDeck.resetCardDeck();
					
					wholeCardDeck.shuffle();
					
					
					
					p1card = wholeCardDeck.getOne();p1card2 = wholeCardDeck.getOne();
					if (p1card.num > p1card2.num) {
						Card temp;
						temp = p1card;
						p1card = p1card2;
						p1card2 = temp;
					}
					playerSide.playerCard1 = p1card; playerSide.playerCard2 = p1card2;
					playerSide.playerCardPanel.isFirstGameStarted();
					
					p2card = wholeCardDeck.getOne();p2card2 = wholeCardDeck.getOne();
					if (p2card.num > p2card2.num) {
						Card temp;	
						temp = p2card;
						p2card = p2card2;
						p2card2 = temp;
					}
					centerPlayers.player2Card1 = p2card; centerPlayers.player2CardPanel.playerCard1 = p2card; 
					centerPlayers.player2Card2 = p2card2; centerPlayers.player2CardPanel.playerCard2 = p2card2;
					centerPlayers.player2CardPanel.isFirstGameSet();
					
					p3card = wholeCardDeck.getOne();p3card2 = wholeCardDeck.getOne();
					if (p3card.num > p3card2.num) {
						Card temp;	
						temp = p3card;
						p3card = p3card2;
						p3card2 = temp;
					}
					northernPlayers.player3Card1 = p3card;northernPlayers.player3CardPanel.playerCard1 = p3card;
					northernPlayers.player3Card2 = p3card2;northernPlayers.player3CardPanel.playerCard2 = p3card2;
					northernPlayers.player3CardPanel.isFirstGameSet();
					
					p4card = wholeCardDeck.getOne();p4card2 = wholeCardDeck.getOne();
					if (p4card.num > p4card2.num) {
						Card temp;	
						temp = p4card;
						p4card = p4card2;
						p4card2 = temp;
					}
					northernPlayers.player4Card1 = p4card;northernPlayers.player4CardPanel.playerCard1 = p4card; 
					northernPlayers.player4Card2 = p4card2;northernPlayers.player4CardPanel.playerCard2 = p4card2;
					northernPlayers.player4CardPanel.isFirstGameSet();
					
					p5card = wholeCardDeck.getOne();p5card2 = wholeCardDeck.getOne();
					if (p5card.num > p5card2.num) {
						Card temp;
						temp = p5card;
						p5card = p5card2;
						p5card2 = temp;
					}
					centerPlayers.player5Card1 = p5card;centerPlayers.player5CardPanel.playerCard1 = p5card; 
					centerPlayers.player5Card2 = p5card2; centerPlayers.player5CardPanel.playerCard2 = p5card2;
					centerPlayers.player5CardPanel.isFirstGameSet();
					
					
					if (playerSide.isconnected ==-1) playerSide.isconnected = 0;
					
					if (centerPlayers.player2MoneyLeft ==0) {
						centerPlayers.player2MoneyLeft = 300000;
					}
					if (playerSide.moneyLeft==0) {
						playerSide.moneyLeft = 300000;
					}
					if (centerPlayers.player5MoneyLeft==0) {
						centerPlayers.player5MoneyLeft =300000;
					}
					if (northernPlayers.player3MoneyLeft == 0) {
						northernPlayers.player3MoneyLeft = 300000;
					}
					if (northernPlayers.player4MoneyLeft == 0) {
						northernPlayers.player4MoneyLeft = 300000;
					}

					count = 0;

				}	
				
			}
			
			
			
			
		}
	}
	
	
	
	
}
