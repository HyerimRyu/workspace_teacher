import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

public class Main extends JFrame {
	boolean isLogin = false;
	Login Lg;
	JButton MemberShip; //회원가입 버튼
	JButton Login;	// 로그인
	JButton GameStart; // 게임 시작
	JLabel Mainimg; //메인 이미지 담당
	Image imback;
	
	public Main() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		imback = toolkit.getImage("images/Home.jpg");
		imback = imback.getScaledInstance(460, 700, Image.SCALE_SMOOTH);
		
		//패널 생성
		JPanel mainpanel = new JPanel(new GridLayout(2,1)) {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(imback, 0, 0, this);
			}
		};
		JPanel panel1 = new JPanel(new BorderLayout());
		JPanel panel2 = new JPanel(null);
		
		//상단 레이블 
	
		JLabel label1 = new JLabel("스폰지밥 게임!");
		label1.setForeground(new Color(28, 28, 28, 250));
		label1.setFont(new Font("Serif", Font.BOLD, 20));
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setPreferredSize(new Dimension(200, 50));
		
		//메인 이미지 구현
		ImageIcon icon = new ImageIcon("images/BGM.gif");
		Mainimg = new JLabel(icon);

		//이너클래스 Btn의 생성자 호출 버튼 기능
		Btn btn = new Btn();
		
		//메인 백그라운 색상 조절
		panel1.setBackground(Color.WHITE);
		//레이블 위치 조정
		panel1.add(label1,BorderLayout.NORTH);
		//이미지 위치조정
		panel1.add(Mainimg,BorderLayout.CENTER);
		
		panel2.add(MemberShip);
		panel2.add(Login);
		panel2.add(GameStart);
		panel2.setBackground(Color.WHITE);
		
		mainpanel.add(panel1);
		mainpanel.add(panel2);
	
		add(mainpanel);
		
		setTitle("네모네모 스폰지밥");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(410, 140, 460, 700);
		setResizable(false);
		setVisible(true);
	
	}//Main의 생성자..
	public static void main(String[] args) {
		
		new Main();
		
	}//Main 메소드..	
	
	public class Btn extends JPanel{
		
		public Btn() {
			
			//버튼 생성
			MemberShip = new JButton("회원가입");
			Login = new JButton("로그인");
			GameStart = new JButton("Game Start");
			//글씨 색상 변경
			
			MemberShip.setForeground(Color.ORANGE);
			Login.setForeground(Color.BLUE);
			GameStart.setForeground(Color.RED);
			//버튼 글씨 변경
			MemberShip.setFont(new Font("Serif", Font.TYPE1_FONT, 13));
			Login.setFont(new Font("Serif", Font.TYPE1_FONT, 13));
			GameStart.setFont(new Font("Serif", Font.TYPE1_FONT, 13));
			//버튼 내용 역역 채우지 않기(투명)
			MemberShip.setContentAreaFilled(false);
			Login.setContentAreaFilled(false);
			GameStart.setContentAreaFilled(false);;
			//버튼 테두리 사용 안함(투명2)
			MemberShip.setBorderPainted(false);
			Login.setBorderPainted(false);
			GameStart.setBorderPainted(false);

			//버튼 포커스 선택 되었을때 생기는 테두리 사용 안함(투명3)
			MemberShip.setFocusPainted(false);
			Login.setFocusPainted(false);
			GameStart.setFocusPainted(false);

			//버튼 사이즈 조정
			MemberShip.setSize(100,50);
			Login.setSize(100,50);
			GameStart.setSize(100,50);
			//버튼 위치 조정
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
							JOptionPane.showMessageDialog(Main.this,"로그인하세요.");
						}
					}
				}); 
				
		}//Btn생성자..
	}//Btn클래스..	

}//Main 클래스..