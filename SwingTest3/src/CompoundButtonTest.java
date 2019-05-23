import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CompoundButtonTest extends JFrame{
	
	JCheckBox cb1, cb2, cb3;
	JTextField cb_tf;
	
	JRadioButton rb1, rb2, rb3;
	JTextField rb_tf;
	
	public CompoundButtonTest() {
		// TODO Auto-generated constructor stub
		setTitle("복합버튼 테스트");
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setPreferredSize( new Dimension(350, 500) );
		
		//1. CheckBox....
		JPanel cbPanel= new JPanel();
		cbPanel.setLayout(new GridLayout(2, 1));
		
		JPanel panel= new JPanel();
		cb1= new JCheckBox("Apple");
		cb2= new JCheckBox("Banana");
		cb3= new JCheckBox("Orange");
		panel.add(cb1);
		panel.add(cb2);
		panel.add(cb3);		
		cbPanel.add(panel);
		
		JPanel panel2= new JPanel();
		cb_tf= new JTextField(15);
		panel2.add(cb_tf);
		cbPanel.add(panel2);
		
		//프레임에 붙이기
		add(cbPanel, BorderLayout.NORTH);
		
		//체크박스의 체크상태가 변경되는 것을 듣는 리스너 추가
		cb1.addItemListener(itemListener);
		cb2.addItemListener(itemListener);
		cb3.addItemListener(itemListener);		
		
		//2. RadioButton...
		JPanel rbPanel= new JPanel();
		rbPanel.setLayout( new GridLayout(2, 1));
		
		JPanel panel3= new JPanel();
		rb1= new JRadioButton("KOREA");
		rb2= new JRadioButton("CHINA");
		rb3= new JRadioButton("JAPAN");
		panel3.add(rb1);
		panel3.add(rb2);
		panel3.add(rb3);
		
		//라디오버튼 3개을 하나의 그룹으로 인지하도록 해야만 Single Choice가 동작함.
		ButtonGroup rg= new ButtonGroup();
		rg.add(rb1);
		rg.add(rb2);
		rg.add(rb3);		
		
		JPanel panel4= new JPanel();
		rb_tf= new JTextField(15);
		panel4.add(rb_tf);
		
		rbPanel.add(panel3);
		rbPanel.add(panel4);
		
		add(rbPanel, BorderLayout.SOUTH);	
		
		//라디어버튼 클릭시에 텍스트필드에 선택된 글씨 보여주기위해
		//리스너 추가하기..
		rb1.addActionListener(rbListener);
		rb2.addActionListener(rbListener);
		rb3.addActionListener(rbListener);
		
		
		//3. ComboBox....
		JPanel centerPanel= new JPanel();
		centerPanel.setLayout(new BorderLayout());
		
		JPanel comboPanel= new JPanel();
		JComboBox<String> comboBox= new JComboBox<String>();
		comboBox.addItem("Character 1");
		comboBox.addItem("Character 2");
		comboBox.addItem("Character 3");
		comboBox.addItem("Character 4");
		comboBox.addItem("Character 5");
		comboPanel.add(comboBox);
		
		//이미지를 보여주기 위한 컴포넌트
		ImageIcon icon= new ImageIcon("images/ms_01.png");
		icon= new ImageIcon( icon.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH) );		
		JLabel label= new JLabel(icon);//생성자에 아이콘지정 가능		
		
		centerPanel.add(comboPanel, BorderLayout.NORTH);
		centerPanel.add(label, BorderLayout.CENTER);
		
		//프레임에 붙이기
		add(centerPanel, BorderLayout.CENTER);
		
		//콤보박스에 리스너 붙이기..
		comboBox.addActionListener(  new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println( comboBox.getSelectedIndex()  );
				int index= comboBox.getSelectedIndex();
				
				ImageIcon icon= new ImageIcon("images/ms_0"+(1+index)+".png");
				icon= new ImageIcon( icon.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH) );
				label.setIcon(icon);
			}
		});
		
		
		pack();
		setLocation(600, 100);
		setVisible(true);
	}//생성자
	
	//Radio버튼이 클릭되었는지를 듣는 리스너객체 생성 -멤버변수
	ActionListener rbListener= new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str= e.getActionCommand();//컴포넌트에 써있는 글씨가 리턴됨.
			rb_tf.setText(str);
		}
	};
	
	
	//CheckBox의 체크상태 변경을 듣는 리스터객체 생성 - 멤버변수
	ItemListener itemListener= new ItemListener() {
		//CheckBox의 체크상태 변경되면 자동으로 실행되는 메소드!!
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			//체크박스들의 체크상태를 확인하여 true면 거기 써있는 글씨을 얻어와서
			//TextField에 보여주기!!!
			
			String str= "";
			
			if( cb1.isSelected() ) str= str+ cb1.getText();
			if( cb2.isSelected() ) str= str+ cb2.getText();
			if( cb3.isSelected() ) str= str+ cb3.getText();
			
			cb_tf.setText(str);			
		}
	};
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CompoundButtonTest();
	}

}







