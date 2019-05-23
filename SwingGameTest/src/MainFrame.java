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
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	GamePanel panel;
	GameThread gThread;
	
	public MainFrame() {
		// TODO Auto-generated constructor stub
		setTitle("스윙 그래픽 게임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600, 50, 360, 600);
		setResizable(false);
		
		panel= new GamePanel();
		add(panel, BorderLayout.CENTER);		
		
		setVisible(true);
		
		//게임을 진행시키는 스레드객체생성 및 스타트...
		gThread= new GameThread();
		gThread.start();//run()메소드 자동실행!!
		
		
		//프레임에 키보드입력에 반응하는 KeyListener객체 추가
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				//눌러진 키가 무엇인지 알아내기..
				int keyCode= e.getKeyCode();
				
				//방향키 4개 구분
				switch( keyCode ) {
				case KeyEvent.VK_LEFT:
					panel.dx= 0;
					break;
					
				case KeyEvent.VK_RIGHT:
					panel.dx= 0;
					break;
					
				case KeyEvent.VK_UP:
					panel.dy= 0;
					break;
					
				case KeyEvent.VK_DOWN:
					panel.dy= 0;
					break;				
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//눌러진 키가 무엇인지 알아내기..
				int keyCode= e.getKeyCode();
				
				//방향키 4개 구분
				switch( keyCode ) {
				case KeyEvent.VK_LEFT:
					panel.dx= -8;
					break;
					
				case KeyEvent.VK_RIGHT:
					panel.dx= 8;
					break;
					
				case KeyEvent.VK_UP:
					panel.dy= -8;
					break;
					
				case KeyEvent.VK_DOWN:
					panel.dy= 8;
					break;				
				}				
				
			}
		});
	}
	
	
	//Game화면을 그려낼 Panel 이너클래스/////////////////////
	class GamePanel extends JPanel{
		
		//화면에 보여질 이미지객체 참조변수들 -멤버변수
		Image imgBack;
		Image imgPlayer;
		Image imgEnemy;
		
		//패널의 가로세로 사이즈
		int width;
		int height;		
		
		int x, y; //플레이어의 중심 좌표
		int w, h; //플레이어 이미지의 절반폭, 절반높이
		
		int dx=0, dy=0; //플레이어 이미지의 이동속도, 이동방향
		
		//적군객체 참조변수..//여러마리일 수있으며 개수가 유동적이므로 
		//유동적 배열
		ArrayList<Enemy> enemies= new ArrayList<>();
		
		//점수
		int score;		
		
		public GamePanel() {
			// TODO Auto-generated constructor stub
			//GUI관련 프로그램의 편의를 위해 만들어진 도구상자(Toolkit) 객체 얻어오기
			Toolkit toolkit= Toolkit.getDefaultToolkit();
			
			//생성자에서 폭,높이값을 구하면 무조건 0임. why?? 아직 사이즈가 결정되지 않았으므로..
			//width= getWidth();
			//height= getHeight();
			
			//배경이미지 객체 생성
			imgBack= toolkit.getImage("images/bg.png");				
			//플레이어 이미지 객체 생성
			imgPlayer= toolkit.getImage("images/ms_01.png");
			//적군 이미지 객체 생성
			imgEnemy= toolkit.getImage("images/ms19.png");
			
		}//constructor		
		
		//화면에 보여질때 보여질 내용물작업을 수행하는 메소드 : 자동실행..callback메소드		
		@Override
		protected void paintComponent(Graphics g) {
			//여기에 화면에 보여질 작업을 코딩...
			if(width==0 || height==0) {//처음 호출되었을 때!!
				width= getWidth();
				height= getHeight();
				
				//배경이미지 리사이징..배경을 Panel만하게..
				imgBack= imgBack.getScaledInstance(width, height, Image.SCALE_SMOOTH);
				
				//플레이어이미지 리사이징..
				imgPlayer= imgPlayer.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
				
				//플레이어의 처음 시작 좌표계산..
				x= width/2;  //가로축은 화면의 가운데.
				y= height-100;//세로축은 밑에서 200위에 지점	
				
				//플레이어 이미지의 절반폭, 잘반높이값 계산
				w= 64;
				h= 64;				
			}
			
			
			
			//그림그리는 작업은 무조건 여기서!!!!! 이곳에 화가객체(Graphics g)가 있으므로..
			
			//배경 그리기!!
			g.drawImage(imgBack, 0, 0, this);
			
			//적군들 그리기!			
			for(Enemy t : enemies) {
				g.drawImage(t.img, t.x-t.w, t.y-t.h, this);				
			}
			
			//플레이어 그리기!!
			g.drawImage(imgPlayer, x-w, y-h, this);	
			
			//점수표시하기
			g.setColor(Color.WHITE);
			g.setFont( new Font(null, Font.BOLD, 20)  );
			g.drawString("SCORE : "+ score, 10, 30);
			
			
			
			//여러장면을 만들기 위해 일정시간마다 다시그려라(re painting)을 시켜야 함.
		}//paintComponent method...
		
		void move() {
			//적군들 움직이기
			//만약 중간에 배열의 개수가 변경될 여지가 있다면..
			//맨 마지막 요소부터 거꾸로 0번요소까지 역으로 처리해야함.
			for(int i= enemies.size()-1; i>=0; i--) {
				Enemy t= enemies.get(i);
				
				t.move();
				if(t.isDead) enemies.remove(i);	//ArrayList에서 제거!!			
			}
			
			//플레이어 움직이기(플레이어좌표 변경)
			x += dx;
			//y += dy;
			
			//플레이어의 자표가 화면밖으로 나가지 않도록!!
			if(x<w) x=w;
			if(x>width-w) x=width-w;
			if(y<h) y=h;
			if(y>height-h) y=height-h;
			////////////////////////////////////
		}
		
		//적군객체를 만들어내는 기능메소드!!
		void makeEnemy() {
			if(width==0 || height==0 ) return;
			
			//30번에 한번꼴로 만들기!!-확률
			Random rnd= new Random();
			int n= rnd.nextInt(30); //0~29
			if(n==0) { // 1/30의 확률
				enemies.add( new Enemy(imgEnemy, width, height)  );
			}						
		}//makeEnemy()
		
		//충돌체크작업 계산 메소드
		void chekckCollision() {
			//플레이어와 적군의 충돌..						
			for(Enemy t : enemies) {
				int left= t.x - t.w;
				int right= t.x + t.w;
				int top= t.y - t.h;
				int bottom= t.y + t.h;
				
				if(  x>left && x<right && y>top && y<bottom  ) {
					//충돌했음.
					t.isDead=true;
					
					//점수증가!!
					score+=5;
				}
			}
			
			
			
		}
		
	}//GamePanel class....
	////////////////////////////////////////////////////
	
	
	//일정시간마다 게임화면을 갱신시키는 작업을 수행하는 별도  Thread 클래스
	class GameThread extends Thread{
		@Override
		public void run() {
			while(true) {
				
				//적군객체 만들어내는 기능메소드를 호출!
				panel.makeEnemy();
				
				//GamePanel의 플레이어좌표변경
				//- 객체의 멤버값변경은 그 객체가 스스로 하도록 하는 것이 OOP의 주요특징!!
				//panel안에 본인의 좌표를 변경하는 메소드를 만들고 이를 호출해서 처리
				panel.move();
				
				//충돌체크기능 호출
				panel.chekckCollision();
				
				//GamePanel의 화면 갱신
				panel.repaint();
				
				//너무빨리 반복문이 돌아서 화면갱신할 시간도 없음..
				//잠시 대기
				try {
					Thread.sleep(20); //20ms(1초에 50번)
				} catch (InterruptedException e) {} 
				
			}//while			
		}
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
