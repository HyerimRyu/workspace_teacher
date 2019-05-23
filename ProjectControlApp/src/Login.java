import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Login extends JFrame{
	Main mi;
	Menu Mu;
	MemberShip Mem;
	String IDt;
	String PWt;
	JTextField tfID;
	JTextField tfPassword;
	JButton btn1;
	JButton btn2;
	
	public Login(Main x) {
		mi = x;
		JPanel Mainpanel = new JPanel(new BorderLayout());
		JPanel panel1 = new JPanel(new FlowLayout());
		JPanel panel2 = new JPanel(new FlowLayout());
		
		JLabel label = new JLabel("ID");
		
		//텍스트필드 생성
		tfID = new JTextField(7);
		tfPassword = new JTextField(7);
		
		panel1.add(label,BorderLayout.WEST);
		panel1.add(tfID,BorderLayout.NORTH);
		
		label = new JLabel("Password");
		
		panel1.add(label);
		panel1.add(tfPassword);
		
		btn1 = new JButton("확인");
		btn2 = new JButton("취소");
		
		btn1.setForeground(Color.BLUE);
		btn2.setForeground(Color.RED);
		btn1.setContentAreaFilled(false);
		btn2.setContentAreaFilled(false);
		btn1.setFocusPainted(false);
		btn2.setFocusPainted(false);
		
		btn1.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			IDt = tfID.getText();
			PWt = tfPassword.getText();
			Menu m = null;
			 File f = new File("회원가입/"+IDt+".txt");
			 if (f.isFile()) {
			    }else {
			      System.out.println("없는 ID 입니다.");
			      JOptionPane.showMessageDialog(null,"없는 아이디입니다.");
			      return;
			    }
			 try {
				m = new Menu();
				if(IDt.equals(m.Member_Arr.get(0)[0])) {
			    	if(PWt.equals(m.Member_Arr.get(0)[1])) {
			    		JOptionPane.showMessageDialog(null,IDt+"님 환영합니다!!");
						
			    		setVisible(false);
						mi.isLogin = true;
			    	}else {
			    		System.out.println("Password를 확인하세요.");
			    		JOptionPane.showMessageDialog(null,"Password를 확인하세요");
			    	}
			    }else {
			    	System.out.println("ID를 확인하세요.");
			    	JOptionPane.showMessageDialog(null,"ID를 확인하세요");
			    }		
			} catch (IOException e) {
				
				e.printStackTrace();
			}		
		}
	});
	
	btn2.addActionListener(new ActionListener() {	
				
		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			setVisible(false);	
				
			}
		});
		
		panel2.add(btn1);
		panel2.add(btn2);
		
		Mainpanel.add(panel1,BorderLayout.NORTH);
		Mainpanel.add(panel2,BorderLayout.CENTER);
		add(Mainpanel);
		setTitle("Login");
		setBounds(490, 300, 300, 300);
		setResizable(false);
		setVisible(true);
		
	}
	class Menu {
		
		BufferedReader Member_in = null; // 읽기
		ArrayList<String[]> Member_Arr; // 정보
		
	public Menu() throws IOException{
		
		Member_in = new BufferedReader(new FileReader("회원가입/"+IDt+".txt")); //fileReader를 BufferedReader에			 
		//멤버 정보를 배열로 담을 공간 생성
		Member_Arr = new ArrayList<String[]>();
			

		//파일 읽기
		String s;
		while((s = Member_in.readLine())!=null){
			//System.out.println(" "+s); //줄바꿈 문자를 제외하고 한줄씩 출력
			Member_Arr.add(s.split("\t"));
			
			}
		}
	} //Menu class..
}//JFrame..
