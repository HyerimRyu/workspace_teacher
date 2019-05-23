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

		label1 = new JLabel("아이디");
		tf1 = new TextField(15);
		label2 = new JLabel("비밀번호");
		pf2 = new TextField(15);
		pf2.setEchoChar('*');
		

		icon = new ImageIcon("images/토게느2.png");

		Membershipimg = new JLabel(icon);

		bt1 = new JButton("로그인");
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
					JOptionPane.showMessageDialog(p2, "아이디를 입력하세요.");
					return;
				}
				// 파일 존재 여부 판단
				if (f.isFile()) {
					// System.out.println("OK 파일 있습니다.");
					try {
						m = new Menu();
						if (id.equals(m.member_arr.get(0)[0])) {
							if (pw.equals(m.member_arr.get(0)[1])) {
								setVisible(false);
								new Game();
							} else {
								if (pw.length() <= 0) {
									JOptionPane.showMessageDialog(p2, "비밀번호를 입력하세요.");
									return;
								} else JOptionPane.showMessageDialog(p2, "비밀번호가 일치하지 않습니다.");								
							}
						} else {
							System.out.println(id);
							System.out.println(m.member_arr.get(0)[0]);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else JOptionPane.showMessageDialog(p2, "아이디가 존재하지 않습니다.");
			}
		});
		bt2 = new JButton("회원가입");
		bt2.setPreferredSize(new Dimension(90, 20));
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Membership();
			}
		});

		bt3 = new JButton("PW 찾기");
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

		setTitle("토게느 피하기 Login");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	class Menu {
		BufferedReader Member_in = null;// 멤버읽기

		ArrayList<String[]> member_arr;// 멤버 정보를 배열로 담을 공간

		public Menu() throws IOException {

			Member_in = new BufferedReader(new FileReader("D:\\java\\workspace\\Membership\\Member\\" + id + ".txt"));
			// FileReader를  BufferedReader에 담아서 한줄씩  저장하게 해줌 멤버정보를 배열로 담을공간생성
			member_arr = new ArrayList<String[]>();
			String s;
			while ((s = Member_in.readLine()) != null) {
				System.out.println("" + s);// 줄바꿈 문자를 제외하고 한줄씩 출력
				member_arr.add(s.split("\t"));
			}

		}

	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
