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
		
		//��ư,,
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
	
	//�������
	Image img;
	
	JFrame frame;
	
	public MyPanel(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame= frame;
		//�̹��� �����
		Toolkit toolkit= Toolkit.getDefaultToolkit();
		img= toolkit.getImage("images/Penguins.jpg");
	}
	
	//�г��� ȭ�鿡 �������� �ڵ����� ����Ǵ� �޼ҵ�
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		//�̹��� �׸���
		g.drawImage(img, 0, 0, this);
		
		
		
	}
}













