import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Membership extends JFrame {

	TextField pf1;
	TextField pf2;
	TextField id;
	TextField name;
	TextField bir;
	TextField mail;
	TextField addess;

	JPanel p2;
	JLabel label;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JLabel label7;
	JLabel label8;
	JLabel label9;
	JLabel label10;

	JPanel p;
	JPanel p3;
	JPanel p4;
	JPanel p5;
	JPanel p6;
	JPanel p7;
	JPanel p8;

	JRadioButton btn1;
	JRadioButton btn2;
	ButtonGroup rg;

	JButton bt1;
	JButton bt2;
	JButton bt3;

	JButton bt5;

	String f1;
	String f2;
	String sid;
	String sname;
	String gender;
	String sbir;
	String smail;
	String sadd;

	class Menu {
		BufferedReader Member_in = null;// 멤버읽기
		FileWriter member_out = null;// 멤버쓰기
		ArrayList<String[]> member_arr;// 멤버 정보를 배열로 담을 공간

		public Menu() throws IOException {

			sid = id.getText();
			sname = name.getText();
			sbir = bir.getText();
			smail = mail.getText();
			sadd = addess.getText();

			if (btn1.isSelected()) { // 받아낸 라디오버튼의 체크 상태를 확인한다. 체크되었을경우 true 반환.
				gender = btn1.getText().trim(); // getText() 메소드로 문자열 받아낸다.
			} else {
				gender = btn2.getText().trim();
			}

			member_out = new FileWriter("D:\\java\\workspace\\Membership\\Member\\" + sid + ".txt");// 파일쓰기!!
																									// member.txt가없으면 생성
			member_out.write(sid + "\t" + f1 + "\t" + sname + "\t" + gender + "\t" + sbir + "\t" + smail + "\t" + sadd);
			// 파일쓰기!! id pw 문자열로  저장됨 
			member_out.append("\n");// 파일을 쓴 후 한줄 개행
			member_out.flush();

		}

	}

	public Membership() {

		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		label3 = new JLabel("*아이디");
		label3.setPreferredSize(new Dimension(90, 20));

		id = new TextField(18);

		label4 = new JLabel("*비밀번호");
		label4.setPreferredSize(new Dimension(90, 20));
		pf1 = new TextField(18);
		pf1.setEchoChar('*');

		label5 = new JLabel("*비밀번호 확인");
		label5.setPreferredSize(new Dimension(90, 20));
		pf2 = new TextField(18);
		pf2.setEchoChar('*');

		label = new JLabel("*성명 : ");
		label.setPreferredSize(new Dimension(90, 20));
		name = new TextField(18);

		btn1 = new JRadioButton("남성");
		btn1.setSelected(true);
		btn2 = new JRadioButton("여성");
		rg = new ButtonGroup();
		rg.add(btn1);
		rg.add(btn2);
		label2 = new JLabel("*생년월일");
		label2.setPreferredSize(new Dimension(90, 20));
		bir = new TextField(18);

		label6 = new JLabel("이메일");
		mail = new TextField(10);

		label7 = new JLabel("주소");
		addess = new TextField(10);

		label10 = new JLabel("영문,숫자 입력");
		label10.setPreferredSize(new Dimension(90, 20));
		// bt4.setContentAreaFilled(false);
		// bt4.setBorderPainted(false);
		// bt4.setFocusPainted(false);

		bt5 = new JButton(" ");
		bt5.setPreferredSize(new Dimension(90, 20));
		bt5.setContentAreaFilled(false);
		bt5.setBorderPainted(false);
		bt5.setFocusPainted(false);

		label9 = new JLabel("영문이름 입력");
		label9.setPreferredSize(new Dimension(90, 20));
		// bt6.setContentAreaFilled(false);
		// bt6.setBorderPainted(false);
		// bt6.setFocusPainted(false);

		label8 = new JLabel("ex)930325");
		label8.setPreferredSize(new Dimension(90, 20));
		// bt7.setContentAreaFilled(false);
		// bt7.setBorderPainted(false);
		// bt7.setFocusPainted(false);

		p2.setLayout(new GridLayout(0, 2));

		p = new JPanel();
		bt1 = new JButton("확인");
		bt1.setPreferredSize(new Dimension(90, 20));
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f1 = pf1.getText();
				f2 = pf2.getText();
				File f = new File("D:\\java\\workspace\\Membership\\Member\\" + id.getText() + ".txt");

				if (id.getText().length() > 10) {
					JOptionPane.showMessageDialog(null, "10글자 미만으로 입력하세요");
					return;
				}
				if (id.getText().length() < 4) {
					JOptionPane.showMessageDialog(null, "ID가 너무 짧습니다. \n5글자 이상 입력해주세요");
					return;
				}
				if (id.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
					return;
				}

				for (int i = 0; i < id.getText().length(); i++) {
					if ((id.getText().charAt(i) >= 'A' && id.getText().charAt(i) <= 'Z')) {
					} else if ((id.getText().charAt(i) >= 'a' && id.getText().charAt(i) <= 'z')) {
					} else if ((id.getText().charAt(i) >= '0' && id.getText().charAt(i) <= '9')) {
					} else {
						JOptionPane.showMessageDialog(null, "영문 또는 숫자로 입력하세요");
						return;
					}
				}
				if (pf1.getText().length() > 10) {
					JOptionPane.showMessageDialog(null, "10글자 미만으로 입력하세요");
					return;
				}

				if (pf1.getText().length() <= 4) {
					JOptionPane.showMessageDialog(null, "비밀번호를 5글자이상 입력하세요.");
					return;
				}

				for (int i = 0; i < pf1.getText().length(); i++) {
					if ((pf1.getText().charAt(i) >= 'A' && pf1.getText().charAt(i) <= 'Z')) {
					} else if ((pf1.getText().charAt(i) >= 'a' && pf1.getText().charAt(i) <= 'z')) {
					} else if ((pf1.getText().charAt(i) >= '0' && pf1.getText().charAt(i) <= '9')) {
					} else {
						JOptionPane.showMessageDialog(null, "영문 또는 숫자로 입력하세요");
						return;
					}
				}
				if (pf2.getText().length() > 10) {
					JOptionPane.showMessageDialog(null, "10글자 미만으로 입력하세요");
					return;
				}
				if (pf2.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "비밀번호 확인을 입력하세요.");
					return;
				}

				for (int i = 0; i < pf2.getText().length(); i++) {
					if ((pf2.getText().charAt(i) >= 'A' && pf2.getText().charAt(i) <= 'Z')) {
					} else if ((pf2.getText().charAt(i) >= 'a' && pf2.getText().charAt(i) <= 'z')) {
					} else if ((pf2.getText().charAt(i) >= '0' && pf2.getText().charAt(i) <= '9')) {
					} else {
						JOptionPane.showMessageDialog(null, "영문 또는 숫자로 입력하세요.	");
						return;
					}
				}
				if (name.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
					return;
				}
				for (int i = 0; i < name.getText().length(); i++) {
					if ((name.getText().charAt(i) >= 'A' && name.getText().charAt(i) <= 'Z')) {
					} else if ((name.getText().charAt(i) >= 'a' && name.getText().charAt(i) <= 'z')) {
					} else {
						JOptionPane.showMessageDialog(null, "영문 이름만 입력가능합니다.");
						return;
					}
				}

				if (bir.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "생년월일을 입력해주세요.");
					return;
				}
				if (f.isFile()) {
					// System.out.println("OK 파일 있습니다.");
					JOptionPane.showMessageDialog(null, "이미 중복된 아이디입니다.");
					return;
				}
				if (f1.equals(f2)) {
					setVisible(false);
					new Identify();
				} else {
					new Fail();
				}
			}
		});

		bt2 = new JButton("취소");
		bt2.setPreferredSize(new Dimension(90, 20));
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		bt3 = new JButton("중복 확인");
		bt3.setPreferredSize(new Dimension(90, 20));
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File f = new File("D:\\java\\workspace\\Membership\\Member\\" + id.getText() + ".txt");
				if (id.getText().length() < 5) {
					JOptionPane.showMessageDialog(null, "ID가 너무 짧습니다. \n5글자 이상 입력해주세요");
					return;
				}
				if (id.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
					return;
				}

				if (f.isFile()) {
					// System.out.println("OK 파일 있습니다.");
					JOptionPane.showMessageDialog(null, "이미 중복된 아이디입니다.");
					return;
				} else {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
				}
			}
		});

		p.add(bt1);
		p.add(bt2);

		p7.add(label3);
		p7.add(id);
		p7.add(bt3);
		p3.add(label4);
		p3.add(pf1);
		p3.add(label10);
		p4.add(label5);
		p4.add(pf2);
		p4.add(bt5);
		p5.add(label);
		p5.add(name);
		p5.add(label9);
		p6.add(label2);
		p6.add(bir);
		p6.add(label8);

		p8.add(btn1);
		p8.add(btn2);
		p2.setLayout(new GridLayout(6, 1));
		p2.add(p7);
		p2.add(p3);
		p2.add(p4);
		p2.add(p5);
		p2.add(p6);
		p2.add(p8);

		// p2.add(label6);
		// p2.add(mail);
		// p2.add(label7);
		// p2.add(addess);

		add(p2);

		add(p, BorderLayout.SOUTH);
		setTitle("토게느 피하기 회원가입");
		setSize(400, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	class Panel extends JPanel {
		Image imgback;
		int width, height;// MyPanel의 가로,세로 사이즈
		int x, y; // 이미지의 좌표
		int w, h; // 이미지의 절반넓이, 절반높이

		public Panel() {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			imgback = toolkit.getImage("images/bg.jpg");
		}

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			if (width == 0 || height == 0) {
				width = getWidth();
				height = getHeight();

				// 플레이어 이미지의 처음 시작 좌표계산(화면의 가운데서 시작하도록)
				x = width / 2;
				y = height / 2;

				// 배경 이미지를 MyPanel만하게 리사이징
				imgback = imgback.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			}
			// 화면을 모두 지우기
			g.clearRect(0, 0, width, height);

			// 배경 이미지 그리기
			g.drawImage(imgback, 0, 0, this);
		}
	}

	class Identify extends JFrame {
		public Identify() {
			p = new JPanel();
			label = new JLabel("회원가입을 축하합니다!");
			JButton bt = new JButton("확인");
			bt.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new Menu();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					setVisible(false);

				}
			});

			p.add(label);
			p.add(bt);
			add(p);
			setBounds(320, 300, 200, 100);
			setVisible(true);
			setResizable(false);

		}
	}

	class Fail extends JFrame {
		public Fail() {
			JPanel p = new JPanel();
			JLabel label = new JLabel("비밀번호를 확인해주세요.");
			JButton bt = new JButton("확인");
			bt.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			p.add(label);
			p.add(bt);
			add(p);
			setBounds(400, 300, 200, 100);
			setVisible(true);

		}
	}
}
