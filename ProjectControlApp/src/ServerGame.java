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

		// ����ȭ��
		JPanel GameMain = new JPanel(new BorderLayout());
		panel = new GameImg(); // �̹��� ��� �г� ��ü ����

		gamethread = new GameThread();
		gamethread.setDaemon(true); // â�� ��ĥ�� ������ �����嵵 ���� �� ����
		gamethread.start();

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);// â�� ��ĥ�� ������ �����嵵 ���� �� ����
		add(panel, BorderLayout.CENTER);
		setTitle("player1 Game");
		setBounds(410, 140, 460, 700);
		setResizable(false);
		setVisible(true);

		// Ű���� ������
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

	} // ������
		// ĳ���� ��ǥ ��.. �̹���

	class GameImg extends JPanel {

		int x, y; // �̹����� ��ǥ
		int w, h; // �̹����� ���� ����, ���� ����
		int width, height; // MyPanel�� ����,���� ������

		int ax = 0, ay = 0;

		int dx = 0, dy = 0; // x,y��ǥ�� ��ȭ�� (�̵� ����, �ӵ�)

		int loop = 0; // ��� �̹��� �̵�
		int loop2 = -1060;

		Image imgBack; // ��׶��� �̹���
		ArrayList<Bullet> bullets = new ArrayList<>();

		// ������
		ArrayList<monster> enemies = new ArrayList<>();

		int score = 0;

		public GameImg() {

			// �̹��� ��ü �����
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Character = toolkit.getImage("images/spong.png");
			// �̹��� ������¡
			Character = Character.getScaledInstance(64, 64, Image.SCALE_SMOOTH);

			w = 32; // �̹����� ������
			h = 32;// �̹����� ���ݳ���.

			// ��׶��� �̹��� ��ü ����
			imgBack = toolkit.getImage("images/Home.jpg");
		}

		@Override
		protected void paintComponent(Graphics g) {

			if (width == 0 || height == 0) {
				width = getWidth();
				height = getHeight();

				// �÷��̾� �̹����� ó�� ���� ��ǥ���(ȭ���� ����� �����ϵ���)
				x = width / 2;
				y = height / 2;

				// ������ �÷��̾� ��ǥ�� �̿��ؼ� �Ѿ� ��ġ�� ���� �� ����
				bullets.add(new Bullet(x + 15, y - 35));

				// ��� �̹�����MyPanel���ϰ� ������¡
				imgBack = imgBack.getScaledInstance(width, height + 400, Image.SCALE_SMOOTH);

			}
			// ȭ���� ��� �����
			g.clearRect(0, 0, width, height);

			// ��� �̹��� �׸���

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

			// �÷��̾� �̹��� �׸���
			g.drawImage(Character, (x - w), (y - h), this);
			// �� �̹��� (�̻���) �׸���
			for (int i = 0; i < bullets.size(); i++) { // bullets.size() == 3
				// ����ϴ� �κ�
				if (bullets.get(i).isMoving)
					bullets.get(i).y -= 3;
				else {
					// �տ� �ִ� �Ѿ��� x��ǥ�� panel.x + 15�� �ǰԲ�, �Ѿ��� y��ǥ�� panel.y - 35�� �ǰԲ� �ٲ�� ��.
					bullets.get(i).x = panel.x + 15;
					bullets.get(i).y = panel.y - 35;
				}

				// �׸��� �κ�
				g.drawImage(bullets.get(i).attack, bullets.get(i).x, bullets.get(i).y, this);
			}

			// ������ �׸���
			for (monster t : enemies) {
				g.drawImage(t.img, t.x - t.w, t.y - t.h, this);
			}

			// ���� ǥ���ϱ�..
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
			// 100���� �ѹ����� Ȯ���� �����.
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
						score += 10; // ���� Ŭ������ �����ϴ� t �׸��� enemies (��̸���Ʈ)
						

					}

				}

			}
			if (Life < 1) {
				try {
					JOptionPane.showMessageDialog(null, "��������");
					Threadkill = false;

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

		// ������ �����̱�..�޼ҵ�
		void moveEnemy() {

			for (int i = enemies.size() - 1; i >= 0; i--) {
				monster e = enemies.get(i);
				e.move();

				if (e.isDead) {
					enemies.remove(i);

				}
			}
		}

		// ������� �÷��̾��� �浹üũ �޼ҵ�
		void checkCollision() {
			for (monster t : enemies) {
				if (t.checkCollision(x, y)) {
					Life += -1;
					score += -100; // ���� Ŭ������ �����ϴ� t �׸��� enemies (��̸���Ʈ)
				}

			}
		}
	}// MyPanel class.....

	class GameThread extends Thread {

		@Override
		public void run() {

			while (Threadkill) {
				try {
					panel.move();// �÷��̾� �����̱�( ��ǥ ���� )
					panel.makeEnemy();// ������ ����
					panel.moveEnemy();// ������ �����̱�
					panel.checkCollision();// �浹 üũ���..
					panel.checkCollisionok();
					panel.repaint();// ȭ�鰻��
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

		int dy; // �������� �ӵ�

		int width, height;// ȭ�� ������(MyPanel������)

		public monster(int width, int height) {
			this.width = width;
			this.height = height;

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			img = toolkit.getImage("images/pa.png");
			img = img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
			w = 35;
			h = 35;

			y = -h; // ȭ�� �� �ٱ���..

			// ������ x�� ��ġ�� �����ϰ�.. ���ֱ�
			Random rnd = new Random();
			x = rnd.nextInt(width - w * 2) + w;

			// �������� �ӵ�(������ ����)
			dy = rnd.nextInt(2) + 4;// 1~10
		}

		// �÷��̾ ���� �浹�ߴ��� üũ�ϴ� �޼ҵ�
		boolean checkCollision(int px, int py) {
			if (px > x - w && px < x + w && py > y - h && py < y + h) {
				// �÷��̾��� px,py������ ������ �簢�� ����
				// �ȿ� �ִ�!!�׷��Ƿ� ���� ���̱�!!
				isDead = true;
				return true;
			}
			return false;
		}// check�ݷ���..
		// �����̴� ��ɸ޼ҵ�

		void move() {

			y += dy;

			// ȭ�� �Ʒ� �ٱ������� ������ �׾�!!
			if (y > height + h) {
				Life += -1;
				isDead = true;
				panel.score += -20;
			}
		} // move �޼ҵ�..

		boolean checkCollisionddong(int ddx, int ddy) {
			if (ddx > x - w && ddx < x + w && ddy > y - h && ddy < y + h) {
				// ���� ddx,ddy������ ������ �簢�� ����
				// �ȿ� �ִ�!!�׷��Ƿ� ���� ���̱�!!
				isDead = true;
				return true;
			}
			return false;
		}// check�ݷ���..
	}// monster Ŭ����...

	class Bullet {
		int x;
		int y;
		Image attack;// ���� �̹���
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