import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex1 extends JFrame{
	
	public Ex1() {
		// TODO Auto-generated constructor stub
		setTitle("Graphic Test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 100, 500, 400);
		
		MyPanel panel= new MyPanel();
		add( panel , BorderLayout.CENTER);//�̶� �г��� ȭ�鿡 ������.�̶� �ڵ����� paintComponent()�޼ҵ尡 �����.				
		
		
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		
		//�г��� ���̿� ���̰�
		int width;
		int height;
		
		Image img;
		
		public MyPanel() {
			// TODO Auto-generated constructor stub		
			Toolkit toolkit= Toolkit.getDefaultToolkit();			
			img= toolkit.getImage("bazzi.png");
			img= img.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
		}
		
		//��� ������Ʈ���� ������ ȭ�鿡 ���������� �ϱ�����
		//�׸��� �׷���!! ��� ���(�޼ҵ�)�� ������.
		//������ �޼ҵ尡 ȣ��� �� 
		//ȭ�鿡 �������� �ڵ����� ����Ǵ� �޼ҵ尡 ������.
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub			
			//System.out.println("MyPanel paintCompoentȣ��");
			width= this.getWidth();
			height= this.getHeight();
			
			//�Ķ���ͷ� ���޵� ȭ����ü(Graphics)����..�׸��� ��û..
			
			//��Ʈ����(�۲�, ��Ÿ��, ũ��)
			g.setFont( new Font("Blippo Blk BT", Font.PLAIN, 20)  );
						
			//�۾� �׷���!!
			g.drawString("aaa", 50, 20);
			g.drawString("bbb", 0, 20);
			g.drawString("Hello", 0, height);			
			//�г��� ���� �� ����
			g.drawString(width + " * " + height, 100, 100);
			
			//���׸���
			g.drawLine(50, 50, 150, 50);
			g.drawLine(50, 60, 150, 60);
			g.drawLine(50, 70, 50, 170);
			g.drawLine(50, 70, 150, 170);
			g.drawLine(50, 170, 150, 170);
			
			//�簢���׸���
			g.drawRect(50, 200, 100, 50);
			g.drawRoundRect(170, 200, 100, 50, 30, 30);
			g.setColor(Color.BLUE);
			g.fillRect(50, 270, 100, 50);
			g.fillRoundRect(170, 270, 100, 50, 30, 30);			
			
			//���׸���			
			g.setColor(Color.RED);
			g.drawOval(300, 200, 50, 50);
			g.drawOval(370, 200, 80, 50);
			g.fillOval(300, 270, 50, 50);
			
			//ȣ �׸���
			g.drawArc(300, 100, 50, 50, 10, 145);
			g.fillArc(370, 100, 50, 50, 330, 180);			
			
			//�ٰ����׸���..
			g.setColor( new Color(0, 255, 255, 255) );
			int[] xPoints= new int[] {300, 310, 320, 330, 340, 350};
			int[] yPoints= new int[] {30, 40, 30, 40, 30, 40};			
			g.drawPolygon(xPoints, yPoints, xPoints.length);
			
			//������ �׸���..ȿ������
			g.fillRect(250, 80, 3, 80);	
			
			
			//�̹��� �׸���
			
			//�̹�����ü �����			
			g.drawImage(img, 100, 100, this);
			g.drawImage(img, 200, 100, this);
			
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex1();
	}

}
