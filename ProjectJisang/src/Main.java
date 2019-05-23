import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {

	public JLabel manubar = new JLabel(new ImageIcon("img/manubar2.png"));
	public ImageIcon exb =new ImageIcon("img/42.png");
	public ImageIcon exb2 =new ImageIcon("img/40.png");
	public JButton exButton =new JButton(exb2);
	public int mx,my;
	
	public Main() {
		// TODO Auto-generated constructor stub

		Mypanel panel = new Mypanel();
		add(panel, BorderLayout.CENTER);
		setTitle("스키 장터");
		setSize(500, 700);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setFocusable(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
	}// construct
	class Mypanel extends JPanel {
		Image imgBack;
		Image img;
		int width, height;// MyPanel의 가로,세로 사이즈

		public Mypanel() {
			exButton.setBorderPainted(false);
			exButton.setContentAreaFilled(false);
			exButton.setFocusPainted(false);
			exButton.setBounds(475,0,25,25);
			exButton.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					exButton.setIcon(exb);
				}
				public void mouseExited(MouseEvent e) {
					exButton.setIcon(exb2);
				}
				public void mousePressed(MouseEvent e) {
					System.exit(0);
				}
			});
			add(exButton);
			
			manubar.setBounds(0,0,500,25);
			add(manubar);
			
			setLayout(null);
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			imgBack = toolkit.getImage("img/s18.gif");

			img = toolkit.getImage("img/s3_5.png");
			img = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
			JButton btnSeller = new JButton(new ImageIcon(img));
			btnSeller.setOpaque(false);
			btnSeller.setContentAreaFilled(false);
			btnSeller.setBorderPainted(true);
			btnSeller.setBorder(BorderFactory.createEmptyBorder());
			btnSeller.setBounds(0,25,250,340);
			add(btnSeller);

			img = toolkit.getImage("img/s4_2.png");
			img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			JButton btnBuyer = new JButton(new ImageIcon(img));
			btnBuyer.setOpaque(false);
			btnBuyer.setContentAreaFilled(false);
			btnBuyer.setBorderPainted(true);
			btnBuyer.setBorder(BorderFactory.createEmptyBorder());
			btnBuyer.setBounds(250,25,250,340);
			add(btnBuyer);

			img = toolkit.getImage("img/s5_2.png");
			img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			JButton btnNet = new JButton(new ImageIcon(img));
			btnNet.setOpaque(false);
			btnNet.setContentAreaFilled(false);
			btnNet.setBorderPainted(true);
			btnNet.setBorder(BorderFactory.createEmptyBorder());
			btnNet.setBounds(0,365,250,335);
			add(btnNet);

			img = toolkit.getImage("img/s30_1.png");
			img = img.getScaledInstance(110, 110, Image.SCALE_SMOOTH);
			JButton btnGame = new JButton(new ImageIcon(img));
			btnGame.setOpaque(false);
			btnGame.setContentAreaFilled(false);
			btnGame.setBorderPainted(true);
			btnGame.setBorder(BorderFactory.createEmptyBorder());
			btnGame.setBounds(250,365,250,335);
			add(btnGame);

			btnSeller.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new SellerFrame();
				}
			});
			btnBuyer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new BuyerFrame();
				}
			});
			btnNet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new NetFrame();
				}
			});
			btnGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new MusicFrame();
				}
			});
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
}
