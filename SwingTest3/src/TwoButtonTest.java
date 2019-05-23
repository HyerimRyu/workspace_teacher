import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TwoButtonTest extends JFrame{
	
	JLabel label;
	JButton btn1, btn2;
	
	public TwoButtonTest() {
		// TODO Auto-generated constructor stub
		setTitle("Two Button Event Test");
		setBounds(100, 100, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel= new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);
		
		label= new JLabel("This is Label....");
		label.setForeground(Color.RED);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setPreferredSize(new Dimension(200, 50));
		panel.add(label, BorderLayout.NORTH);
		
		JPanel btnPanel= new JPanel();
		btnPanel.setLayout( new FlowLayout() );		
		
		btn1= new JButton("btn1");
		btn2= new JButton("btn2");
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		
		panel.add(btnPanel, BorderLayout.CENTER);
		
		//버튼에 리스너 붙이기!!
//		btn1.addActionListener(  new ActionListener() {
//			//버튼1을 누르면  자동으로 실행되는 메소드 : call back method..
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				label.setText("Hello world!");			
//			}		
//		});
//		
//		btn2.addActionListener( new ActionListener() {
//			//버튼2을 누르면  자동으로 실행되는 메소드 : call back method..
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				label.setText("Nice to meet you.");				
//			}
//		} );
		
		
		//버튼들에 리스너객체 1개 붙여서 공유하기
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);		
		
		setVisible(true);		
	}
	
	//클래스 안에 멤버변수(리스너객체)
	ActionListener listener= new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			//어떤 버튼이 눌러졌는지 알아야..버튼마다 다른 명령실행 가능..
			
			//파라미터로 전달된..ActionEvent(이벤트의 정보를 가진)객체에게
			//이벤트를 발생시킨 객체가 누구인지?? 알아옵니다.
			Object obj= event.getSource();//리턴값 : 버튼들의 참조주소가 옴.
			if( obj instanceof JButton) {
				//버튼에 써있는 글씨 얻어오기..
				JButton btn= (JButton)obj;
				String s= btn.getText();
				
				if( s.equals("btn1")  ) {
					
					label.setText("Hello world");
					
				}else if( s.equals("btn2") ) {
					
					label.setText("Nice to meet you");
					
				}
				
				
			}
			
			
			
			
			
			
		}
	};
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TwoButtonTest();
	}

}






