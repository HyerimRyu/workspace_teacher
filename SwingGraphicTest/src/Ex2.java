import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex2 extends JFrame{
	
	public Ex2() {
		// TODO Auto-generated constructor stub
		
		MyPanel panel= new MyPanel(this);
		
		//버튼,,
		JButton btn= new JButton("Hello");
		
		panel.add(btn);
		
		add(panel, BorderLayout.CENTER);
		
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex2();
	}

}



class MyPanel extends JPanel{
	
	//멤버변수
	Image img;
	
	JFrame frame;
	
	public MyPanel(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame= frame;
		//이미지 만들기
		Toolkit toolkit= Toolkit.getDefaultToolkit();
		img= toolkit.getImage("images/Penguins.jpg");
	}
	
	//패널이 화면에 보여질때 자동으로 실행되는 메소드
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		//이미지 그리기
		g.drawImage(img, 0, 0, this);
		
		
		
	}
}













