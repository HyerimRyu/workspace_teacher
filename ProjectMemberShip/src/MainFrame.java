import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	JPanel p;
	JPanel p2;
	JPanel p3;
	JLabel label1;
	JLabel label2;
	JLabel Membershipimg;
	TextField tf1;
	TextField pf2;
	JButton bt1;
	JButton bt2;
	JButton bt3;
	JButton bt4;
	ImageIcon icon;
	String id;
	String pw;

	public MainFrame() {
		p2 = new JPanel();
		p = new JPanel();
		p3 = new JPanel();

		label1 = new JLabel("���̵�");
		tf1 = new TextField(15);
		label2 = new JLabel("��й�ȣ");
		pf2 = new TextField(15);
		pf2.setEchoChar('*');
		

		icon = new ImageIcon("images/��Դ�2.png");

		Membershipimg = new JLabel(icon);

		bt1 = new JButton("�α���");
		bt1.setPreferredSize(new Dimension(90, 20));
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				id = tf1.getText();
				pw = pf2.getText();
				Menu m = null;
				File f = new File("D:\\java\\workspace\\Membership\\Member\\" + id + ".txt");

				if (id.length() <= 0) {
					JOptionPane.showMessageDialog(p2, "���̵� �Է��ϼ���.");
					return;
				}
				// ���� ���� ���� �Ǵ�
				if (f.isFile()) {
					// System.out.println("OK ���� �ֽ��ϴ�.");
					try {
						m = new Menu();
						if (id.equals(m.member_arr.get(0)[0])) {
							if (pw.equals(m.member_arr.get(0)[1])) {
								setVisible(false);
								new Game();
							} else {
								if (pw.length() <= 0) {
									JOptionPane.showMessageDialog(p2, "��й�ȣ�� �Է��ϼ���.");
									return;
								} else JOptionPane.showMessageDialog(p2, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");								
							}
						} else {
							System.out.println(id);
							System.out.println(m.member_arr.get(0)[0]);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else JOptionPane.showMessageDialog(p2, "���̵� �������� �ʽ��ϴ�.");
			}
		});
		bt2 = new JButton("ȸ������");
		bt2.setPreferredSize(new Dimension(90, 20));
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Membership();
			}
		});

		bt3 = new JButton("PW ã��");
		bt3.setPreferredSize(new Dimension(90, 20));
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Search();
			}
		});

		p.add(label1);
		p.add(tf1);
		p.add(label2);
		p.add(pf2);
		// add(p);
		p3.add(bt1);
		p3.add(bt2);
		p3.add(bt3);
		// p3.add(bt4);

		p2.add(p, BorderLayout.NORTH);
		p2.add(p3, BorderLayout.CENTER);
		p2.add(Membershipimg, BorderLayout.SOUTH);
		add(p2);

		setTitle("��Դ� ���ϱ� Login");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	class Menu {
		BufferedReader Member_in = null;// ����б�

		ArrayList<String[]> member_arr;// ��� ������ �迭�� ���� ����

		public Menu() throws IOException {

			Member_in = new BufferedReader(new FileReader("D:\\java\\workspace\\Membership\\Member\\" + id + ".txt"));
			// FileReader��  BufferedReader�� ��Ƽ� ���پ�  �����ϰ� ���� ��������� �迭�� ������������
			member_arr = new ArrayList<String[]>();
			String s;
			while ((s = Member_in.readLine()) != null) {
				System.out.println("" + s);// �ٹٲ� ���ڸ� �����ϰ� ���پ� ���
				member_arr.add(s.split("\t"));
			}

		}

	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
