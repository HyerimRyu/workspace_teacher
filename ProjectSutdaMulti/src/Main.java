import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {
	
	Panel1 mainPanel;
	SinglePlay singlePlay;
	JLabel startImg;
	Image imgBack;
	JButton[] startBtns = new JButton[6];
	
	MultiPlay multiPlay;
	ClientRoom clientRoom;

	
	public Main() {
		// TODO Auto-generated constructor stub
		setTitle("섯다");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,1080,760);
		
		setBackground(Color.BLACK);
		setResizable(false);
		mainPanel = new Panel1();
		add(mainPanel);

		setVisible(true);
		
	}
	
	//질문하기
	void convertToSinglePlay() {
		getContentPane().removeAll();
		singlePlay = new SinglePlay();
		add(singlePlay);
		
		revalidate();
		
		repaint();
		
		
	}
	
	void convertToMultiPlay() {
			
		clientRoom = new ClientRoom(this);
		
		
	}
	
	
	
	
	class Panel1 extends JPanel{
		int width, height;
		
		public Panel1() {
			// TODO Auto-generated constructor stub
			setLayout(null);

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			imgBack = toolkit.getImage("images/start.jpg");
			setBackground(Color.BLACK);
			
			
			startBtns[0] = new JButton("SinglePlay");startBtns[0].setSize(170, 40);startBtns[0].setLocation(830,410);
			startBtns[1] = new JButton("MultiPlay");startBtns[1].setSize(160, 40);startBtns[1].setLocation(837,450);
			startBtns[2] = new JButton("Setting");startBtns[2].setSize(170, 40);startBtns[2].setLocation(848,490);
			startBtns[3] = new JButton("Exit");startBtns[3].setSize(160, 40);startBtns[3].setLocation(872,530);
			
			for (int i=0;i<4;i++) {
				startBtns[i].setFont(new Font("Times New Roman",Font.BOLD ,30 ));
				startBtns[i].setForeground(Color.white);
				startBtns[i].setContentAreaFilled(false);
				startBtns[i].setBorderPainted(false);
				startBtns[i].setFocusPainted(false);
				startBtns[i].setBackground(Color.black);
			}
			
			
			startBtns[0].addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {	
					startBtns[0].setForeground(new Color(0xFFA500));
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					startBtns[0].setForeground(new Color(0xFFA500));
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					startBtns[0].setForeground(Color.white);
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					startBtns[0].setForeground(new Color(0xFFA500));
				}
				
				public void mouseClicked(MouseEvent arg0) {
					startBtns[0].setForeground(new Color(0xFFA500));
					
					convertToSinglePlay();

				}
			});
			add(startBtns[0]);
			
			
			startBtns[1].addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {	
					startBtns[1].setForeground(new Color(0xFFA500));
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					startBtns[1].setForeground(new Color(0xFFA500));
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					startBtns[1].setForeground(Color.white);
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					startBtns[1].setForeground(new Color(0xFFA500));
				}
				
				public void mouseClicked(MouseEvent arg0) {
					startBtns[1].setForeground(new Color(0xFFA500));
					
					convertToMultiPlay();

				}
			});
			add(startBtns[1]);
			
			
			
			startBtns[2].addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
					startBtns[2].setForeground(new Color(0xFFA500));
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					startBtns[2].setForeground(new Color(0xFFA500));
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					startBtns[2].setForeground(Color.white);
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					startBtns[2].setForeground(new Color(0xFFA500));

				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					startBtns[2].setForeground(new Color(0xFFA500));

				}
			});
			add(startBtns[2]);
			
			
			startBtns[3].addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {	
					startBtns[3].setForeground(new Color(0xFFA500));
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					startBtns[3].setForeground(new Color(0xFFA500));
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					startBtns[3].setForeground(Color.white);
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					startBtns[3].setForeground(new Color(0xFFA500));
				}
				
				public void mouseClicked(MouseEvent arg0) {
					startBtns[3].setForeground(new Color(0xFFA500));
				}
			});
			add(startBtns[3]);
				
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			if (width == 0 || height ==0) {
				width = getWidth();
				height = getHeight();
				
				imgBack=imgBack.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
			}
			g.drawImage(imgBack, 0, 0, this);			
			
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Main main = new Main();
		
		
	}
	
	

}
