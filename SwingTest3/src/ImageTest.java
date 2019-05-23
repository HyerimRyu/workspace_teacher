import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageTest extends JFrame{
	
	int num=12;
	
	public ImageTest() {
		setTitle("Image Test");
		setSize(400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel= new JPanel();
		
		//�̹����� ǥ���Ϸ���.. �켱 �̹����� �����ټ��� ������Ʈ�� �־����.
		//swing���� ��� JLabel�� ��� �̿�.
		JLabel label= new JLabel();		
		ImageIcon icon= new ImageIcon("images/ms21.png"); //�̹��������� �ּ�..
		icon= new ImageIcon( icon.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH) );
		label.setIcon(icon);
		panel.add(label);
		
		JButton btn= new JButton("�̹��� ��ư");
		//��ư�� ������ �߰��ϱ�
		ImageIcon btnIcon= new ImageIcon("images/access.png");
		btn.setIcon(btnIcon);
		panel.add(btn);
		
		btn.addActionListener( new ActionListener() {
			//btn��ư�� Ŭ���Ǹ� �ڵ����� ����Ǵ� �޼ҵ� : �ݹ� �޼ҵ�
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�̹��� �����ϱ�
				num++;
				if(num>21) num=12;
				ImageIcon icon= new ImageIcon("images/ms"+num+".png");
				icon= new ImageIcon( icon.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH) );
				label.setIcon(icon);
			}
		});
		
		
		
		
		add(panel);
		setLocation(600, 100);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ImageTest();
	}
}





