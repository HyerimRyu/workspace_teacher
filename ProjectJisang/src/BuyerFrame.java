import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class BuyerFrame extends JFrame {

	public JLabel manubar = new JLabel(new ImageIcon("img/manubar2.png"));
	public JLabel ski = new JLabel(new ImageIcon("img/sk11.png"));
	public JLabel boots = new JLabel(new ImageIcon("img/sk22.png"));
	public JLabel helmet= new JLabel(new ImageIcon("img/sk33.png"));
	public JLabel goggles = new JLabel(new ImageIcon("img/sk44.png"));
	public JLabel gloves = new JLabel(new ImageIcon("img/sk55.png"));
	
	public ImageIcon buy =new ImageIcon("img/buy4.png");
	public ImageIcon pl =new ImageIcon("img/46.png");
	public ImageIcon zz =new ImageIcon("img/38.png");
	public ImageIcon exb =new ImageIcon("img/42.png");
	public ImageIcon exb2 =new ImageIcon("img/40.png");
	
	public JButton exButton =new JButton(exb2);
	public JButton zzButton =new JButton(zz);
	public JButton plButton =new JButton(pl);
	public JButton buyButton =new JButton(buy);
	
	public int mx,my;
	
	public JTextArea textArea;
	public JTextField tfMsg;
	public Socket socket;
	public DataInputStream dis;
	public DataOutputStream dos;
	public Socket socket2;
	public DataInputStream dis2;
	public DataOutputStream dos2;
	
	ArrayList<Member> members = new ArrayList();
	String[] colNames = { "● BRAND ●", "● TYPE ●", "● SEASON ●", "● PRICE ●" };
	DefaultTableModel model = new DefaultTableModel(colNames, 0);
	JTable table = new JTable(model);

	public BuyerFrame() {
		// TODO Auto-generated constructor stub
		SkiPanel skiPanel = new SkiPanel();
		add(skiPanel, BorderLayout.CENTER);

		setUndecorated(true);
		setFocusable(true);
		setLocationRelativeTo(null);
		setTitle("★★구매자★★");
		setSize(500, 700);
		setLocation(660, 180);
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
		
		Image imgBack;
		int width, height;

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
			
			Border border = BorderFactory.createTitledBorder("▶▶▶▶▶▶▶구매한 물품 리스트◀◀◀◀◀◀◀");
			Border border2 = BorderFactory.createTitledBorder("▶▶▶▶▶▶▶물품 정보 리스트◀◀◀◀◀◀◀");
			Border border3 = BorderFactory.createTitledBorder("▶▶▶▶▶▶▶직거래 대화창◀◀◀◀◀◀◀");
			
			JPanel p = new JPanel();
			p.setLayout(new FlowLayout());
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			p3.setLayout(null);
			p.setBounds(5,30,490,140);
			p2.setBounds(5,180,490,260);
			p3.setBounds(5,450,490,235);
			
			p.setBorder(border);
			p2.setBorder(border2);
			p3.setBorder(border3);
			
			p.setBackground(new Color(255, 255, 255, 127));
			p2.setBackground(new Color(255, 255, 255, 127));
			p3.setBackground(new Color(255, 255, 255, 127));

			add(p);
			add(p2);
			add(p3);
		
			buyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int rowNum= table.getSelectedRow();
						if(model.getValueAt(rowNum, 1).equals("SKI")) {
							p.add(ski);
							SkiPanel.this.revalidate();
							SkiPanel.this.repaint();
						}else if(model.getValueAt(rowNum, 1).equals("BOOTS")) {
							p.add(boots);
							SkiPanel.this.revalidate();
							SkiPanel.this.repaint();
						}else if(model.getValueAt(rowNum, 1).equals("HELMET")) {
							p.add(helmet);
							SkiPanel.this.revalidate();
							SkiPanel.this.repaint();
						}else if(model.getValueAt(rowNum, 1).equals("GOGGLES")) {
							p.add(goggles);
							SkiPanel.this.revalidate();
							SkiPanel.this.repaint();
						}else if(model.getValueAt(rowNum, 1).equals("GLOVES")) {
							p.add(gloves);
							SkiPanel.this.revalidate();
							SkiPanel.this.repaint();
						}
						
						File path=new File("files");
						if(!path.isDirectory()) path.mkdirs();
						File bra=new File(path, "brand.txt");
						File typ=new File(path, "type.txt");
						File sea=new File(path, "season.txt");
						File mon=new File(path, "money.txt");
						for(int i=0;i<members.size();i++) {
							try {
								FileWriter fw1=new FileWriter(bra, true);//두번째 파라미터: append할지 여부
								FileWriter fw2=new FileWriter(typ, true);
								FileWriter fw3=new FileWriter(sea, true);
								FileWriter fw4=new FileWriter(mon, true);

								PrintWriter writer1= new PrintWriter(fw1);
								PrintWriter writer2= new PrintWriter(fw2);
								PrintWriter writer3= new PrintWriter(fw3);
								PrintWriter writer4= new PrintWriter(fw4);
								if(rowNum==i) {
								writer1.println(members.get(i).brand);
								writer2.println(members.get(i).type);
								writer3.println(members.get(i).season);
								writer4.println(members.get(i).money);
								}
								writer1.flush();
								writer1.close();
								writer2.flush();
								writer2.close();
								writer3.flush();
								writer3.close();
								writer4.flush();
								writer4.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					model.removeRow(rowNum);
					members.remove(rowNum);
				}
			});
			
			JScrollPane scrollPane = new JScrollPane(table);
			table.setBackground(new Color(255, 255, 255, 127));
			scrollPane.setOpaque(false);
			scrollPane.getViewport().setOpaque(false);
			p2.add(scrollPane);
			scrollPane.add(buyButton);
			buyButton.setBorderPainted(false);
			buyButton.setContentAreaFilled(false);
			buyButton.setFocusPainted(false);
			scrollPane.setPreferredSize(new Dimension(460, 220));
			buyButton.setBounds(410,170,50,50);
			
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
			
			//서버와 연결작업 스레드 생성 및 실행
			ClientThread thread=new ClientThread();
			thread.start();
			
			//send버튼 
			zzButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					sendMessage();
				}
			});
		}
		public void sendMessage() {
			String msg=tfMsg.getText();
			tfMsg.setText("");
			//네 메세지창에 글 추가....
			
			textArea.append("[ 구매자☞ ] : "+msg+"\n");
			
			//상대방에게 메세지 전송
			new Thread() {
				public void run() {
					if(dos==null) return;		
					try {
						dos.writeUTF(msg);
						dos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}.start();
		}
		protected void paintComponent(Graphics g) {
			if (width == 0 || height == 0) {
				width = getWidth();
				height = getHeight();
				imgBack = imgBack.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			}
			g.drawImage(imgBack, 0, 0, this);
		}
	}
	class ClientThread extends Thread{
		@Override
		public void run() {
			try {
				socket=new Socket("127.0.0.1", 10033);
				textArea.append("●판매자와 연결되었습니다●\n");
				
				dis= new DataInputStream(socket.getInputStream());
				dos= new DataOutputStream(socket.getOutputStream());
				
				while(true) {
					int a=dis.readInt();
					if(a==2) {
						String brand=dis.readUTF();
						String type=dis.readUTF();
						String season=dis.readUTF();
						String money=dis.readUTF();
				
						members.add(new Member2(brand, type, season, money));

						String[] row = new String[] { brand, type, season, money };
						model.addRow(row);
					}else if(a==1) {
						String msg=dis.readUTF();
						textArea.append("[ 판매자☜ ] : "+msg+"\n");
					}
				}
			} catch (Exception e) {
				textArea.append("연결실패 or 연결 종료");
			}
		}
	}
	class Member2 extends Member{
		public Member2(String brand, String type, String season, String money) {
			super(brand, type, season, money);
			// TODO Auto-generated constructor stub
		}
		String brand;
		String type;
		String season;
		String money;
	}
}
