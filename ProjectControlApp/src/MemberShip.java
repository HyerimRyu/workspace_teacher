import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class MemberShip extends JFrame{
	
	boolean Membercheck = false;
	JPanel Mainpanel;
	String t; //txt1의 값
	String t1;//txt2의 값 
	JButton IDok;
	JButton PSok;
	JButton bt1;
	JButton bt2;
	TextField txt1;
	TextField txt2;

	JLabel Membershipimg; //스폰지송
	JLabel Membershipimg1; //깐깐찡어
//	JLabel Membershipimg2; //별가
	
	Image img;
	
	//텍스트 생성
		
	public MemberShip() {
		
		new Img();
		
		//레이아웃 생성해서 택스트를 왼쪽으로 보내주기위해 값을 넣음
		Mainpanel = new JPanel(new BorderLayout());
		
		FlowLayout layout1 = new FlowLayout(FlowLayout.LEFT);
		
		//큰 툴
		
		JPanel Onekingpanel = new JPanel(new GridLayout(0, 2));
		
		JPanel panelex1 = new JPanel(new BorderLayout());
		JPanel panelex2 = new JPanel(new BorderLayout());
		JPanel panelID = new JPanel(new BorderLayout());
		JPanel panelPS = new JPanel(new BorderLayout());
		JPanel panelbt = new JPanel();
		
		//panel1의 레이블
		JPanel panelex1lb = new JPanel();
		JPanel panelex2lb = new JPanel();

		//panel1 텍스트 필드
		JPanel panelex1tf = new JPanel();
		JPanel panelex2tf = new JPanel();
		
		//텍스트 필드 생성
		txt1 = new TextField(10);
		txt2 = new TextField(10);
		
		
		bt1 = new JButton("완료");
		bt2 = new JButton("취소");
		bt1.setForeground(Color.BLUE);
		bt2.setForeground(Color.RED);
		bt1.setContentAreaFilled(false);
		bt2.setContentAreaFilled(false);
		bt1.setFocusPainted(false);
		bt2.setFocusPainted(false);
		
		PSok = new JButton("비밀번호 확인");
		PSok.setContentAreaFilled(false);
		PSok.setForeground(Color.RED);
		PSok.setFocusPainted(false);
		PSok.setBorderPainted(false);
		
		IDok = new JButton("아이디 확인");
		IDok.setContentAreaFilled(false);
		IDok.setForeground(Color.RED);
		IDok.setFocusPainted(false);
		IDok.setBorderPainted(false);
		
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

		t= txt1.getText();
				
		File f = new File("회원가입/"+t+".txt");

	if (f.isFile()) {
		JOptionPane.showMessageDialog(Mainpanel, " 아이디가 중복되었습니다.");

		}
		else {
		if(txt1.getText().length() > 10 ) {
			IDok.setForeground(Color.RED);
			JOptionPane.showMessageDialog(Mainpanel, "아이디를 10글자 미만으로 입력하세요.");
		return;
		}
		if(txt1.getText().length() <= 0) {
			IDok.setForeground(Color.RED);
			JOptionPane.showMessageDialog(Mainpanel, "아이디를 입력하세요.");
			return;
			} 	
		for(int i=0; i < txt1.getText().length(); i++) {
							
			if((txt1.getText().charAt(i) >= 'A' && txt1.getText().charAt(i) <= 'Z')){
					IDok.setForeground(Color.GREEN);
			}else if((txt1.getText().charAt(i) >= 'a' && txt1.getText().charAt(i) <= 'z')){	
					IDok.setForeground(Color.GREEN);
			}else if((txt1.getText().charAt(i) >= '0' && txt1.getText().charAt(i) <= '9')){  
					IDok.setForeground(Color.GREEN);
			}else {
					JOptionPane.showMessageDialog(Mainpanel, "아이디를 확인하세요.");
					PSok.setForeground(Color.RED);
					return;
					}
			if (i == txt1.getText().length() - 1) {
				try {
					new Menu();
				} catch (IOException e) {}
					setVisible(false);
					JOptionPane.showMessageDialog(Mainpanel, t +" 회원가입을 축하합니다!!.");
					IDok.setForeground(Color.GREEN);
					}		
				}
			}		
		}
	});//bt1.Ac...
		
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		panelbt.add(bt1);
		panelbt.add(bt2);
		panelID.add(IDok,BorderLayout.WEST);
		panelPS.add(PSok,BorderLayout.WEST);
	
		JLabel label1 = new JLabel("<html>&nbsp;1. 아이디를 입력하세요" + "<br>" + "(1~10자의 영문 대 소문자 숫자)</html>");
		label1.setFont(new Font("Serif", Font.TYPE1_FONT, 11));
		panelex1tf.setLayout(layout1);
		panelex1tf.add(txt1);
		
		panelex1.add(label1, BorderLayout.CENTER);
		panelex1.add(panelex1tf, BorderLayout.SOUTH);
		
		JLabel label2 = new JLabel("<html>&nbsp;2. 비밀번호를 입력하세요" +"<br>"+"(1~10자 영문 대 소문자 숫자"+"<br>"+"특수문자를 입력해주세요)</html>");
		label2.setFont(new Font("Serif", Font.TYPE1_FONT, 11));
		panelex2tf.setLayout(layout1);
		panelex2tf.add(txt2);
		panelex2.add(label2, BorderLayout.CENTER);
		panelex2.add(panelex2tf, BorderLayout.SOUTH);
		
		Onekingpanel.add(panelex1);
		Onekingpanel.add(panelID); //아이디확인 버튼
		Onekingpanel.add(panelex2);
		Onekingpanel.add(panelPS);// 비밀번호 확인 버튼
		
		Onekingpanel.add(Membershipimg,BorderLayout.CENTER);
		Onekingpanel.add(Membershipimg1,BorderLayout.CENTER);

		Mainpanel.add(Onekingpanel,BorderLayout.CENTER);
		Mainpanel.add(panelbt,BorderLayout.SOUTH);
		Mainpanel.add(Onekingpanel);
		add(Mainpanel,BorderLayout.CENTER);
		setTitle("회원가입");
		setBounds(465, 300, 360, 400);
		setResizable(false);
		setVisible(true);
	
		IDok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				t= txt1.getText();
					 File f = new File("회원가입/"+t+".txt");
					 checkPS();	
				if (f.isFile()) {JOptionPane.showMessageDialog(Mainpanel, " 아이디가 중복되었습니다.");}
				else {
				if(txt1.getText().length() > 10 ) {
					IDok.setForeground(Color.RED);
					JOptionPane.showMessageDialog(Mainpanel, "아이디는 10글자 미만");
					return;
				}
				if(txt1.getText().length() <= 0) {
					  IDok.setForeground(Color.RED);
					  JOptionPane.showMessageDialog(Mainpanel, "아이디를 입력하세요.");
					  return;
					} 	
					for(int i=0; i < txt1.getText().length(); i++) {
					
					if((txt1.getText().charAt(i) >= 'A' && txt1.getText().charAt(i) <= 'Z')){
						IDok.setForeground(Color.GREEN);
					}else if((txt1.getText().charAt(i) >= 'a' && txt1.getText().charAt(i) <= 'z')){	
						IDok.setForeground(Color.GREEN);
					}else if((txt1.getText().charAt(i) >= '0' && txt1.getText().charAt(i) <= '9')){  
						IDok.setForeground(Color.GREEN);
					}else {
						JOptionPane.showMessageDialog(Mainpanel, "아이디를 확인하세요.");
						IDok.setForeground(Color.RED);
						return;
					}
				if (i == txt1.getText().length() - 1) {
					Membercheck = true;
					JOptionPane.showMessageDialog(Mainpanel, "사용 가능한 아이디 입니다.");
					IDok.setForeground(Color.GREEN);
					
					}
				}
			}
		}
		
				//체크id		
	});
			
		PSok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
				t1 = txt2.getText();
				checkPS();
			}
		});		
	}
	
	public void checkPS() {
		
		if(txt2.getText().length() > 10) {
			PSok.setForeground(Color.RED);
			JOptionPane.showMessageDialog(Mainpanel, "비밀번호는 10글자 미만");
			return;
		}
		  if(txt2.getText().length() <= 0) {
			  PSok.setForeground(Color.RED);
	          JOptionPane.showMessageDialog(Mainpanel, "비밀번호를 입력하세요.");
	          return;
	       }
		for(int i=0; i < txt2.getText().length(); i++) {
			
			if((txt2.getText().charAt(i) >= 'A' && txt2.getText().charAt(i) <= 'Z')){	
			}
			else if((txt2.getText().charAt(i) >= 'a' && txt2.getText().charAt(i) <= 'z')){
				
			}else if((txt2.getText().charAt(i) >= '0' && txt2.getText().charAt(i) <= '9')){  
			
			}else if((txt2.getText().charAt(i) >= '!' && txt2.getText().charAt(i) <= '@')){
				
			}else {
				PSok.setForeground(Color.RED);
				JOptionPane.showMessageDialog(Mainpanel, "비밀번호를 확인하세요.");
				break;
			}
			if (i == txt2.getText().length() - 1) {
				Membercheck = true;
				JOptionPane.showMessageDialog(Mainpanel, "사용 가능한 비밀번호 입니다.");
				PSok.setForeground(Color.GREEN);
			}
		}	
	}//checkPS 끝 부분..	
	
	public class Img{
		public Img() {
			
			ImageIcon icon = new ImageIcon("images/SPJ.gif");
			Membershipimg = new JLabel(icon);
			
			ImageIcon icon1 = new ImageIcon("images/GG.gif");
			Membershipimg1 = new JLabel(icon1);	
		}
	}
	class Menu {
		
		String Mid;
		String Mpw;
		
		BufferedReader Member_in = null; // 읽기
		FileWriter Member_out = null; // 쓰기
		ArrayList<String[]> Member_Arr; // 정보

		
		public Menu() throws IOException{
			
//			Member_out = new FileWriter("회원가입/Member.txt", true); //파일 쓰기!! Member.txt파일이 없으면 생성
			Member_out = new FileWriter("회원가입/"+t+".txt");	 // true -> 기존에 있는 파일에 내용 덧붙이기
			Member_out.write(t + "\t" + t1); //파일쓰기 !! id pw 문자열로 저장됨
			Member_out.append("\t"); 
			Member_out.flush();
	
			Member_in = new BufferedReader(new FileReader("회원가입/"+t+".txt")); //fileReader를 BufferedReader에
		
			//멤버 정보를 배열로 담을 공간 생성
			Member_Arr = new ArrayList<String[]>();
	
			//파일 읽기
			String s;
			while((s = Member_in.readLine())!=null){
				
				Member_Arr.add(s.split("\t"));	
			}
		}	
	}
}//JFrame 끝..
