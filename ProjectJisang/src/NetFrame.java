import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

public class NetFrame extends JFrame {

	public JLabel manubar = new JLabel(new ImageIcon("img/manubar2.png"));
	public ImageIcon exb =new ImageIcon("img/42.png");
	public ImageIcon exb2 =new ImageIcon("img/40.png");
	public JButton exButton =new JButton(exb2);
	public int mx,my;
	
	public NetFrame() {
		Mypanel panel = new Mypanel();
		add(panel, BorderLayout.CENTER);
		setUndecorated(true);
		setFocusable(true);
		setLocationRelativeTo(null);
		setTitle("★★스키장 정보★★");
		setSize(500, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		manubar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mx=e.getX();
				my=e.getY();
			}
		});
		manubar.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				setLocation(x-mx,y-my);
			}
		});
		exButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exButton.setIcon(exb);
			}
			public void mouseExited(MouseEvent e) {
				exButton.setIcon(exb2);
			}
			public void mousePressed(MouseEvent e) {
				setVisible(false);
			}
		});
	}
	class Mypanel extends JPanel {
		Image imgBack;
		Image img;
		int width, height;// MyPanel의 가로,세로 사이즈
		ArrayList<Member> members = new ArrayList();

		Object[][] datas = {};
		
		String[] d1= { "1. 용평", "남경식당", "꿩만두국", "★★★★★"};
		String[] d2= { "2. 용평", "황태회관", "황태찜", "★★★★☆"};
		String[] d3= {  "3. 하이원", "함백산돌솥밥", "돌솥밥", "★★★★★"};
		String[] d4= {  "4. 하이원", "밥상머리", "닭백숙", "★★★☆☆"};
		String[] d5= { "5. 휘닉스", "현대식당", "막국수", "★★★★★"};
		String[] d6= { "6. 휘닉스", "다래한우", "소고기", "★★★★☆"};
		String[] d7= { "7. 웰리힐리", "양지마당", "소고기", "★★★★☆"};
		String[] d8= { "8. 웰리힐리", "청정한우골", "육회", "★★★★☆"};
		String[] d9= { "9. 비발디", "바베큐팩토리", "삼겹살", "★★★★★"};
		String[] d10= { "10.비발디", "해닭", "닭볶음탕", "★★★★☆"};
		String[] d11= { "11.지산", "김네집", "부대찌게", "★★★★☆"};
		String[] d12= { "12.지산", "미스진햄버거", "햄버거", "★★★★☆"};
		
		String[] map= {"https://map.naver.com/?mapmode=0&title=%EB%82%A8%EA%B2%BD%EC%8B%9D%EB%8B%B9&pinId=20306247&pinType=site&lng=1919f0a67f51cf5c780334953eae4ca3&dlevel=10&lat=841a897f355457107ae1983114db71c2&enc=",
				"https://map.naver.com/?mapmode=0&lng=46a9522a6bc8b9b5f1d2de82c226ada5&pinId=11691698&pinType=site&lat=6a4d2fc0a5cabd24df54d8b7ea073a74&dlevel=11&enc=b64",
				"https://map.naver.com/?mapmode=0&lng=0b8b27914318d80c7a6e5c7b757bdaaa&pinId=15570052&lat=d274cd0a3f920ee41c951f8f53909db7&dlevel=11&enc=b64&pinType=site",
				"https://map.naver.com/?query=%ED%95%98%EC%9D%B4%EC%9B%90+%EB%B0%A5%EC%83%81%EB%A8%B8%EB%A6%AC&type=SITE_1",
				"https://map.naver.com/?mapmode=0&lng=29ef8975b68100cb7b3d753c18934d8a&pinId=17622210&lat=6de96f8465d68df6c75659bc6f6a3983&dlevel=11&enc=b64&pinType=site",
				"https://map.naver.com/?query=%ED%9C%98%EB%8B%89%EC%8A%A4+%EB%8B%A4%EB%9E%98%ED%95%9C%EC%9A%B0&type=SITE_1",
				"https://map.naver.com/?mapmode=0&lng=87490d66931514b7e7526fd3b551b09c&pinId=19723482&lat=e656c38e01389401c8e6e446858ec9de&dlevel=11&enc=b64&pinType=site",
				"https://map.naver.com/?mapmode=0&lng=33424ca2d604aa4c7bf302b63666df61&pinId=15520850&lat=2d23b182d378c9f070588077139bf14c&dlevel=11&enc=b64&pinType=site",
				"https://map.naver.com/?mapmode=0&lng=439ee3f52094f300ef2926f47a3b9003&pinId=72953465&lat=696a6ae918d66ceedbab6307b87789cb&dlevel=11&enc=b64&pinType=site",
				"https://map.naver.com/?mapmode=0&lng=9f230f1c3c7f6c11c7acfb755b291408&pinId=13451254&pinType=site&lat=d340bf3da2bb271304d7815e080b9b2d&dlevel=11&enc=b64",
				"https://map.naver.com/?mapmode=0&lng=1cc3f4c2c3bd47509af13e8077cb01ab&pinId=19877777&lat=444530a8c612f9a2a451476db7ea7f11&dlevel=11&enc=b64&pinType=site",
				"https://map.naver.com/?query=%EC%A7%80%EC%82%B0+%EB%AF%B8%EC%8A%A4%EC%A7%84%ED%96%84%EB%B2%84%EA%B1%B0&type=SITE_1"
		};
		public Mypanel() {
			
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			imgBack = toolkit.getImage("img/s18.gif");

			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(0, 3));
			
			setLayout(null);
			exButton.setBorderPainted(false);
			exButton.setContentAreaFilled(false);
			exButton.setFocusPainted(false);
			exButton.setBounds(475,0,25,25);
			add(exButton);
			
			manubar.setBounds(0,0,500,25);
			add(manubar);
	
			img = toolkit.getImage("img/q6.png");
			img = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
			JButton btnYong = new JButton(new ImageIcon(img));
			btnYong.setOpaque(false);
			btnYong.setContentAreaFilled(false);
			btnYong.setBorderPainted(true);
			btnYong.setBorder(BorderFactory.createEmptyBorder());
			panel.add(btnYong);

			img = toolkit.getImage("img/q7.png");
			img = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
			JButton btnHi1 = new JButton(new ImageIcon(img));
			btnHi1.setOpaque(false);
			btnHi1.setContentAreaFilled(false);
			btnHi1.setBorderPainted(true);
			btnHi1.setBorder(BorderFactory.createEmptyBorder());
			panel.add(btnHi1);

			img = toolkit.getImage("img/q3.png");
			img = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
			JButton btnPinic = new JButton(new ImageIcon(img));
			btnPinic.setOpaque(false);
			btnPinic.setContentAreaFilled(false);
			btnPinic.setBorderPainted(true);
			btnPinic.setBorder(BorderFactory.createEmptyBorder());
			panel.add(btnPinic);

			img = toolkit.getImage("img/q5.png");
			img = img.getScaledInstance(160, 130, Image.SCALE_SMOOTH);
			JButton btnJis = new JButton(new ImageIcon(img));
			btnJis.setOpaque(false);
			btnJis.setContentAreaFilled(false);
			btnJis.setBorderPainted(true);
			btnJis.setBorder(BorderFactory.createEmptyBorder());
			panel.add(btnJis);

			img = toolkit.getImage("img/q2.png");
			img = img.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
			JButton btnbibal = new JButton(new ImageIcon(img));
			btnbibal.setOpaque(false);
			btnbibal.setContentAreaFilled(false);
			btnbibal.setBorderPainted(true);
			btnbibal.setBorder(BorderFactory.createEmptyBorder());
			panel.add(btnbibal);

			img = toolkit.getImage("img/q4.png");
			img = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
			JButton btnWeli = new JButton(new ImageIcon(img));
			btnWeli.setOpaque(false);
			btnWeli.setContentAreaFilled(false);
			btnWeli.setBorderPainted(true);
			btnWeli.setBorder(BorderFactory.createEmptyBorder());
			panel.add(btnWeli);

			// (맛집 지도 보기)
			JPanel panel2 = new JPanel();
			Border border = BorderFactory.createTitledBorder("▶▶▶▶▶▶▶스키장 사이트 접속◀◀◀◀◀◀◀");
			Border border2 = BorderFactory.createTitledBorder("▶▶▶▶▶▶▶스키장 맛집 지도◀◀◀◀◀◀◀");

			panel.setBorder(border);
			add(panel);
			panel.setBackground(new Color(255, 255, 255, 127));

			panel2.setBorder(border2);
			add(panel2);
			panel2.setBackground(new Color(255, 255, 255, 127));
			
			panel.setBounds(5,30,490,300);
			panel2.setBounds(5,350,490,330);

			// JTable(맛집지도)
			String[] colNames = { "● 스키장  ●", "● 이름  ●", "● 메뉴  ●", "● 평점  ●" };
			// 테이블안에서 데이터를 관리하는 테이블모델 객체 생성
			DefaultTableModel model = new DefaultTableModel(datas, colNames);
			JTable table = new JTable(model);
			table.setBackground(new Color(255, 255, 255, 127));
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setOpaque(false);
			scrollPane.getViewport().setOpaque(false);
			scrollPane.setPreferredSize(new Dimension(460, 250));
			panel2.add(scrollPane, BorderLayout.CENTER);
			
			model.addRow(d1);
			model.addRow(d2);
			model.addRow(d3);
			model.addRow(d4);
			model.addRow(d5);
			model.addRow(d6);
			model.addRow(d7);
			model.addRow(d8);
			model.addRow(d9);
			model.addRow(d10);
			model.addRow(d11);
			model.addRow(d12);
			
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					for(int i=0;i<12;i++) {
						if(table.getSelectedRow()==i) {
							 try {
									Desktop.getDesktop().browse(new URL(map[i]).toURI());
								} catch (Exception ex) {
								}
						} 
					}
				}
			});

			btnYong.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Desktop.getDesktop().browse(new URL("http://www.yongpyong.co.kr").toURI());
					} catch (Exception e) {
					}
				}
			});
			btnHi1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Desktop.getDesktop().browse(new URL("http://www.high1.com").toURI());
					} catch (Exception e) {
					}
				}
			});
			btnPinic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Desktop.getDesktop().browse(new URL("http://www.phoenixhnr.co.kr").toURI());
					} catch (Exception e) {
					}
				}
			});
			btnWeli.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Desktop.getDesktop().browse(new URL("http://www.wellihillipark.com").toURI());
					} catch (Exception e) {
					}
				}
			});
			btnbibal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Desktop.getDesktop().browse(new URL("http://www.daemyungresort.com").toURI());
					} catch (Exception e) {
					}
				}
			});
			btnJis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Desktop.getDesktop()
						.browse(new URL("http://www.jisanresort.co.kr").toURI());
						
					} catch (Exception e) {
					}
				}
			});
		}
		protected void paintComponent(Graphics g) {
			if (width == 0 || height == 0) {
				width = getWidth();
				height = getHeight();
				// 배경 이미지를 MyPanel만하게 리사이징
				imgBack = imgBack.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			}
			// 배경이미지 그리기
			g.drawImage(imgBack, 0, 0, this);
		}
	}

}
