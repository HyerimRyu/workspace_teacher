import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import javazoom.jl.player.Player;

public class MusicFrame extends JFrame{
	
	public JLabel manubar = new JLabel(new ImageIcon("img/manubar2.png"));
	public ImageIcon exb =new ImageIcon("img/42.png");
	public ImageIcon exb2 =new ImageIcon("img/40.png");
	public JButton exButton =new JButton(exb2);
	
	public ImageIcon hh11 =new ImageIcon("img/hh1.png");
	public ImageIcon tw11 =new ImageIcon("img/tw111.jpg");
	public ImageIcon tw22 =new ImageIcon("img/tw333.jpg");
	public ImageIcon tw33 =new ImageIcon("img/tw444.jpg");
	public ImageIcon it11 =new ImageIcon("img/xx1.png");
	public ImageIcon it22 =new ImageIcon("img/xx2.png");
	public ImageIcon it33 =new ImageIcon("img/xx3.png");
	public ImageIcon bb1 =new ImageIcon("img/bb11.png");
	public ImageIcon bb2 =new ImageIcon("img/bb22.png");
	public ImageIcon bb3 =new ImageIcon("img/bb33.png");
	public ImageIcon bb4 =new ImageIcon("img/bb44.png");

	public JLabel hh1=new JLabel(hh11);
	public JLabel tw1=new JLabel(tw11);
	public JLabel tw2=new JLabel(tw22);
	public JLabel tw3=new JLabel(tw33);
	public JLabel it1=new JLabel(it11);
	public JLabel it2=new JLabel(it22);
	public JLabel it3=new JLabel(it33);
	
	public JButton bbButton1 =new JButton(bb1);
	public JButton bbButton2 =new JButton(bb2);
	
	ArrayList<Track> tracks =new ArrayList<Track>();
	//Music selectedMusic;
	int mx,my;
	
	public MusicFrame(){
		MyPanel myPanel = new MyPanel();
		add(myPanel, BorderLayout.CENTER);
		setUndecorated(true);
		setFocusable(true);
		setTitle("★★판매자★★");
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
				//System.exit(0);
				setVisible(false);
				//selectedMusic.close();
			}
		});
	}//construct
	class MyPanel extends JPanel {

		Image titleImage;
		Image selectedImage;
		int nowSel=0;	
		Image imgBack;
		int width, height;
		private Object title;
		
		public MyPanel() {
			tracks.add(new Track("xx1.png", "tw1111.png", "tw1111.png", "TWICE_CHEER_UP.mp3", "TWICE_CHEER_UP.mp3"));
			tracks.add(new Track("xx2.png", "tw3333.png", "tw3333.png", "TWICE_LIKEY.mp3", "TWICE_LIKEY.mp3"));
			tracks.add(new Track("xx3.png", "tw4444.png", "tw4444.png", "TWICE_SIGNAL.mp3", "TWICE_SIGNAL.mp3"));
			
			selectedTrack(0);
			setLayout(null);
			exButton.setBorderPainted(false);
			exButton.setContentAreaFilled(false);
			exButton.setFocusPainted(false);
			exButton.setBounds(475,0,25,25);
			add(exButton);
			
			bbButton1.setBorderPainted(false);
			bbButton1.setContentAreaFilled(false);
			bbButton1.setFocusPainted(false);
			bbButton1.setBounds(60,300,100,100);
			bbButton1.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					bbButton1.setIcon(bb3);
				}
				public void mouseExited(MouseEvent e) {
					bbButton1.setIcon(bb1);
				}
				public void mousePressed(MouseEvent e) {
					selectLeft();
				}
			});
			add(bbButton1);
			
			bbButton2.setBorderPainted(false);
			bbButton2.setContentAreaFilled(false);
			bbButton2.setFocusPainted(false);
			bbButton2.setBounds(350,300,100,100);
			bbButton2.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					bbButton2.setIcon(bb4);
				}
				public void mouseExited(MouseEvent e) {
					bbButton2.setIcon(bb2);
				}
				public void mousePressed(MouseEvent e) {
					selectRight(); 
				}
			});
			add(bbButton2);
			
			manubar.setBounds(0,0,500,25);
			add(manubar);
			
			//뮤직타임
			hh1.setBounds(10,10,480,200);
			add(hh1);
			
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			imgBack = toolkit.getImage("img/s18.gif");
		}
		protected void paintComponent(Graphics g) {
			if (width == 0 || height == 0) {
				width = getWidth();
				height = getHeight();

				// 배경 이미지를 MyPanel만하게 리사이징
				imgBack = imgBack.getScaledInstance(width, height, Image.SCALE_SMOOTH);
				titleImage= titleImage.getScaledInstance(480, 120, Image.SCALE_SMOOTH);
				selectedImage=selectedImage.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
			}
			// 이미지 그리기
			g.drawImage(imgBack, 0, 0, this);
			g.drawImage(titleImage, 10, 500, this);
			g.drawImage(selectedImage, 150, 270, this);
		}
		public void selectedTrack(int nowSelected) {
			//if(selectedMusic != null)
				//selectedMusic.close();
			titleImage=new ImageIcon("img/"+tracks.get(nowSelected).getTitle()).getImage();
			selectedImage=new ImageIcon("img/"+tracks.get(nowSelected).getStartI()).getImage();
			//selectedMusic =new Music(tracks.get(nowSelected).getStartM(), true);
			//selectedMusic.start();
		}
		public void selectLeft() {
			if(nowSel==0)
				nowSel =tracks.size()-1;
			else
				nowSel--;
			selectedTrack(nowSel);
		}
		public void selectRight() {
			if(nowSel==0)
				nowSel =tracks.size()-1;
			else
				nowSel++;
			selectedTrack(nowSel);
		}
		
	}
	class Track{
		String title;
		String startI;
		String gameI;
		String startM;
		String gameM;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getStartI() {
			return startI;
		}
		public void setStartI(String startI) {
			this.startI = startI;
		}
		public String getGameI() {
			return gameI;
		}
		public void setGameI(String gameI) {
			this.gameI = gameI;
		}
		public String getStartM() {
			return startM;
		}
		public void setStartM(String startM) {
			this.startM = startM;
		}
		public String getGameM() {
			return gameM;
		}
		public void setGameM(String gameM) {
			this.gameM = gameM;
		}
		public Track(String title, String startI, String gameI, String startM, String gameM) {
			super();
			this.title = title;
			this.startI = startI;
			this.gameI = gameI;
			this.startM = startM;
			this.gameM = gameM;
		}
	}
}
// class Music extends Thread{
//	 Player player;
//	 boolean isLoop;
//	 File file;
//	 FileInputStream fis;
//	 BufferedInputStream bis;
//	
//	public Music(String name, boolean isLoop) {
//		try {
//			this.isLoop= isLoop;
//			file =new File("music/"+name);
//			fis =new FileInputStream(file);
//			bis =new BufferedInputStream(fis);
//			player=new Player(bis);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//	public int getTime() {
//		if(player==null)
//			return 0;
//		return player.getPosition();
//	}
//	public void close() {
//		isLoop= false;
//		player.close();
//		this.interrupt();
//	}
//	public void run() {
//		try {
//			do {
//				player.play();
//				fis =new FileInputStream(file);
//				bis =new BufferedInputStream(fis);
//				player=new Player(bis);
//			}while(isLoop);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//}
// 
