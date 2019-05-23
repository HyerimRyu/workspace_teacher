import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Exit extends JFrame{
	JPanel p;
	JPanel p2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	TextField tf1;
	TextField tf2;
	TextField tf3;
	TextField tf4;
	JButton btn1;
	JButton btn2;
	String id;
	String name;
	String bir;
	String pw;
	
	
	public Exit() {
		
		
		p=new JPanel();
		p2=new JPanel();
		label3=new JLabel("아이디");
		tf1=new TextField(20);
		
		label4=new JLabel("비밀번호");
		tf2=new TextField(20);
		tf2.setEchoChar('*');
		
		label6=new JLabel("이름");
		tf4=new TextField(20);
		
		label5=new JLabel("생년월일");
		tf3=new TextField(20);
		

		

		
		
		
		btn1=new JButton("확인");
		btn1.addActionListener(new ActionListener() {
			Menu m = null;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				id=tf1.getText();
				name=tf4.getText();
				bir=tf3.getText();
				pw=tf2.getText();
				try {
					m = new Menu();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(id.equals(m.member_arr.get(0)[0])) {
					 if(pw.equals(m.member_arr.get(0)[1])){
						 if(name.equals(m.member_arr.get(0)[2])) {
							 if(bir.equals(m.member_arr.get(0)[4])) {
								 File file = new File("D:\\java\\workspace\\Membership\\Member\\"+id+".txt");
								 if( file.exists() ){
							            if(file.delete()){
							            	JOptionPane.showMessageDialog(tf1, "탈퇴 되었습니다.\n 이용해주셔서 감사합니다");
							            }else{
							            	JOptionPane.showMessageDialog(tf1, "이미 탈퇴되었거나 존재하지 않는 회원입니다.");
							            }
							        }
							 }else {
								 JOptionPane.showMessageDialog(tf3,"생년월일을 확인해주세요.");
							 }
						 }else
							 JOptionPane.showMessageDialog(tf3,"이름을 확인해주세요.");
					 }else {
						 JOptionPane.showMessageDialog(tf2,"비밀번호를 확인해주세요.");
					 }
				 }else {
					 JOptionPane.showMessageDialog(tf3,"아이디를 확인해주세요.");
					 System.out.println(id+name+bir);
					 System.out.println(m.member_arr.get(0)[0]);
				 }
				
			}
		});
		btn2=new JButton("취소");
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		p2.add(label3);
		p2.add(tf1);
		p2.add(label4);
		p2.add(tf2);
		p2.add(label6);
		p2.add(tf4);
		p2.add(label5);
		p2.add(tf3);
		p2.setLayout(new GridLayout(0, 2));
		
		p.add(btn1);
		p.add(btn2);
		
		
		add(p2,BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);
		
		setTitle("토게느 피하기 회원 탈퇴");
		setBounds(100, 200, 400, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	class Menu{
	BufferedReader Member_in=null;//멤버읽기

	ArrayList<String[]>member_arr;//멤버 정보를 배열로 담을 공간
	
	public Menu() throws IOException{
			
		Member_in=new BufferedReader(new FileReader("D:\\java\\workspace\\Membership\\Member\\"+id+".txt"));//FileReader를 BufferedReader에 담아서  한줄씩 저장하게 해줌
		//멤버정보를 배열로 담을공간생성
		
		member_arr=new ArrayList<String[]>();
		String s;
		while((s=Member_in.readLine())!=null){
			System.out.println(""+s);//줄바꿈 문자를 제외하고 한줄씩 출력
			member_arr.add(s.split("\t"));
		}
		
	
	}
	
}
	
}