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
		
		//메뉴바 생성
		JMenuBar menuBar= new JMenuBar();
		
		//메뉴 생성
		JMenu menu1= new JMenu("File");
		JMenu menu2= new JMenu("Edit");
		
		//서브메뉴 생성
		JMenuItem menuItem= null;
		
		//메뉴1("File")의 서브메뉴 생성 및 추가 , 메뉴선택리스너 추가
		menuItem= new JMenuItem("New");
		menuItem.addActionListener(menuItemListener);
		menuItem.setToolTipText("새로만들기를 합니다.");
		menu1.add(menuItem);
		
		//단축키지정
		menuItem= new JMenuItem("Opon", KeyEvent.VK_O);//O에 및줄 및 키이벤트 등록--> O키를 누르면 자동 선택!!
		menuItem.addActionListener(menuItemListener);
		menu1.add(menuItem);
		
		//아이콘 추가
		menuItem= new JMenuItem("Save");
		menuItem.setIcon(new ImageIcon("images/save-alt.png"));		
		menuItem.addActionListener(menuItemListener);
		menu1.add(menuItem);
		
		//서브 메뉴를 가지는 메뉴아이템
		JMenu subMenu= new JMenu("sub menu");
		
		menuItem= new JMenuItem("sub1");
		menuItem.addActionListener(menuItemListener);
		subMenu.add(menuItem);
		
		menuItem= new JMenuItem("sub2");
		menuItem.addActionListener(menuItemListener);
		subMenu.add(menuItem);
		
		menu1.add(subMenu);
		
		
		//Menu2("Edit")의 서브메뉴들 만들기
		JCheckBoxMenuItem checkBoxMenuItem= new JCheckBoxMenuItem("Ruler");
		checkBoxMenuItem.addActionListener(menuItemListener);
		checkBoxMenuItem.setToolTipText("눈금자를 보이게 함");
		menu2.add(checkBoxMenuItem);
		
		//구분선 추가
		menu2.addSeparator();		
		
		JRadioButtonMenuItem radioButtonMenuItem= new JRadioButtonMenuItem("Ediable");
		radioButtonMenuItem.addActionListener(menuItemListener);
		menu2.add(radioButtonMenuItem);
				
		
		
		
		//메뉴바에 메뉴추가
		menuBar.add(menu1);
		menuBar.add(menu2);		
		
		//JFrame에 메뉴바 설정
		setJMenuBar(menuBar);
		
		
		//메뉴 선택시의 결과 출력용 JTextField
		tf= new JTextField();
		tf.setToolTipText("결과가 출력되는 영역입니다.");
		add(tf, BorderLayout.SOUTH);
		
		
		setTitle("menu test");
		setBounds(600, 100, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
	}
	
	
	//메뉴아이템(서브메뉴) 클릭 리스너....
	ActionListener menuItemListener= new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tf.setText( e.getActionCommand()+"를 선택했습니다." );			
		}
	};
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuBarTest();
	}

}
