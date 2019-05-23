import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

public class Main extends JFrame {
	boolean isLogin = false;
	Login Lg;
	JButton MemberShip; //ȸ������ ��ư
	JButton Login;	// �α���
	JButton GameStart; // ���� ����
	JLabel Mainimg; //���� �̹��� ���
	Image imback;
	
	public Main() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		imback = toolkit.getImage("images/Home.jpg");
		imback = imback.getScaledInstance(460, 700, Image.SCALE_SMOOTH);
		
		//�г� ����
		JPanel mainpanel = new JPanel(new GridLayout(2,1)) {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(imback, 0, 0, this);
			}
		};
		JPanel panel1 = new JPanel(new BorderLayout());
		JPanel panel2 = new JPanel(null);
		
		//��� ���̺� 
	
		JLabel label1 = new JLabel("�������� ����!");
		label1.setForeground(new Color(28, 28, 28, 250));
		label1.setFont(new Font("Serif", Font.BOLD, 20));
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setPreferredSize(new Dimension(200, 50));
		
		//���� �̹��� ����
		ImageIcon icon = new ImageIcon("images/BGM.gif");
		Mainimg = new JLabel(icon);

		//�̳�Ŭ���� Btn�� ������ ȣ�� ��ư ���
		Btn btn = new Btn();
		
		//���� ��׶�� ���� ����
		panel1.setBackground(Color.WHITE);
		//���̺� ��ġ ����
		panel1.add(label1,BorderLayout.NORTH);
		//�̹��� ��ġ����
		panel1.add(Mainimg,BorderLayout.CENTER);
		
		panel2.add(MemberShip);
		panel2.add(Login);
		panel2.add(GameStart);
		panel2.setBackground(Color.WHITE);
		
		mainpanel.add(panel1);
		mainpanel.add(panel2);
	
		add(mainpanel);
		
		setTitle("�׸�׸� ��������");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(410, 140, 460, 700);
		setResizable(false);
		setVisible(true);
	
	}//Main�� ������..
	public static void main(String[] args) {
		
		new Main();
		
	}//Main �޼ҵ�..	
	
	public class Btn extends JPanel{
		
		public Btn() {
			
			//��ư ����
			MemberShip = new JButton("ȸ������");
			Login = new JButton("�α���");
			GameStart = new JButton("Game Start");
			//�۾� ���� ����
			
			MemberShip.setForeground(Color.ORANGE);
			Login.setForeground(Color.BLUE);
			GameStart.setForeground(Color.RED);
			//��ư �۾� ����
			MemberShip.setFont(new Font("Serif", Font.TYPE1_FONT, 13));
			Login.setFont(new Font("Serif", Font.TYPE1_FONT, 13));
			GameStart.setFont(new Font("Serif", Font.TYPE1_FONT, 13));
			//��ư ���� ���� ä���� �ʱ�(����)
			MemberShip.setContentAreaFilled(false);
			Login.setContentAreaFilled(false);
			GameStart.setContentAreaFilled(false);;
			//��ư �׵θ� ��� ����(����2)
			MemberShip.setBorderPainted(false);
			Login.setBorderPainted(false);
			GameStart.setBorderPainted(false);

			//��ư ��Ŀ�� ���� �Ǿ����� ����� �׵θ� ��� ����(����3)
			MemberShip.setFocusPainted(false);
			Login.setFocusPainted(false);
			GameStart.setFocusPainted(false);

			//��ư ������ ����
			MemberShip.setSize(100,50);
			Login.setSize(100,50);
			GameStart.setSize(100,50);
			//��ư ��ġ ����
			MemberShip.setLocation(170, 40);
			Login.setLocation(170, 100);
			GameStart.setLocation(170, 160);

			MemberShip.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {

					new MemberShip();
				}
			});
			Login.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {

				new Login(Main.this);
				}
			});
				
			GameStart.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {

						if(isLogin)	new GameFrame();
						else {
							JOptionPane.showMessageDialog(Main.this,"�α����ϼ���.");
						}
					}
				}); 
				
		}//Btn������..
	}//BtnŬ����..	

}//Main Ŭ����..