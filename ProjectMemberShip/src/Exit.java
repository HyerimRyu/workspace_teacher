import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Exit extends JFrame{
	JPanel p;
	JPanel p2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	TextField tf1;
	TextField tf2;
	TextField tf3;
	TextField tf4;
	JButton btn1;
	JButton btn2;
	String id;
	String name;
	String bir;
	String pw;
	
	
	public Exit() {
		
		
		p=new JPanel();
		p2=new JPanel();
		label3=new JLabel("���̵�");
		tf1=new TextField(20);
		
		label4=new JLabel("��й�ȣ");
		tf2=new TextField(20);
		tf2.setEchoChar('*');
		
		label6=new JLabel("�̸�");
		tf4=new TextField(20);
		
		label5=new JLabel("�������");
		tf3=new TextField(20);
		

		

		
		
		
		btn1=new JButton("Ȯ��");
		btn1.addActionListener(new ActionListener() {
			Menu m = null;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				id=tf1.getText();
				name=tf4.getText();
				bir=tf3.getText();
				pw=tf2.getText();
				try {
					m = new Menu();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(id.equals(m.member_arr.get(0)[0])) {
					 if(pw.equals(m.member_arr.get(0)[1])){
						 if(name.equals(m.member_arr.get(0)[2])) {
							 if(bir.equals(m.member_arr.get(0)[4])) {
								 File file = new File("D:\\java\\workspace\\Membership\\Member\\"+id+".txt");
								 if( file.exists() ){
							            if(file.delete()){
							            	JOptionPane.showMessageDialog(tf1, "Ż�� �Ǿ����ϴ�.\n �̿����ּż� �����մϴ�");
							            }else{
							            	JOptionPane.showMessageDialog(tf1, "�̹� Ż��Ǿ��ų� �������� �ʴ� ȸ���Դϴ�.");
							            }
							        }
							 }else {
								 JOptionPane.showMessageDialog(tf3,"��������� Ȯ�����ּ���.");
							 }
						 }else
							 JOptionPane.showMessageDialog(tf3,"�̸��� Ȯ�����ּ���.");
					 }else {
						 JOptionPane.showMessageDialog(tf2,"��й�ȣ�� Ȯ�����ּ���.");
					 }
				 }else {
					 JOptionPane.showMessageDialog(tf3,"���̵� Ȯ�����ּ���.");
					 System.out.println(id+name+bir);
					 System.out.println(m.member_arr.get(0)[0]);
				 }
				
			}
		});
		btn2=new JButton("���");
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		p2.add(label3);
		p2.add(tf1);
		p2.add(label4);
		p2.add(tf2);
		p2.add(label6);
		p2.add(tf4);
		p2.add(label5);
		p2.add(tf3);
		p2.setLayout(new GridLayout(0, 2));
		
		p.add(btn1);
		p.add(btn2);
		
		
		add(p2,BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);
		
		setTitle("��Դ� ���ϱ� ȸ�� Ż��");
		setBounds(100, 200, 400, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	class Menu{
	BufferedReader Member_in=null;//����б�

	ArrayList<String[]>member_arr;//��� ������ �迭�� ���� ����
	
	public Menu() throws IOException{
			
		Member_in=new BufferedReader(new FileReader("D:\\java\\workspace\\Membership\\Member\\"+id+".txt"));//FileReader�� BufferedReader�� ��Ƽ�  ���پ� �����ϰ� ����
		//��������� �迭�� ������������
		
		member_arr=new ArrayList<String[]>();
		String s;
		while((s=Member_in.readLine())!=null){
			System.out.println(""+s);//�ٹٲ� ���ڸ� �����ϰ� ���پ� ���
			member_arr.add(s.split("\t"));
		}
		
	
	}
	
}
	
}