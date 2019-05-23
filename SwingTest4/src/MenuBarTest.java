import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class MenuBarTest extends JFrame{
	
	JTextField tf;
	
	public MenuBarTest() {
		// TODO Auto-generated constructor stub
		
		//�޴��� ����
		JMenuBar menuBar= new JMenuBar();
		
		//�޴� ����
		JMenu menu1= new JMenu("File");
		JMenu menu2= new JMenu("Edit");
		
		//����޴� ����
		JMenuItem menuItem= null;
		
		//�޴�1("File")�� ����޴� ���� �� �߰� , �޴����ø����� �߰�
		menuItem= new JMenuItem("New");
		menuItem.addActionListener(menuItemListener);
		menuItem.setToolTipText("���θ���⸦ �մϴ�.");
		menu1.add(menuItem);
		
		//����Ű����
		menuItem= new JMenuItem("Opon", KeyEvent.VK_O);//O�� ���� �� Ű�̺�Ʈ ���--> OŰ�� ������ �ڵ� ����!!
		menuItem.addActionListener(menuItemListener);
		menu1.add(menuItem);
		
		//������ �߰�
		menuItem= new JMenuItem("Save");
		menuItem.setIcon(new ImageIcon("images/save-alt.png"));		
		menuItem.addActionListener(menuItemListener);
		menu1.add(menuItem);
		
		//���� �޴��� ������ �޴�������
		JMenu subMenu= new JMenu("sub menu");
		
		menuItem= new JMenuItem("sub1");
		menuItem.addActionListener(menuItemListener);
		subMenu.add(menuItem);
		
		menuItem= new JMenuItem("sub2");
		menuItem.addActionListener(menuItemListener);
		subMenu.add(menuItem);
		
		menu1.add(subMenu);
		
		
		//Menu2("Edit")�� ����޴��� �����
		JCheckBoxMenuItem checkBoxMenuItem= new JCheckBoxMenuItem("Ruler");
		checkBoxMenuItem.addActionListener(menuItemListener);
		checkBoxMenuItem.setToolTipText("�����ڸ� ���̰� ��");
		menu2.add(checkBoxMenuItem);
		
		//���м� �߰�
		menu2.addSeparator();		
		
		JRadioButtonMenuItem radioButtonMenuItem= new JRadioButtonMenuItem("Ediable");
		radioButtonMenuItem.addActionListener(menuItemListener);
		menu2.add(radioButtonMenuItem);
				
		
		
		
		//�޴��ٿ� �޴��߰�
		menuBar.add(menu1);
		menuBar.add(menu2);		
		
		//JFrame�� �޴��� ����
		setJMenuBar(menuBar);
		
		
		//�޴� ���ý��� ��� ��¿� JTextField
		tf= new JTextField();
		tf.setToolTipText("����� ��µǴ� �����Դϴ�.");
		add(tf, BorderLayout.SOUTH);
		
		
		setTitle("menu test");
		setBounds(600, 100, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
	}
	
	
	//�޴�������(����޴�) Ŭ�� ������....
	ActionListener menuItemListener= new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tf.setText( e.getActionCommand()+"�� �����߽��ϴ�." );			
		}
	};
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuBarTest();
	}

}
