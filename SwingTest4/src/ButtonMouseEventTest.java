import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonMouseEventTest extends JFrame{
	
	public ButtonMouseEventTest() {
		// TODO Auto-generated constructor stub
		
		//평상시 버튼의 이미지
		JButton btn= new JButton(new ImageIcon("images/ms18.png"));
		
		//마우스가 버튼에 올라갔을 때의 이미지설정
		btn.setRolloverIcon(new ImageIcon("images/ms19.png"));
		
		//마우스가 버튼을 클릭했을 대의 이미지설정
		btn.setPressedIcon(new ImageIcon("images/ms20.png"));
		
		//버튼에 대한 설정들..		
		btn.setContentAreaFilled(false);//배경색 채우기 없음.
		btn.setFocusPainted(false);//포커스를 표시하는 네모난 사각형 안보이도록.
		btn.setBorderPainted(false);//버튼의 경계선 안보이게..
		
		JPanel panel= new JPanel();
		panel.setBackground(Color.GREEN);
		panel.add(btn);
		
		add(panel, BorderLayout.CENTER);
		
		
		setTitle("Button Mouse Event Test");
		setLocation(300, 100);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ButtonMouseEventTest();
	}

}
