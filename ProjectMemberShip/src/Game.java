import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JFrame{
	
	MyPanel myPanel;
	GameThread gameThread;
	
	
	public Game() {
		setTitle("토게느 피하기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(360, 600);
		setLocationRelativeTo(null);
		
		//MyPanel객체 프레임에 추가하기
		myPanel= new MyPanel();
		add(myPanel, BorderLayout.CENTER);
		
		setLocation(500, 50);
		setResizable(false);
		setVisible(true);
		
		 
		// 게임을 진행시키는 작업을 수행하는 스레드 객체 생성
		gameThread= new GameThread();
		gameThread.start();
		
		//키보드 이벤트 처리 리스너 추가하기
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				//문자입력만 가능한 메소드영역
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("released:"+ e.getKeyCode()+","+e.getKeyChar());
				//방향키의 2개방향 구분
				switch( e.getKeyCode() ) {
				case KeyEvent.VK_LEFT:
					myPanel.dx= 0;
					break;
					
				case KeyEvent.VK_RIGHT:
					myPanel.dx= 0;
					break;

				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("pressed:"+ e.getKeyCode()+","+e.getKeyChar());
				
				//방향키의 2개방향 구분
				switch( e.getKeyCode() ) {
				case KeyEvent.VK_LEFT:
					myPanel.dx= -20;
					break;
					
				case KeyEvent.VK_RIGHT:
					myPanel.dx= 20;
					break;
					
				case KeyEvent.VK_F5:
					Game.this.dispose();
					new Game();
					break;
				case KeyEvent.VK_ESCAPE:
					Game.this.dispose();
					new MainFrame();
					break;
				}
				
				
			}
		});
		
	};
	
	
	
	class MyPanel extends JPanel {
		
		//플레이어 멤버변수
		Image img;
		int x, y;  //이미지의 좌표
		int w, h;  //이미지의 절반넓이, 절반높이
		
		int dx=0, dy=0; //x, y 좌표의 변화량(이동 방향, 속도)
		
		int width, height;//MyPanel의 가로,세로 사이즈
		
		Image imgBack; //백그라운드 이미지
	
		
		//적군들 
		ArrayList<Enemy> enemies= new ArrayList<>();
		
		//점수
		int score=0;
		int life=30;
		
		
		
		public MyPanel() {
			//이미지 객체 만들기
			Toolkit toolkit= Toolkit.getDefaultToolkit();
			img= toolkit.getImage("images/7.png");
			//이미지 리사이징
			img= img.getScaledInstance(32,45, Image.SCALE_SMOOTH);
			w= 16; //이미지의 절반폭
			h= 27; //이미지의 절반높이		
			
			//백그라운드 이미지 객체 생성
			imgBack= toolkit.getImage("images/bg.jpg");
		}//constructor...
	
		@Override
		protected void paintComponent(Graphics g) {
			
			if(width==0 || height==0) {
				width= getWidth();
				height= getHeight();
				
				//플레이어 이미지의 처음 시작 좌표계산(화면의 가운데서 시작하도록)
				x=width/2;  
				y=height-45;
				
				//배경 이미지를 MyPanel만하게 리사이징
				imgBack= imgBack.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			}
			//화면을 모두 지우기
			g.clearRect(0, 0, width, height);
			
			//배경 이미지 그리기
			g.drawImage(imgBack, 0, 0, this);
			
			//적군들 그리기
			for(Enemy t: enemies) {
				g.drawImage(t.img, t.x-t.w, t.y-t.h, this);
			}
			
			//플레이어 이미지 그리기
			g.drawImage(img, x-w, y-h, this);
			
			g.setColor(Color.green);
			g.setFont(new Font(null, Font.BOLD,20));
			g.drawString("score"+score, 10, 30);
			g.drawString("Life"+life, 280, 30);
			
		}//paintComponent method...
		
		//플레이어 움직이는 기능메소드
		public void move() {
			x += dx;
			y += dy;
			if(x<w) x=w;
			if(x>width-w) x=width-w;
			if(y<h) y=h;
			if(y>height-h)y=height-h;
			
		}
		
		//적군들 만들기. 메도스
		void makeEnemy() {
			//100번에 한번꼴의 확률로 만들기.
			Random rnd= new Random();
			int n= rnd.nextInt(10); //0~49
			if( n==0 ) {
				enemies.add( new Enemy(width, height) );
			}
			
			
		}
		
		//적군들 움직이기..메소드
		void moveEnemy() {
			
			for(int i=enemies.size()-1; i>=0; i--) {
				Enemy e= enemies.get(i);
				e.move();
				
				if(e.isDead) {
					enemies.remove(i);
					score+=5;
				}
			}
		}

		
		//적군들과 플레이어의 충돌체크 메소드
		void checkCollision() {
			for(Enemy t: enemies) {
				if(t.checkCollision(x, y)) {
					life+=-10;
					score+=-5;
					
					if (life <= 0) {	
						
						JOptionPane.showMessageDialog(this, "게임종료 ! "+" 내 점수는"+score+"점"+"\n"+" F5 = 한번 더 / Esc=종료");
//						game.this.dispose();
						try {Thread.sleep(10000000);} catch (Exception e) {}
					}
				}				
				
			}
		}
		
	
				
		
	}//MyPanel class.....
	
	//GameThread 설계( 10ms마다 화면 갱신 )
	class GameThread extends Thread{
		
		@Override
		public void run() {
			
			while(true) {
				try {
					myPanel.move();//플레이어 움직이기( 좌표 변경 )
					myPanel.makeEnemy();//적군들 생성
					myPanel.moveEnemy();//적군들 움직이기
					myPanel.checkCollision();//충돌 체크계산..
					
					myPanel.repaint();//화면갱신
					
					Thread.sleep(20); //20ms(1초에 50번)
				}catch(Exception e) {}				
			}						
		}
		
	}	//GameThread 설계( 10ms마다 화면 갱신 )
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();
	}

}


class Enemy{
	
	Image img;
	int x, y;
	int w, h;
	boolean isDead= false;
	
	int dy;
	
	int width, height;//화면 사이즈(MyPanel사이즈)
	
	public Enemy(int width, int height) {
		this.width= width; this.height= height;
		
		Toolkit toolkit= Toolkit.getDefaultToolkit();
		img= toolkit.getImage("images/8.png");
		img= img.getScaledInstance(64, 90, Image.SCALE_SMOOTH);
		w= 30	;
		h= 30;
		
		
		y= -h; //화면 위 바깥쪽..
		
		//적군의 x축 위치는 랜덤하게..
		Random rnd= new Random();
		x= rnd.nextInt(width-w*2)+w;
		
		//떨어지는 속도
		dy= rnd.nextInt(5)+10;//1~10
	}
	
	//움직이는 기능메소드
	void move() {
		y+=dy;
		//화면 아래 바깥쪽으로 나가면 죽어!!
		if( y>height+h ) {
			isDead= true;
		}
	}
	
	//플레이어가 나와 충돌했는지 체크하는 메소드
	boolean checkCollision(int px, int py) {
		if( px>x-w && px<x+w && py>y-h && py<y+h ) {
			//플레이어의 px,py지점이 적군의 사각형 영역
			//안에 있다!!그러므로 적군 죽이기!!
			isDead= true;
			return true;
		}
		return false;
	}
	
	
}