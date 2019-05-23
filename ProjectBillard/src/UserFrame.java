import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserFrame extends JFrame {
	
	private static int tableCnt=0;
	
	Socket socket;
	DataInputStream billiardDIS;
	DataOutputStream billiardDOS;
	UserBTN userBTN;
	
	private FileReader billiardFileReader;
	
	private StopWatch tableTimer;

	private boolean start=false, end=false, reset=false;
	
	public UserFrame() {
		// TODO Auto-generated constructor stub
		tableCnt++;
		new ClientThread().start();
		
		Toolkit toolkit= Toolkit.getDefaultToolkit();
		setIconImage(toolkit.getImage("images/FrameIcon.png"));
		
		JPanel userPanel = new JPanel();
		userPanel.setLayout(new BorderLayout());
		
		TimeThread timeThread = new TimeThread();
		timeThread.setDaemon(true);
		timeThread.start();

		userPanel.add(timeThread.getTimeLabel(), BorderLayout.NORTH);
		
		JPanel userControlPanel= new JPanel();
		userControlPanel.setLayout(new BorderLayout());
		
		JPanel controlPanel = new JPanel();	
		userBTN= new UserBTN(controlPanel);
		userBTN.gameThread.start();

		controlPanel.setLayout(new BorderLayout());
		controlPanel.add(userBTN, BorderLayout.NORTH);
		controlPanel.setBackground(new Color(0, 104, 56));
		
		userControlPanel.add(controlPanel, BorderLayout.CENTER);
		userPanel.add(userControlPanel, BorderLayout.CENTER);
		
		add(userPanel);
		setTitle("User");
		setBounds(100, 100, 300, 400);
		setVisible(true);
	}
	
	public void gameStart() {
		start= true;
		end= false;
		reset=false;
	}
	
	public void gameEnd() {
		start= false;
		end= true;
		reset= false;
	}
	
	public void gameReset() {
		start= false;
		end= false;
		reset= true;
	}
	
	class UserBTN extends JButton {

		JPanel controlPanel;
		StopWatch tableTimer;
		InThread gameThread;
			
		public UserBTN(JPanel controlPanel) {
			// TODO Auto-generated constructor stub
			this.controlPanel= controlPanel;
			
			setBackground(Color.WHITE);
			setForeground(new Color(0, 104, 56));
			setFont(new Font("mexcellent 3d", Font.PLAIN, 30));
			setText("START");
			setFocusPainted(false);

			gameThread = new InThread();

			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub

					if (userBTN.getText().equals("START")) {
						gameStart();
						new OutThread().start();
						newTableTimer();
						controlPanel.add(tableTimer.getStopWatchPanel(), BorderLayout.CENTER);
						tableTimer.getStopWatchPanel().setBackground(new Color(0, 104, 56));
						tableTimer.getChargeLabel().setForeground(Color.WHITE);
						tableTimer.getStopWatchLabel().setFont(new Font("NanumGothicBold", Font.BOLD, 50));
						tableTimer.getChargeLabel().setFont(new Font("NanumGothicBold", Font.BOLD, 30));
						tableTimer.getStopWatchLabel().setForeground(Color.WHITE);
						tableTimer.setDaemon(true);
						userBTN.setText("END");
						tableTimer.start();
					} else if (userBTN.getText().equals("END")) {
						gameEnd();
						new OutThread().start();
						userBTN.setText("RESET");
						tableTimer.setIsRun(false);
					} else {
						gameReset();
						new OutThread().start();
						userBTN.setText("START");
						tableTimer.getStopWatchLabel().setText("");
						tableTimer.getChargeLabel().setText("");
					}
				}

				void newTableTimer() {
					try {
						if(tableCnt==3 || tableCnt==6) {
							billiardFileReader = new FileReader("Text/Pocket.txt");
							tableTimer = new StopWatch(billiardFileReader);
						} else {
							billiardFileReader = new FileReader("Text/Four.txt");
							tableTimer = new StopWatch(billiardFileReader);
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});
		}
		
		class InThread extends Thread {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (true) {
						if(billiardDIS!=null) {
							start = billiardDIS.readBoolean();
							end = billiardDIS.readBoolean();
							reset = billiardDIS.readBoolean();
	
							if (start) {
								newTableTimer();
								controlPanel.add(tableTimer.getStopWatchPanel(), BorderLayout.CENTER);
								tableTimer.getStopWatchPanel().setBackground(new Color(0, 104, 56));
								tableTimer.getStopWatchLabel().setFont(new Font("NanumGothicBold", Font.BOLD, 50));
								tableTimer.getChargeLabel().setFont(new Font("NanumGothicBold", Font.BOLD, 30));
								tableTimer.getChargeLabel().setForeground(Color.WHITE);
								tableTimer.getStopWatchLabel().setForeground(Color.WHITE);
								tableTimer.setDaemon(true);
								setText("END");
								tableTimer.start();
							} else if (end) {
								setText("RESET");
								tableTimer.setIsRun(false);
							} else {
								setText("START");
								tableTimer.getStopWatchLabel().setText("");
								tableTimer.getChargeLabel().setText("");
							}
						}
						Thread.sleep(100);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			void newTableTimer() {
				try {
					if(tableCnt==3 || tableCnt==6) {
						billiardFileReader = new FileReader("Text/Pocket.txt");
						tableTimer = new StopWatch(billiardFileReader);
					} else {
						billiardFileReader = new FileReader("Text/Four.txt");
						tableTimer = new StopWatch(billiardFileReader);
					}
					

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		
	}
	
	class ClientThread extends Thread {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			StartFrame.addTableAssign();
			try {
				if(StartFrame.getTableAssign()<7) {
					socket= new Socket("localhost", 10001);
					System.out.println("접속성공");
					
					billiardDIS= new DataInputStream( socket.getInputStream() );
					billiardDOS= new DataOutputStream( socket.getOutputStream() );
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	class OutThread extends Thread {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				billiardDOS.writeBoolean(start);
				billiardDOS.writeBoolean(end);
				billiardDOS.writeBoolean(reset);
				billiardDOS.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
}
