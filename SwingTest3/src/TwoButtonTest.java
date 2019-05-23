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
		
		//��ư�� ������ ���̱�!!
//		btn1.addActionListener(  new ActionListener() {
//			//��ư1�� ������  �ڵ����� ����Ǵ� �޼ҵ� : call back method..
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				label.setText("Hello world!");			
//			}		
//		});
//		
//		btn2.addActionListener( new ActionListener() {
//			//��ư2�� ������  �ڵ����� ����Ǵ� �޼ҵ� : call back method..
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				label.setText("Nice to meet you.");				
//			}
//		} );
		
		
		//��ư�鿡 �����ʰ�ü 1�� �ٿ��� �����ϱ�
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);		
		
		setVisible(true);		
	}
	
	//Ŭ���� �ȿ� �������(�����ʰ�ü)
	ActionListener listener= new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			//� ��ư�� ���������� �˾ƾ�..��ư���� �ٸ� ��ɽ��� ����..
			
			//�Ķ���ͷ� ���޵�..ActionEvent(�̺�Ʈ�� ������ ����)��ü����
			//�̺�Ʈ�� �߻���Ų ��ü�� ��������?? �˾ƿɴϴ�.
			Object obj= event.getSource();//���ϰ� : ��ư���� �����ּҰ� ��.
			if( obj instanceof JButton) {
				//��ư�� ���ִ� �۾� ������..
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






