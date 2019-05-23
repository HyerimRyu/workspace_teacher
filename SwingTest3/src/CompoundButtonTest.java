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
		setTitle("���չ�ư �׽�Ʈ");
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
		
		//�����ӿ� ���̱�
		add(cbPanel, BorderLayout.NORTH);
		
		//üũ�ڽ��� üũ���°� ����Ǵ� ���� ��� ������ �߰�
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
		
		//������ư 3���� �ϳ��� �׷����� �����ϵ��� �ؾ߸� Single Choice�� ������.
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
		
		//�����ư Ŭ���ÿ� �ؽ�Ʈ�ʵ忡 ���õ� �۾� �����ֱ�����
		//������ �߰��ϱ�..
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
		
		//�̹����� �����ֱ� ���� ������Ʈ
		ImageIcon icon= new ImageIcon("images/ms_01.png");
		icon= new ImageIcon( icon.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH) );		
		JLabel label= new JLabel(icon);//�����ڿ� ���������� ����		
		
		centerPanel.add(comboPanel, BorderLayout.NORTH);
		centerPanel.add(label, BorderLayout.CENTER);
		
		//�����ӿ� ���̱�
		add(centerPanel, BorderLayout.CENTER);
		
		//�޺��ڽ��� ������ ���̱�..
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
	}//������
	
	//Radio��ư�� Ŭ���Ǿ������� ��� �����ʰ�ü ���� -�������
	ActionListener rbListener= new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str= e.getActionCommand();//������Ʈ�� ���ִ� �۾��� ���ϵ�.
			rb_tf.setText(str);
		}
	};
	
	
	//CheckBox�� üũ���� ������ ��� �����Ͱ�ü ���� - �������
	ItemListener itemListener= new ItemListener() {
		//CheckBox�� üũ���� ����Ǹ� �ڵ����� ����Ǵ� �޼ҵ�!!
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			//üũ�ڽ����� üũ���¸� Ȯ���Ͽ� true�� �ű� ���ִ� �۾��� ���ͼ�
			//TextField�� �����ֱ�!!!
			
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







