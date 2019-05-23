import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Spliterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class SellerFrame extends JFrame {

	Image imgBack;
	int width, height;
	ArrayList<Member> members = new ArrayList();
	
	int money;
	String[] str1 = new String[] { "● BRAND ●", "ATOMIC", "SALOMON", "ROCCIGNOL", "FISCHER", "BLIZZAD" };
	String[] str2 = new String[] { "● TYPE ●", "SKI", "BOOTS", "HELMET", "GOGGLES", "GLOVES" };
	String[] str3 = new String[] { "● SEASON ●", "13~14", "14~15", "15~16", "16~17", "17~18", };

	JComboBox<String> comboBox1 = new JComboBox();
	JComboBox<String> comboBox2 = new JComboBox();
	JComboBox<String> comboBox3 = new JComboBox();
	JTextField tf = new JTextField(5);
	
	public JLabel manubar = new JLabel(new ImageIcon("img/manubar2.png"));
	public JLabel price = new JLabel(new ImageIcon("img/price.png"));
	
	public ImageIcon fin =new ImageIcon("img/fin.png");
	public ImageIcon pl =new ImageIcon("img/sell3.png");
	public ImageIcon zz =new ImageIcon("img/38.png");
	public ImageIcon exb =new ImageIcon("img/42.png");
	public ImageIcon exb2 =new ImageIcon("img/40.png");
	public JButton exButton =new JButton(exb2);
	public JButton zzButton =new JButton(zz);
	public JButton plButton =new JButton(pl);
	public JButton finButton =new JButton(fin);
	public int mx,my;
	
	public JTextArea textArea;
	public JTextField tfMsg;
	public JButton btnSend;
	ServerSocket serverSocket;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	Socket socket2;
	DataInputStream dis2;
	DataOutputStream dos2;
	ServerThread serverThread;

	public SellerFrame() {
		SkiPanel skiPanel = new SkiPanel();
		add(skiPanel, BorderLayout.CENTER);
		setUndecorated(true);
		setFocusable(true);
		setTitle("★★판매자★★");
		setSize(500, 700);
		setLocation(120, 180);
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
	class SkiPanel extends JPanel {	
		public SkiPanel() {
			// TODO Auto-generated constructor stub
			setLayout(null);
			exButton.setBorderPainted(false);
			exButton.setContentAreaFilled(false);
			exButton.setFocusPainted(false);
			exButton.setBounds(475,0,25,25);
			add(exButton);
			
			manubar.setBounds(0,0,500,25);
			add(manubar);

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			imgBack = toolkit.getImage("img/s18.gif");

			JPanel p = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			
			p.setBounds(5,30,490,140);
			p2.setBounds(5,180,490,260);
			p3.setBounds(5,450,490,235);
			p.setLayout(null);
			p3.setLayout(null);
			
			Border border = BorderFactory.createTitledBorder("▶▶▶▶▶▶▶판매 정보 입력◀◀◀◀◀◀◀");
			Border border2 = BorderFactory.createTitledBorder("▶▶▶▶▶▶▶물품 정보 리스트◀◀◀◀◀◀◀");
			Border border3 = BorderFactory.createTitledBorder("▶▶▶▶▶▶▶직거래 대화창◀◀◀◀◀◀◀");

			p.setBorder(border);
			p2.setBorder(border2);
			p3.setBorder(border3);
			
			p.setBackground(new Color(255, 255, 255, 127));
			p2.setBackground(new Color(255, 255, 255, 127));
			p3.setBackground(new Color(255, 255, 255, 127));

			add(p);
			add(p2);
			add(p3);

			for (int i = 0; i < 6; i++) {
				comboBox1.addItem(str1[i]);
				comboBox2.addItem(str2[i]);
				comboBox3.addItem(str3[i]);
			}
			
			String[] colNames = { "● BRAND ●", "● TYPE ●", "● SEASON ●", "● PRICE ●" };
			// 테이블안에서 데이터를 관리하는 테이블모델 객체 생성
			DefaultTableModel model = new DefaultTableModel(colNames, 0);
			JTable table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setBackground(new Color(255, 255, 255, 127));
			scrollPane.setOpaque(false);
			scrollPane.getViewport().setOpaque(false);
			scrollPane.setPreferredSize(new Dimension(460, 220));
			p2.add(scrollPane);
			
			finButton.setBounds(250,190,200,30);
			finButton.setBorderPainted(false);
			finButton.setContentAreaFilled(false);
			finButton.setFocusPainted(false);
			scrollPane.add(finButton);
			finButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					File file1=new File("files/brand.txt");
					File file2=new File("files/type.txt");
					File file3=new File("files/season.txt");
					File file4=new File("files/money.txt");
					
					try {
						FileReader fr1= new FileReader(file1);
						FileReader fr2= new FileReader(file2);
						FileReader fr3= new FileReader(file3);
						FileReader fr4= new FileReader(file4);
						
						BufferedReader reader1=new BufferedReader(fr1);
						BufferedReader reader2=new BufferedReader(fr2);
						BufferedReader reader3=new BufferedReader(fr3);
						BufferedReader reader4=new BufferedReader(fr4);
						//한줄 단위 읽어들이기.
						String line1=reader1.readLine();
						String line2=reader2.readLine();
						String line3=reader3.readLine();
						String line4=reader4.readLine();
						members.add(new Member(line1, line2, line3, line4));
						while(line1!=null&&line1!=null&&line1!=null&&line1!=null) {
							//읽어들인 문자열을 ArrayList에 추가
							members.add(new Member(line1, line2, line3, line4));
							line1= reader1.readLine();
							line2= reader2.readLine();
							line3= reader3.readLine();
							line4= reader4.readLine();
						}
						for(int i=0;i<members.size();i++) {
							members.get(i).aaa();
							model.addRow(members.get(i).aaa());
						}
						reader1.close();
						reader2.close();
						reader3.close();
						reader4.close();		
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			//채팅창 생성
			textArea=new JTextArea();
			textArea.setEditable(false);
			textArea.setOpaque(false);

			JScrollPane scrollPane2=new JScrollPane(textArea);
			scrollPane2.setBounds(10,20,470,170);
			scrollPane2.setOpaque(false);
			scrollPane2.getViewport().setOpaque(false);
			p3.add(scrollPane2);
			
			tfMsg=new JTextField();
			tfMsg.setBounds(10,200,430,25);
			zzButton.setBounds(445,200,30,30);
			zzButton.setBorderPainted(false);
			zzButton.setContentAreaFilled(false);
			zzButton.setFocusPainted(false);
			p3.add(tfMsg);
			p3.add(zzButton);
			
			//서버구축작업을 수행하는 객체(ServerThread)를 생성
			serverThread =new ServerThread();
			serverThread.setDaemon(true);
			serverThread.start();
			
			//상품 올리기
			plButton.setBorderPainted(false);
			plButton.setContentAreaFilled(false);
			plButton.setFocusPainted(false);
			plButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String brand = comboBox1.getSelectedItem().toString();
					String type = comboBox2.getSelectedItem().toString();
					String season = comboBox3.getSelectedItem().toString();
					String money = tf.getText();
					try {
						int a = Integer.parseInt(money);
						members.add(new Member(brand, type, season, money));		
					} catch (Exception e) {
						JOptionPane.showMessageDialog(table, "잘못된 가격입니다.");
						return;
					}
					sendSki();
					String[] row = new String[] { brand, type, season, money };
					model.addRow(row);				
					tf.setText("");
				}
			});
			//send버튼이 눌러졌을때 ,. 클라이언트에게 메세지 전송
			zzButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					sendMessage();
				}
			});
	
			comboBox1.setFont(new Font("OptimusPrinceps", Font.BOLD, 12));
			comboBox2.setFont(new Font("OptimusPrinceps", Font.BOLD, 12));
			comboBox3.setFont(new Font("OptimusPrinceps", Font.BOLD, 12));
			
			comboBox1.setBounds(30,30,100,30);
			comboBox2.setBounds(200,30,100,30);
			comboBox3.setBounds(360,30,100,30);
			price.setBounds(150,90,40,30);
			tf.setBounds(200,95,80,25);
			plButton.setBounds(280,92,50,30);
			
			p.add(comboBox1);
			p.add(comboBox2);
			p.add(comboBox3);
			p.add(price);
			p.add(tf);
			p.add(plButton);
		
		}
		//메세지 전송 작업 메소드
		void sendMessage() {
			String msg=tfMsg.getText();
			tfMsg.setText("");
			//네 메세지창에 글 추가....
			
			textArea.append("[ 판매자☞ ] : "+msg+"\n");
			//상대방에게 메세지 전송
			new Thread() {
				public void run() {
					if(dos==null) return;
					
					try {
						dos.writeInt(1);
						dos.writeUTF(msg);
						//dos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}.start();
		}
		//상대방에게 상품정보 전송
		public void sendSki() {
			String brand = comboBox1.getSelectedItem().toString();
			String type = comboBox2.getSelectedItem().toString();
			String season = comboBox3.getSelectedItem().toString();
			String money = tf.getText();
			
			new Thread() {
				public void run() {
					if(dos==null) return;
					try {
						
						dos.writeInt(2);
						dos.writeUTF(brand);
						dos.writeUTF(type);
						dos.writeUTF(season);
						dos.writeUTF(money);	
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				};
			}.start();
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
	class ServerThread extends Thread{
		@Override
		public void run() {
			try {
				serverSocket=new ServerSocket(10033);
				textArea.append("구매자의 접속을 기다립니다..\n");
				socket= serverSocket.accept();//접속할때까지 대기..
				textArea.append("●구매자와 연결되었습니다●\n");

				 InputStream is= socket.getInputStream();
				 OutputStream os= socket.getOutputStream();
				
				 dis=new DataInputStream(is);
				 dos=new DataOutputStream(os);
				 
				 while(true) {
					 String msg=dis.readUTF();//클라이언트가 메세지를 보내면
					 textArea.append("[ 구매자☜ ] : "+msg+"\n");
				 }
				
			} catch (Exception e) {
				textArea.append("판매자와의 연결이 끊어졌습니다.");
			}
		}
	}
}
class Member {
	String brand;
	String type;
	String season;
	String money;

	public Member(String brand, String type, String season, String money) {
		// TODO Auto-generated constructor stub
		this.brand = brand;
		this.type = type;
		this.season = season;
		this.money = money;
	}
	public String[] aaa() {
		return new String[] {brand,type, season, money};
	}
}
