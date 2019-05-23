import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame= new JFrame("LayoutManager Test");
		frame.setBounds(500, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel= new JPanel();
		panel.setBackground(Color.BLUE);
		
		//������Ʈ��ġ(��缳��)�� ���� �߿��� ���� �ϴ� ��ġ������.(LayoutManager)
		
		//1. FlowLayout : ���� �ܼ��ϰ� ���ʷ� ������Ʈ ��ġ..���ٿ� ���̻� ������ ������ �ڵ� ������.. JPanel�� �⺻ ��ġ������
		//panel.setLayout( new FlowLayout() );
		
//		FlowLayout flowLayout= new FlowLayout();
//		//��ġ�������� ���� : ���İ� ��������
//		flowLayout.setAlignment(FlowLayout.LEFT);//�⺻�� : CENTER
//		//[LEADING == LEFT // TRAILING == RIGHT ]
//		flowLayout.setHgap(10); //���򰣰� : [�⺻�� : 5 ]
//		flowLayout.setVgap(20); //�������� : [�⺻�� : 5 ]
//		
//		//��ġ������ �Ųٷ�..
//		panel.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//		panel.setLayout(flowLayout);
//		
//		//FlowLayout�� �����ڷ� ������ ��������
//		panel.setLayout( new FlowLayout(FlowLayout.TRAILING, 10, 15) );
//				
//		//������Ʈ�� ������� ��ư���� ���빰(Content)�� ���������� ������� �ڵ�����
//		//���浵 �Ұ���!!
//		panel.add( new JButton("btn1") );
//		panel.add( new JButton("button1") );
//		panel.add( new JButton("�ѱ�") );
//		panel.add( new JButton("asdfasdfasdfasdfsadfasdf") );
//		panel.add( new JButton("btn2") );
//		panel.add( new JButton("btn3") );
//		panel.add( new JButton("btn4") );		
		
		//2. BorderLayout : ��, ��, ��, ��, ��� (5���� ����)�� ������Ʈ��ġ..
//		BorderLayout borderLayout= new BorderLayout();
//		//�����ֱ�
//		//set�޼ҵ��̿��ϱ�
//		borderLayout.setHgap(10);
//		borderLayout.setVgap(10);		
//		panel.setLayout(borderLayout);
//		//�����ڸ޼ҵ��̿�
//		panel.setLayout( new BorderLayout(10, 10) );
//		
//		panel.add( new JButton("btn1"), BorderLayout.NORTH );
//		panel.add( new JButton("btn2"), BorderLayout.SOUTH );
//		panel.add( new JButton("btn3"), BorderLayout.WEST );
//		panel.add( new JButton("btn4"), BorderLayout.EAST );
//		panel.add( new JButton("btn5"), BorderLayout.CENTER );
//		panel.add( new JButton("btn6"), BorderLayout.CENTER );//�����
//		panel.add(new JButton("btn7"));//��ġ���� ���ϸ� �ڵ� CENTER
//		
		
		//3. GridLayout : �յ��ϰ� ���� ������� ��ġ...
//		GridLayout gridLayout= new GridLayout(0, 3);//0�� �����ϸ� �ʿ��� ������ �ڵ� ���.
//		gridLayout.setHgap(10);
//		gridLayout.setVgap(10);
//		panel.setLayout(gridLayout);
//		
//		panel.add(new JButton("btn1"));
//		panel.add(new JButton("btn2"));
//		panel.add(new JButton("btn3"));
//		panel.add(new JButton("btn4"));
//		panel.add(new JButton("btn5"));
//		panel.add(new JButton("btn6"));
//		panel.add(new JButton("btn7"));//�������� ������?? row���� �켱
//		
			
		//4. BoxLayout : ���� �Ǵ� ���� �������� ������Ʈ ��ġ
//		BoxLayout boxLayout= new BoxLayout(panel, BoxLayout.Y_AXIS);//�������ġ
//		panel.setLayout(boxLayout);
//		
//		panel.add(new JButton("aaa"));
//		panel.add(new JButton("bbb"));
//		panel.add(new JButton("ccc"));
//		panel.add(new JButton("ddd"));
//		panel.add(new JButton("eee"));
//		panel.add(new JButton("ff"));
//		
//		//������ �Ϸ��� ������Ʈ�� ���ļ����ؾ���.
//		JButton btn1= new JButton("btn1");
//		btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
//		
//		JButton btn2= new JButton("asdfasdf");
//		btn1.setAlignmentX(Component.RIGHT_ALIGNMENT);
//		
//		
//		panel.add(btn1);
//		panel.add(btn2);
		
		
		//5. CardLayout : ���ļ� ��ġ
//		CardLayout cardLayout= new CardLayout();
//		panel.setLayout(cardLayout);
//		
//		panel.add(new JButton("aaa"),"1");
//		panel.add(new JButton("bbb"),"2");
//		panel.add(new JButton("ccc"),"3");
//		panel.add(new JButton("ddd"),"4");
//		
//		cardLayout.next(panel);
//		cardLayout.next(panel);
//		cardLayout.previous(panel);
//		cardLayout.first(panel);
//		cardLayout.last(panel);
//		cardLayout.show(panel, "3");
		
		//���� ����� ��ư���� �����ϱ�....		
		
		
		//6. ������ġ(Absolute) Layout : x, y ��ǥ������ ��ġ ����!
		panel.setLayout(null);
		
		JButton b1= new JButton("btn1");
		b1.setLocation(10, 20);
		b1.setSize(80, 30);
		panel.add(b1);
		
		JButton b2= new JButton("btn2");
		b2.setBounds(100, 20, 150, 30);
		panel.add(b2);
		frame.add(panel);		
		frame.setVisible(true);
		
		JButton b3= new JButton("btn3");		
		b3.setBounds(0, panel.getHeight()-30, 80, 30);
		panel.add(b3);
		//frame.setVisible(true);
		
		JButton b4= new JButton("btn4");		
		b4.setBounds(0, 0, 80, 30);
		panel.add(b4);
		
		
	}

}








