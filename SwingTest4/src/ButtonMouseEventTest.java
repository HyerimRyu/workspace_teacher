import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonMouseEventTest extends JFrame{
	
	public ButtonMouseEventTest() {
		// TODO Auto-generated constructor stub
		
		//���� ��ư�� �̹���
		JButton btn= new JButton(new ImageIcon("images/ms18.png"));
		
		//���콺�� ��ư�� �ö��� ���� �̹�������
		btn.setRolloverIcon(new ImageIcon("images/ms19.png"));
		
		//���콺�� ��ư�� Ŭ������ ���� �̹�������
		btn.setPressedIcon(new ImageIcon("images/ms20.png"));
		
		//��ư�� ���� ������..		
		btn.setContentAreaFilled(false);//���� ä��� ����.
		btn.setFocusPainted(false);//��Ŀ���� ǥ���ϴ� �׸� �簢�� �Ⱥ��̵���.
		btn.setBorderPainted(false);//��ư�� ��輱 �Ⱥ��̰�..
		
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
