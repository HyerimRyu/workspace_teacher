import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

public class TabbedPaneTest extends JFrame{
	
	public TabbedPaneTest() {
		// TODO Auto-generated constructor stub
		
		JTabbedPane tabbedPane= new JTabbedPane();
		
		//Tab1
		//Tab1화면을 가지고 있는 JPanel객체 생성
		Tab1 tab1= new Tab1();
		tabbedPane.addTab("GENDER", tab1);
		
		//Tab2
		Tab2 tab2= new Tab2();
		tabbedPane.addTab("IMAGE", tab2);
		
		add(tabbedPane, BorderLayout.CENTER);
		
		setTitle("Tab Test");
		setBounds(600,100, 350, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	//이너클래스
	//Tab1화면의 모양을 가지는 JPanel클래스설계
	class Tab1 extends JPanel{
		public Tab1() {
			// TODO Auto-generated constructor stub
			JLabel label= new JLabel("What you are Gender?");
			
			JRadioButton rb1= new JRadioButton("MALE");
			JRadioButton rb2= new JRadioButton("FEMALE");
			ButtonGroup rg= new ButtonGroup();
			rg.add(rb1);
			rg.add(rb2);
			
			//패널에 컴포넌트들 추가
			add(label);
			add(rb1);
			add(rb2);
			
			//라이오버튼을 선택하는 것을 듣는 리스너객체 추가
			rb1.addActionListener(listener);
			rb2.addActionListener(listener);
		}
		
		//Tab1클래스의 이너클래스 - 멤버변수
		ActionListener listener= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str= e.getActionCommand();//이벤트소스(라디오버튼)에 써있는 글씨 얻어오기
				
				//Dialog로 선택된 값을 사용자에게 알림.
				//Dialog는 new로 만들지 않고..
				//Dialog를 만들어주는 전용클래스가 존재함..
				//그 클래스의 static메소드들을 이용하면 Dialog를 보여줄 수 있음.
				JOptionPane.showMessageDialog(TabbedPaneTest.this, str+"를 선택했습니다.");
				//oracle사이트의 도움문서사이트를 보면 자세히 나옴.
				//http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
				
			}
		};
		
	}
	
	
	//Tab2화면의 모양을 가지는 JPanel클래스설계
	class Tab2 extends JPanel{
		public Tab2() {
			// TODO Auto-generated constructor stub
			ImageIcon icon= new ImageIcon("images/ms19.png");
			icon= new ImageIcon( icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
			JLabel imgLabel= new JLabel(icon);
			
			add(imgLabel);
		}
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TabbedPaneTest();
	}

}







