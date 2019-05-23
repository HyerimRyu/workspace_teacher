import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class MemberShip extends JFrame{
	
	boolean Membercheck = false;
	JPanel Mainpanel;
	String t; //txt1�� ��
	String t1;//txt2�� �� 
	JButton IDok;
	JButton PSok;
	JButton bt1;
	JButton bt2;
	TextField txt1;
	TextField txt2;

	JLabel Membershipimg; //��������
	JLabel Membershipimg1; //�������
//	JLabel Membershipimg2; //����
	
	Image img;
	
	//�ؽ�Ʈ ����
		
	public MemberShip() {
		
		new Img();
		
		//���̾ƿ� �����ؼ� �ý�Ʈ�� �������� �����ֱ����� ���� ����
		Mainpanel = new JPanel(new BorderLayout());
		
		FlowLayout layout1 = new FlowLayout(FlowLayout.LEFT);
		
		//ū ��
		
		JPanel Onekingpanel = new JPanel(new GridLayout(0, 2));
		
		JPanel panelex1 = new JPanel(new BorderLayout());
		JPanel panelex2 = new JPanel(new BorderLayout());
		JPanel panelID = new JPanel(new BorderLayout());
		JPanel panelPS = new JPanel(new BorderLayout());
		JPanel panelbt = new JPanel();
		
		//panel1�� ���̺�
		JPanel panelex1lb = new JPanel();
		JPanel panelex2lb = new JPanel();

		//panel1 �ؽ�Ʈ �ʵ�
		JPanel panelex1tf = new JPanel();
		JPanel panelex2tf = new JPanel();
		
		//�ؽ�Ʈ �ʵ� ����
		txt1 = new TextField(10);
		txt2 = new TextField(10);
		
		
		bt1 = new JButton("�Ϸ�");
		bt2 = new JButton("���");
		bt1.setForeground(Color.BLUE);
		bt2.setForeground(Color.RED);
		bt1.setContentAreaFilled(false);
		bt2.setContentAreaFilled(false);
		bt1.setFocusPainted(false);
		bt2.setFocusPainted(false);
		
		PSok = new JButton("��й�ȣ Ȯ��");
		PSok.setContentAreaFilled(false);
		PSok.setForeground(Color.RED);
		PSok.setFocusPainted(false);
		PSok.setBorderPainted(false);
		
		IDok = new JButton("���̵� Ȯ��");
		IDok.setContentAreaFilled(false);
		IDok.setForeground(Color.RED);
		IDok.setFocusPainted(false);
		IDok.setBorderPainted(false);
		
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

		t= txt1.getText();
				
		File f = new File("ȸ������/"+t+".txt");

	if (f.isFile()) {
		JOptionPane.showMessageDialog(Mainpanel, " ���̵� �ߺ��Ǿ����ϴ�.");

		}
		else {
		if(txt1.getText().length() > 10 ) {
			IDok.setForeground(Color.RED);
			JOptionPane.showMessageDialog(Mainpanel, "���̵� 10���� �̸����� �Է��ϼ���.");
		return;
		}
		if(txt1.getText().length() <= 0) {
			IDok.setForeground(Color.RED);
			JOptionPane.showMessageDialog(Mainpanel, "���̵� �Է��ϼ���.");
			return;
			} 	
		for(int i=0; i < txt1.getText().length(); i++) {
							
			if((txt1.getText().charAt(i) >= 'A' && txt1.getText().charAt(i) <= 'Z')){
					IDok.setForeground(Color.GREEN);
			}else if((txt1.getText().charAt(i) >= 'a' && txt1.getText().charAt(i) <= 'z')){	
					IDok.setForeground(Color.GREEN);
			}else if((txt1.getText().charAt(i) >= '0' && txt1.getText().charAt(i) <= '9')){  
					IDok.setForeground(Color.GREEN);
			}else {
					JOptionPane.showMessageDialog(Mainpanel, "���̵� Ȯ���ϼ���.");
					PSok.setForeground(Color.RED);
					return;
					}
			if (i == txt1.getText().length() - 1) {
				try {
					new Menu();
				} catch (IOException e) {}
					setVisible(false);
					JOptionPane.showMessageDialog(Mainpanel, t +" ȸ�������� �����մϴ�!!.");
					IDok.setForeground(Color.GREEN);
					}		
				}
			}		
		}
	});//bt1.Ac...
		
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		panelbt.add(bt1);
		panelbt.add(bt2);
		panelID.add(IDok,BorderLayout.WEST);
		panelPS.add(PSok,BorderLayout.WEST);
	
		JLabel label1 = new JLabel("<html>&nbsp;1. ���̵� �Է��ϼ���" + "<br>" + "(1~10���� ���� �� �ҹ��� ����)</html>");
		label1.setFont(new Font("Serif", Font.TYPE1_FONT, 11));
		panelex1tf.setLayout(layout1);
		panelex1tf.add(txt1);
		
		panelex1.add(label1, BorderLayout.CENTER);
		panelex1.add(panelex1tf, BorderLayout.SOUTH);
		
		JLabel label2 = new JLabel("<html>&nbsp;2. ��й�ȣ�� �Է��ϼ���" +"<br>"+"(1~10�� ���� �� �ҹ��� ����"+"<br>"+"Ư�����ڸ� �Է����ּ���)</html>");
		label2.setFont(new Font("Serif", Font.TYPE1_FONT, 11));
		panelex2tf.setLayout(layout1);
		panelex2tf.add(txt2);
		panelex2.add(label2, BorderLayout.CENTER);
		panelex2.add(panelex2tf, BorderLayout.SOUTH);
		
		Onekingpanel.add(panelex1);
		Onekingpanel.add(panelID); //���̵�Ȯ�� ��ư
		Onekingpanel.add(panelex2);
		Onekingpanel.add(panelPS);// ��й�ȣ Ȯ�� ��ư
		
		Onekingpanel.add(Membershipimg,BorderLayout.CENTER);
		Onekingpanel.add(Membershipimg1,BorderLayout.CENTER);

		Mainpanel.add(Onekingpanel,BorderLayout.CENTER);
		Mainpanel.add(panelbt,BorderLayout.SOUTH);
		Mainpanel.add(Onekingpanel);
		add(Mainpanel,BorderLayout.CENTER);
		setTitle("ȸ������");
		setBounds(465, 300, 360, 400);
		setResizable(false);
		setVisible(true);
	
		IDok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				t= txt1.getText();
					 File f = new File("ȸ������/"+t+".txt");
					 checkPS();	
				if (f.isFile()) {JOptionPane.showMessageDialog(Mainpanel, " ���̵� �ߺ��Ǿ����ϴ�.");}
				else {
				if(txt1.getText().length() > 10 ) {
					IDok.setForeground(Color.RED);
					JOptionPane.showMessageDialog(Mainpanel, "���̵�� 10���� �̸�");
					return;
				}
				if(txt1.getText().length() <= 0) {
					  IDok.setForeground(Color.RED);
					  JOptionPane.showMessageDialog(Mainpanel, "���̵� �Է��ϼ���.");
					  return;
					} 	
					for(int i=0; i < txt1.getText().length(); i++) {
					
					if((txt1.getText().charAt(i) >= 'A' && txt1.getText().charAt(i) <= 'Z')){
						IDok.setForeground(Color.GREEN);
					}else if((txt1.getText().charAt(i) >= 'a' && txt1.getText().charAt(i) <= 'z')){	
						IDok.setForeground(Color.GREEN);
					}else if((txt1.getText().charAt(i) >= '0' && txt1.getText().charAt(i) <= '9')){  
						IDok.setForeground(Color.GREEN);
					}else {
						JOptionPane.showMessageDialog(Mainpanel, "���̵� Ȯ���ϼ���.");
						IDok.setForeground(Color.RED);
						return;
					}
				if (i == txt1.getText().length() - 1) {
					Membercheck = true;
					JOptionPane.showMessageDialog(Mainpanel, "��� ������ ���̵� �Դϴ�.");
					IDok.setForeground(Color.GREEN);
					
					}
				}
			}
		}
		
				//üũid		
	});
			
		PSok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
				t1 = txt2.getText();
				checkPS();
			}
		});		
	}
	
	public void checkPS() {
		
		if(txt2.getText().length() > 10) {
			PSok.setForeground(Color.RED);
			JOptionPane.showMessageDialog(Mainpanel, "��й�ȣ�� 10���� �̸�");
			return;
		}
		  if(txt2.getText().length() <= 0) {
			  PSok.setForeground(Color.RED);
	          JOptionPane.showMessageDialog(Mainpanel, "��й�ȣ�� �Է��ϼ���.");
	          return;
	       }
		for(int i=0; i < txt2.getText().length(); i++) {
			
			if((txt2.getText().charAt(i) >= 'A' && txt2.getText().charAt(i) <= 'Z')){	
			}
			else if((txt2.getText().charAt(i) >= 'a' && txt2.getText().charAt(i) <= 'z')){
				
			}else if((txt2.getText().charAt(i) >= '0' && txt2.getText().charAt(i) <= '9')){  
			
			}else if((txt2.getText().charAt(i) >= '!' && txt2.getText().charAt(i) <= '@')){
				
			}else {
				PSok.setForeground(Color.RED);
				JOptionPane.showMessageDialog(Mainpanel, "��й�ȣ�� Ȯ���ϼ���.");
				break;
			}
			if (i == txt2.getText().length() - 1) {
				Membercheck = true;
				JOptionPane.showMessageDialog(Mainpanel, "��� ������ ��й�ȣ �Դϴ�.");
				PSok.setForeground(Color.GREEN);
			}
		}	
	}//checkPS �� �κ�..	
	
	public class Img{
		public Img() {
			
			ImageIcon icon = new ImageIcon("images/SPJ.gif");
			Membershipimg = new JLabel(icon);
			
			ImageIcon icon1 = new ImageIcon("images/GG.gif");
			Membershipimg1 = new JLabel(icon1);	
		}
	}
	class Menu {
		
		String Mid;
		String Mpw;
		
		BufferedReader Member_in = null; // �б�
		FileWriter Member_out = null; // ����
		ArrayList<String[]> Member_Arr; // ����

		
		public Menu() throws IOException{
			
//			Member_out = new FileWriter("ȸ������/Member.txt", true); //���� ����!! Member.txt������ ������ ����
			Member_out = new FileWriter("ȸ������/"+t+".txt");	 // true -> ������ �ִ� ���Ͽ� ���� �����̱�
			Member_out.write(t + "\t" + t1); //���Ͼ��� !! id pw ���ڿ��� �����
			Member_out.append("\t"); 
			Member_out.flush();
	
			Member_in = new BufferedReader(new FileReader("ȸ������/"+t+".txt")); //fileReader�� BufferedReader��
		
			//��� ������ �迭�� ���� ���� ����
			Member_Arr = new ArrayList<String[]>();
	
			//���� �б�
			String s;
			while((s = Member_in.readLine())!=null){
				
				Member_Arr.add(s.split("\t"));	
			}
		}	
	}
}//JFrame ��..
