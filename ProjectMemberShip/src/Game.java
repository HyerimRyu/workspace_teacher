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
		setTitle("��Դ� ���ϱ�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(360, 600);
		setLocationRelativeTo(null);
		
		//MyPanel��ü �����ӿ� �߰��ϱ�
		myPanel= new MyPanel();
		add(myPanel, BorderLayout.CENTER);
		
		setLocation(500, 50);
		setResizable(false);
		setVisible(true);
		
		 
		// ������ �����Ű�� �۾��� �����ϴ� ������ ��ü ����
		gameThread= new GameThread();
		gameThread.start();
		
		//Ű���� �̺�Ʈ ó�� ������ �߰��ϱ�
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				//�����Է¸� ������ �޼ҵ念��
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("released:"+ e.getKeyCode()+","+e.getKeyChar());
				//����Ű�� 2������ ����
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
				
				//����Ű�� 2������ ����
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
		
		//�÷��̾� �������
		Image img;
		int x, y;  //�̹����� ��ǥ
		int w, h;  //�̹����� ���ݳ���, ���ݳ���
		
		int dx=0, dy=0; //x, y ��ǥ�� ��ȭ��(�̵� ����, �ӵ�)
		
		int width, height;//MyPanel�� ����,���� ������
		
		Image imgBack; //��׶��� �̹���
	
		
		//������ 
		ArrayList<Enemy> enemies= new ArrayList<>();
		
		//����
		int score=0;
		int life=30;
		
		
		
		public MyPanel() {
			//�̹��� ��ü �����
			Toolkit toolkit= Toolkit.getDefaultToolkit();
			img= toolkit.getImage("images/7.png");
			//�̹��� ������¡
			img= img.getScaledInstance(32,45, Image.SCALE_SMOOTH);
			w= 16; //�̹����� ������
			h= 27; //�̹����� ���ݳ���		
			
			//��׶��� �̹��� ��ü ����
			imgBack= toolkit.getImage("images/bg.jpg");
		}//constructor...
	
		@Override
		protected void paintComponent(Graphics g) {
			
			if(width==0 || height==0) {
				width= getWidth();
				height= getHeight();
				
				//�÷��̾� �̹����� ó�� ���� ��ǥ���(ȭ���� ����� �����ϵ���)
				x=width/2;  
				y=height-45;
				
				//��� �̹����� MyPanel���ϰ� ������¡
				imgBack= imgBack.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			}
			//ȭ���� ��� �����
			g.clearRect(0, 0, width, height);
			
			//��� �̹��� �׸���
			g.drawImage(imgBack, 0, 0, this);
			
			//������ �׸���
			for(Enemy t: enemies) {
				g.drawImage(t.img, t.x-t.w, t.y-t.h, this);
			}
			
			//�÷��̾� �̹��� �׸���
			g.drawImage(img, x-w, y-h, this);
			
			g.setColor(Color.green);
			g.setFont(new Font(null, Font.BOLD,20));
			g.drawString("score"+score, 10, 30);
			g.drawString("Life"+life, 280, 30);
			
		}//paintComponent method...
		
		//�÷��̾� �����̴� ��ɸ޼ҵ�
		public void move() {
			x += dx;
			y += dy;
			if(x<w) x=w;
			if(x>width-w) x=width-w;
			if(y<h) y=h;
			if(y>height-h)y=height-h;
			
		}
		
		//������ �����. �޵���
		void makeEnemy() {
			//100���� �ѹ����� Ȯ���� �����.
			Random rnd= new Random();
			int n= rnd.nextInt(10); //0~49
			if( n==0 ) {
				enemies.add( new Enemy(width, height) );
			}
			
			
		}
		
		//������ �����̱�..�޼ҵ�
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

		
		//������� �÷��̾��� �浹üũ �޼ҵ�
		void checkCollision() {
			for(Enemy t: enemies) {
				if(t.checkCollision(x, y)) {
					life+=-10;
					score+=-5;
					
					if (life <= 0) {	
						
						JOptionPane.showMessageDialog(this, "�������� ! "+" �� ������"+score+"��"+"\n"+" F5 = �ѹ� �� / Esc=����");
//						game.this.dispose();
						try {Thread.sleep(10000000);} catch (Exception e) {}
					}
				}				
				
			}
		}
		
	
				
		
	}//MyPanel class.....
	
	//GameThread ����( 10ms���� ȭ�� ���� )
	class GameThread extends Thread{
		
		@Override
		public void run() {
			
			while(true) {
				try {
					myPanel.move();//�÷��̾� �����̱�( ��ǥ ���� )
					myPanel.makeEnemy();//������ ����
					myPanel.moveEnemy();//������ �����̱�
					myPanel.checkCollision();//�浹 üũ���..
					
					myPanel.repaint();//ȭ�鰻��
					
					Thread.sleep(20); //20ms(1�ʿ� 50��)
				}catch(Exception e) {}				
			}						
		}
		
	}	//GameThread ����( 10ms���� ȭ�� ���� )
	
	

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
	
	int width, height;//ȭ�� ������(MyPanel������)
	
	public Enemy(int width, int height) {
		this.width= width; this.height= height;
		
		Toolkit toolkit= Toolkit.getDefaultToolkit();
		img= toolkit.getImage("images/8.png");
		img= img.getScaledInstance(64, 90, Image.SCALE_SMOOTH);
		w= 30	;
		h= 30;
		
		
		y= -h; //ȭ�� �� �ٱ���..
		
		//������ x�� ��ġ�� �����ϰ�..
		Random rnd= new Random();
		x= rnd.nextInt(width-w*2)+w;
		
		//�������� �ӵ�
		dy= rnd.nextInt(5)+10;//1~10
	}
	
	//�����̴� ��ɸ޼ҵ�
	void move() {
		y+=dy;
		//ȭ�� �Ʒ� �ٱ������� ������ �׾�!!
		if( y>height+h ) {
			isDead= true;
		}
	}
	
	//�÷��̾ ���� �浹�ߴ��� üũ�ϴ� �޼ҵ�
	boolean checkCollision(int px, int py) {
		if( px>x-w && px<x+w && py>y-h && py<y+h ) {
			//�÷��̾��� px,py������ ������ �簢�� ����
			//�ȿ� �ִ�!!�׷��Ƿ� ���� ���̱�!!
			isDead= true;
			return true;
		}
		return false;
	}
	
	
}