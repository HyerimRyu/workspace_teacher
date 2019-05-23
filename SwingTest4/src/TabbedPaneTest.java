import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

public class TabbedPaneTest extends JFrame{
	
	public TabbedPaneTest() {
		// TODO Auto-generated constructor stub
		
		JTabbedPane tabbedPane= new JTabbedPane();
		
		//Tab1
		//Tab1ȭ���� ������ �ִ� JPanel��ü ����
		Tab1 tab1= new Tab1();
		tabbedPane.addTab("GENDER", tab1);
		
		//Tab2
		Tab2 tab2= new Tab2();
		tabbedPane.addTab("IMAGE", tab2);
		
		add(tabbedPane, BorderLayout.CENTER);
		
		setTitle("Tab Test");
		setBounds(600,100, 350, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	//�̳�Ŭ����
	//Tab1ȭ���� ����� ������ JPanelŬ��������
	class Tab1 extends JPanel{
		public Tab1() {
			// TODO Auto-generated constructor stub
			JLabel label= new JLabel("What you are Gender?");
			
			JRadioButton rb1= new JRadioButton("MALE");
			JRadioButton rb2= new JRadioButton("FEMALE");
			ButtonGroup rg= new ButtonGroup();
			rg.add(rb1);
			rg.add(rb2);
			
			//�гο� ������Ʈ�� �߰�
			add(label);
			add(rb1);
			add(rb2);
			
			//���̿���ư�� �����ϴ� ���� ��� �����ʰ�ü �߰�
			rb1.addActionListener(listener);
			rb2.addActionListener(listener);
		}
		
		//Tab1Ŭ������ �̳�Ŭ���� - �������
		ActionListener listener= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str= e.getActionCommand();//�̺�Ʈ�ҽ�(������ư)�� ���ִ� �۾� ������
				
				//Dialog�� ���õ� ���� ����ڿ��� �˸�.
				//Dialog�� new�� ������ �ʰ�..
				//Dialog�� ������ִ� ����Ŭ������ ������..
				//�� Ŭ������ static�޼ҵ���� �̿��ϸ� Dialog�� ������ �� ����.
				JOptionPane.showMessageDialog(TabbedPaneTest.this, str+"�� �����߽��ϴ�.");
				//oracle����Ʈ�� ���򹮼�����Ʈ�� ���� �ڼ��� ����.
				//http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
				
			}
		};
		
	}
	
	
	//Tab2ȭ���� ����� ������ JPanelŬ��������
	class Tab2 extends JPanel{
		public Tab2() {
			// TODO Auto-generated constructor stub
			ImageIcon icon= new ImageIcon("images/ms19.png");
			icon= new ImageIcon( icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
			JLabel imgLabel= new JLabel(icon);
			
			add(imgLabel);
		}
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TabbedPaneTest();
	}

}







