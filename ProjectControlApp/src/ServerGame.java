import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

public class ServerGame extends JFrame {
	Image monsterimg;
	Image imback;
	Image Character;
	GameImg panel;
	GameThread gamethread;
	boolean attackok = false;
	boolean Threadkill = true;
	Socket socket;
	int Life = 5;

	public ServerGame() {

		// 메인화면
		JPanel GameMain = new JPanel(new BorderLayout());
		panel = new GameImg(); // 이미지 담당 패널 객체 생성

		gamethread = new GameThread();
		gamethread.setDaemon(true); // 창이 닫칠때 데이터 쓰레드도 종료 셋 데몬
		gamethread.start();

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);// 창이 닫칠때 데이터 쓰레드도 종료 셋 데몬
		add(panel, BorderLayout.CENTER);
		setTitle("player1 Game");
		setBounds(410, 140, 460, 700);
		setResizable(false);
		setVisible(true);

		// 키보드 리스너
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					panel.dx = -0;
					break;
				case KeyEvent.VK_RIGHT:
					panel.dx = 0;
					break;
				case KeyEvent.VK_UP:
					panel.dy = 0;
					break;
				case KeyEvent.VK_DOWN:
					panel.dy = 0;
					break;
				case KeyEvent.VK_A:
					panel.bullets.get(panel.bullets.size() - 1).isMoving = true;

