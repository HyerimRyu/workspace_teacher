import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ScrollPaneTest extends JFrame{
	
	public ScrollPaneTest() {
		// TODO Auto-generated constructor stub
		
		ImageIcon icon= new ImageIcon("images/ms19.png");
		JLabel imgLabel= new JLabel(icon);
		
		//스크롤바를 가진 ScrollPane객체 생성
//		JScrollPane scrollPane= new JScrollPane();
//		scrollPane.setViewportView(imgLabel);
		
		//스크롤바의 표시여부 설정
		int v= JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
		int h= JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS;		
		JScrollPane scrollPane= new JScrollPane(imgLabel, v, h);		
		
		add(scrollPane, BorderLayout.CENTER);
		
		add(new JButton("button"), BorderLayout.SOUTH);
		
		
		
		
		
		
		setTitle("ScrollPane Test");
		setSize(600, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(100, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ScrollPaneTest();
	}

}
