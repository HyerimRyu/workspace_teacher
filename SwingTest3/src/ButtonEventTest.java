import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonEventTest extends JFrame{
	
	//멤버변수 : Field 
	JLabel label;
	JButton btn;
	
	
	public ButtonEventTest() {
		// TODO Auto-generated constructor stub
		setTitle("Button Click Event");
		setSize(500, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		
		
		JPanel panel= new JPanel();
		add(panel);
		
		panel.setLayout( new BoxLayout(panel, BoxLayout.Y_AXIS));//수직배치
		
		//JLabel label= new JLabel("Hello");//지역변수는 다른지역 사용불가!
		label= new JLabel("Hello");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btn= new JButton("button");
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel.add(label);
		panel.add(btn);	
		
		
		//버튼의 이벤트(click)를 듣는 리스너(스토커)객체 생성 및 버튼에 달기!!
		
		//리스너객체 생성
		//ActionListener이 인터페이스임. 사용하려면 새로운 클래스를 만들어서 구현(implements)해야함.		
		//ClickListenr listener= new ClickListenr();
		
		//새로운 클래스이름을 일일이 만드는 거 불편함..그래서..
		//이름이 없을 클래스를 설계하여 사용 : 익명클래스( Anonymous class)
		ActionListener listener= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				label.setText("익명 리스너로 바꿔봅니다!!!!");				
			}
		};
		
		btn.addActionListener(listener);
		
	}//생성자	
	
	//이너클래스 - 아웃터클래스만 이 클래스를 사용할 수 있음.
	class ClickListenr implements ActionListener{

		//버튼의 클릭이 발생하면 자동으로 실행되는 메소드 : 콜백메소드 
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//JLable에 써있는 글씨를 변경하기!!
			//지역변수는 다른 지역에서 사용불가!!
			label.setText("Nice to meet you.");			
			//System.out.println("aaaaa");			
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ButtonEventTest();
	}//main method
	
	
}//ButtonEventTest class..