					panel.bullets.add(new Bullet(panel.x + 15, panel.y - 35));
					break;

				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					panel.dx = -12;
					break;
				case KeyEvent.VK_RIGHT:
					panel.dx = 12;
					break;
				case KeyEvent.VK_UP:
					panel.dy = -12;
					break;
				case KeyEvent.VK_DOWN:
					panel.dy = 12;
					break;
				case KeyEvent.VK_A:
					break;
				}
			}
		});

	} // 생성자
		// 캐릭터 좌표 값.. 이미지

	class GameImg extends JPanel {

		int x, y; // 이미지의 좌표
		int w, h; // 이미지의 절반 넓이, 절반 높이
		int width, height; // MyPanel의 가로,세로 사이즈

		int ax = 0, ay = 0;

		int dx = 0, dy = 0; // x,y좌표의 변화량 (이동 방향, 속도)

		int loop = 0; // 배경 이미지 이동
		int loop2 = -1060;

		Image imgBack; // 백그라운드 이미지
		ArrayList<Bullet> bullets = new ArrayList<>();

		// 적군들
		ArrayList<monster> enemies = new ArrayList<>();

		int score = 0;

		public GameImg() {

			// 이미지 객체 만들기
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Character = toolkit.getImage("images/spong.png");
			// 이미지 리사이징
			Character = Character.getScaledInstance(64, 64, Image.SCALE_SMOOTH);

			w = 32; // 이미지의 절반폭
			h = 32;// 이미지의 절반높이.

			// 백그라운드 이미지 객체 생성
			imgBack = toolkit.getImage("images/Home.jpg");
		}

		@Override
		protected void paintComponent(Graphics g) {

			if (width == 0 || height == 0) {
				width = getWidth();
				height = getHeight();

				// 플레이어 이미지의 처음 시작 좌표계산(화면의 가운데서 시작하도록)
				x = width / 2;
				y = height / 2;

				// 결정된 플레이어 좌표를 이용해서 총알 위치를 결정 및 생성
				bullets.add(new Bullet(x + 15, y - 35));

				// 배경 이미지를MyPanel만하게 리사이징
				imgBack = imgBack.getScaledInstance(width, height + 400, Image.SCALE_SMOOTH);

			}
			// 화면을 모두 지우기
			g.clearRect(0, 0, width, height);

			// 배경 이미지 그리기

			g.drawImage(imgBack, 0, loop, this);
			g.drawImage(imgBack, 0, loop2, this);
			loop++;
			loop2++;

			if (loop % 2 == 0 && loop2 % 2 == 0) {
				if (loop >= width) {
					loop = 0;
					loop2 = -width;
				}
			}

			// 플레이어 이미지 그리기
			g.drawImage(Character, (x - w), (y - h), this);
			// 똥 이미지 (미사일) 그리기
			for (int i = 0; i < bullets.size(); i++) { // bullets.size() == 3
				// 계산하는 부분
				if (bullets.get(i).isMoving)
					bullets.get(i).y -= 3;
				else {
					// 손에 있는 총알의 x좌표가 panel.x + 15가 되게끔, 총알의 y좌표가 panel.y - 35가 되게끔 바꿔야 함.
					bullets.get(i).x = panel.x + 15;
					bullets.get(i).y = panel.y - 35;
				}

				// 그리는 부분
				g.drawImage(bullets.get(i).attack, bullets.get(i).x, bullets.get(i).y, this);
			}

			// 적군들 그리기
			for (monster t : enemies) {
				g.drawImage(t.img, t.x - t.w, t.y - t.h, this);
			}

			// 점수 표시하기..
			g.setColor(Color.YELLOW);
			g.setFont(new Font(null, Font.BOLD, 20));
			g.drawString("Score" + score, 10, 30);
			g.drawString("Life" + Life, 380, 30);
		}

		public void move() {
			if (x < w)
				x = w;
			if (x > width - w)
				x = width - w;
			if (y < h)
				y = h;
			if (y > height - h)
				y = height - h;
			x += dx;
			y += dy;

		}// move method..

		void makeEnemy() {
			// 100번에 한번꼴의 확률로 만들기.
			Random rnd = new Random();
			int n = rnd.nextInt(20); // 0~49
			if (n == 0) {
				enemies.add(new monster(width, height));
			}
		}

		void checkCollisionok() {

			for (monster t : enemies) {

				for (int i = 0; i < bullets.size(); i++) {

					if (t.checkCollisionddong(bullets.get(i).x, bullets.get(i).y)) {

						bullets.remove(i);
						if (bullets.size() == 0) {
							bullets.add(new Bullet(panel.x, panel.y));
						}
						score += 10; // 몬스터 클래스를 참조하는 t 그리고 enemies (어레이리스트)
						

					}

				}

			}
			if (Life < 1) {
				try {
					JOptionPane.showMessageDialog(null, "게임종료");
					Threadkill = false;

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

		// 적군들 움직이기..메소드
		void moveEnemy() {

			for (int i = enemies.size() - 1; i >= 0; i--) {
				monster e = enemies.get(i);
				e.move();

				if (e.isDead) {
					enemies.remove(i);

				}
			}
		}

		// 적군들과 플레이어의 충돌체크 메소드
		void checkCollision() {
			for (monster t : enemies) {
				if (t.checkCollision(x, y)) {
					Life += -1;
					score += -100; // 몬스터 클래스를 참조하는 t 그리고 enemies (어레이리스트)
				}

			}
		}
	}// MyPanel class.....

	class GameThread extends Thread {

		@Override
		public void run() {

			while (Threadkill) {
				try {
					panel.move();// 플레이어 움직이기( 좌표 변경 )
					panel.makeEnemy();// 적군들 생성
					panel.moveEnemy();// 적군들 움직이기
					panel.checkCollision();// 충돌 체크계산..
					panel.checkCollisionok();
					panel.repaint();// 화면갱신
					Thread.sleep(15);

				} catch (Exception e) {
				}
			}
		}

	}// gamethread..

	class monster {

		Image img;
		int x, y;
		int w, h;

		boolean isDead = false;

		int dy; // 떨어지는 속도

		int width, height;// 화면 사이즈(MyPanel사이즈)

		public monster(int width, int height) {
			this.width = width;
			this.height = height;

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			img = toolkit.getImage("images/pa.png");
			img = img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
			w = 35;
			h = 35;

			y = -h; // 화면 위 바깥쪽..

			// 적군의 x축 위치는 랜덤하게.. 값주기
			Random rnd = new Random();
			x = rnd.nextInt(width - w * 2) + w;

			// 떨어지는 속도(랜덤값 대입)
			dy = rnd.nextInt(2) + 4;// 1~10
		}

		// 플레이어가 나와 충돌했는지 체크하는 메소드
		boolean checkCollision(int px, int py) {
			if (px > x - w && px < x + w && py > y - h && py < y + h) {
				// 플레이어의 px,py지점이 적군의 사각형 영역
				// 안에 있다!!그러므로 적군 죽이기!!
				isDead = true;
				return true;
			}
			return false;
		}// check콜렉션..
		// 움직이는 기능메소드

		void move() {

			y += dy;

			// 화면 아래 바깥쪽으로 나가면 죽어!!
			if (y > height + h) {
				Life += -1;
				isDead = true;
				panel.score += -20;
			}
		} // move 메소드..

		boolean checkCollisionddong(int ddx, int ddy) {
			if (ddx > x - w && ddx < x + w && ddy > y - h && ddy < y + h) {
				// 똥의 ddx,ddy지점이 적군의 사각형 영역
				// 안에 있다!!그러므로 적군 죽이기!!
				isDead = true;
				return true;
			}
			return false;
		}// check콜렉션..
	}// monster 클래스...

	class Bullet {
		int x;
		int y;
		Image attack;// 똥의 이미지
		boolean isMoving = false;

		public Bullet(int x, int y) {

			this.x = x;
			this.y = y;

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			attack = toolkit.getImage("images/dalpong.png");
			attack = attack.getScaledInstance(40, 35, Image.SCALE_SMOOTH);

		}// Bullet...
	}
}// JFrame..