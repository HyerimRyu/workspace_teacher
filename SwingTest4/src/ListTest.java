import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest extends JFrame{
	
	//리스트에 보여질 항목들
	String[] datas= new String[] {"Char1","Char2","Char3","Char4","Char5","Char6"};	
	JList<String> list= new JList<String>();
	
	public ListTest() {
		// TODO Auto-generated constructor stub
		//리스트객체의 설정과 항목들 설정
		list.setListData(datas);
		list.setSelectionBackground(Color.YELLOW);
		list.setSelectionForeground(Color.RED);
		add(list, BorderLayout.WEST);
		
		//가운데 이미지 배치 영역
		JPanel panel= new JPanel();
		panel.setLayout(new GridLayout(3, 2, 5, 5));//rows, cols, hgap, vgap
		
		JLabel[] imgLables= new JLabel[6];//배열객체 1개 생성
		
		for(int i=0; i<imgLables.length; i++) {
			//이미지아이콘객체 생성
			ImageIcon icon= new ImageIcon("images/ms_0"+(i+1)+".png");
			//ReSizing.....
			icon= new ImageIcon( icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH) );
			/////////////////			
			imgLables[i]= new JLabel(icon);
			panel.add(imgLables[i]);
		}
		
		add(panel, BorderLayout.CENTER);
		
		//리스트의 항목을 선택하는 것을 듣는 리스너객체 생성 및 추가
		list.addListSelectionListener( new ListSelectionListener() {
			
			//리스트의 항목을 선택하면 자동으로 실행되는 메소드 : 콜백메소드
			@Override
			public void valueChanged(ListSelectionEvent e) {				
				// TODO Auto-generated method stub
				
				//우선 전원다 안보이게..
				for(JLabel t: imgLables) t.setVisible(false);
				
				//리스트에게 선택된 항목의 인덱스번호 얻어오기
				int index= list.getSelectedIndex();				
				imgLables[index].setVisible(true);
				
			}
		});
		
		JButton btn= new JButton("START");
		add(btn, BorderLayout.NORTH);
		
		btn.addActionListener(  new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(JLabel t : imgLables) t.setVisible(false);
			}
		});
		
		
		setTitle("List Test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocation(600, 100);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListTest();
	}

}
