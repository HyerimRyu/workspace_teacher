import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. �ֻ��� �����̳� ����
		JFrame frame= new JFrame("Swing GUI");
		frame.setSize(500, 400);
		
		//2. ������Ʈ�� �߰��ϱ�
		
		JButton b1= new JButton("btn1");
		JButton b2= new JButton("button2");
		
		//�⺻������ JFrame�� BorderLayout�̶�� ��ġ�����ڷ� �Ǿ� ����.
		//���� ���� ���̾ƿ��Ŵ����� FlowLayout���� ����
		frame.setLayout(  new FlowLayout() );		
		
		//�����̳ʿ� ������Ʈ �߰�
		frame.add(b1);
		frame.add(b2);
		
		
		//JLabel - Ŭ�������ִ� ������Ʈ
		JLabel label= new JLabel("This is Label");
		//label.setSize(50, 10); //FlowLayout�ȿ����� ���������� �ȵ�!
		frame.add(label);
		
		//JTextField - ����ڷκ��� �۾� �Է¹޴� ������Ʈ
		JTextField tf= new JTextField(20);//�ּ� 20���� ������..�̻� ����.
		frame.add(tf);
		
		
		//�̹��� - �̹����� ������Ʈ ����..
		//JLabel�� �̹���(������)�� ������ �� �ִ� �ɷ��� ����. �̸� Ȱ��!!
		
		//�̹��� �����ܰ�ü ����
		ImageIcon icon= new ImageIcon("images/ms16.png");
		//�̹����� ������ ������ �ִ� Image��ü�� �̾ƿ���!!
		Image im= icon.getImage();
		//�̾ƿ� �̹�����ü�� ����� ���Ӱ� �����!
		Image im2= im.getScaledInstance(280, 280, Image.SCALE_DEFAULT);
		//���� ������ �������� �̹���(im2)�� ������ ImageIcon��ü�� �ٽ� ����
		ImageIcon icon2= new ImageIcon(im2);		
		
//		JLabel img= new JLabel();
//		img.setIcon(icon);
		JLabel img= new JLabel(icon2);
		frame.add(img);	
		
		
		
		//swing�� frameâ�� x��ư ������ �ڵ����� ��������� ���α׷��� ������� ����.
		//x��ư ������ ���α׷��� ���� ����ǵ��� ����!
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(300, 200);//�������� �»�� ��ġ.
		//ȭ�鿡 ���̱�
		//frame.pack();
		frame.setVisible(true);
	}

}









