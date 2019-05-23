import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StartFrame extends JFrame {

	private static int tableAssign = 0;
	private static int tableAcceptCnt = 0;
	
	private ArrayList<BilliardCount> tableDatas = new ArrayList<>();
	private FileReader billiardFileReader;

	private boolean start = false, end = false, reset = false;

	private ServerSocket serverSocket;
	private Socket client;

	private BTNTable btnTable1, btnTable2, btnTable3, btnTable4, btnTable5, btnTable6;

	private DataInputStream billiardDIS;
	private DataOutputStream billiardDOS;

	private int gameCount = 0;

	public StartFrame() {

		new ServerThread().start();

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		setIconImage(toolkit.getImage("images/StartIcon.png"));

		JPanel startPanel = new JPanel();
		startPanel.setLayout(new BorderLayout());

		TimeThread timeThread = new TimeThread();
		timeThread.setDaemon(true);
		timeThread.start();

		startPanel.add(timeThread.getTimeLabel(), BorderLayout.NORTH);

		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(2, 3));

		JPanel tablePanel1 = new JPanel();
		btnTable1 = new BTNTable(tablePanel1, 1);

		tablePanel1.setLayout(new BorderLayout());
		tablePanel1.add(btnTable1, BorderLayout.NORTH);
		tablePanel1.setBackground(Color.WHITE);
		tablePanel1.setBorder(BorderFactory.createTitledBorder("1번 테이블 # 4구 / 3구"));

		JPanel tablePanel2 = new JPanel();
		btnTable2 = new BTNTable(tablePanel2, 2);
		tablePanel2.setLayout(new BorderLayout());
		tablePanel2.add(btnTable2, BorderLayout.NORTH);
		tablePanel2.setBackground(Color.WHITE);
		tablePanel2.setBorder(BorderFactory.createTitledBorder("2번 테이블 # 4구 / 3구"));

		JPanel tablePanel3 = new JPanel();
		btnTable3 = new BTNTable(tablePanel3, 3);
		tablePanel3.setLayout(new BorderLayout());
		tablePanel3.add(btnTable3, BorderLayout.NORTH);
		tablePanel3.setBackground(Color.WHITE);
		tablePanel3.setBorder(BorderFactory.createTitledBorder("3번 테이블 # 포켓볼"));

		JPanel tablePanel4 = new JPanel();
		btnTable4 = new BTNTable(tablePanel4, 4);
		tablePanel4.setLayout(new BorderLayout());
		tablePanel4.add(btnTable4, BorderLayout.NORTH);
		tablePanel4.setBackground(Color.WHITE);
		tablePanel4.setBorder(BorderFactory.createTitledBorder("4번 테이블 # 4구 / 3구"));

		JPanel tablePanel5 = new JPanel();
		btnTable5 = new BTNTable(tablePanel5, 5);
		tablePanel5.setLayout(new BorderLayout());
		tablePanel5.add(btnTable5, BorderLayout.NORTH);
		tablePanel5.setBackground(Color.WHITE);
		tablePanel5.setBorder(BorderFactory.createTitledBorder("5번 테이블 # 4구 / 3구"));

		JPanel tablePanel6 = new JPanel();
		btnTable6 = new BTNTable(tablePanel6, 6);
		tablePanel6.setLayout(new BorderLayout());
		tablePanel6.add(btnTable6, BorderLayout.NORTH);
		tablePanel6.setBackground(Color.WHITE);
		tablePanel6.setBorder(BorderFactory.createTitledBorder("6번 테이블 # 포켓볼"));

		tablePanel.add(tablePanel1);
		tablePanel.add(tablePanel2);
		tablePanel.add(tablePanel3);
		tablePanel.add(tablePanel4);
		tablePanel.add(tablePanel5);
		tablePanel.add(tablePanel6);

		startPanel.add(tablePanel, BorderLayout.CENTER);

		JButton btnExit = new JButton();
		btnExit.setForeground(new Color(0, 104, 56));
		btnExit.setBackground(Color.WHITE);
		btnExit.setFont(new Font("mexcellent 3d", Font.PLAIN, 30));
		btnTable1.setFocusPainted(false);
		btnExit.setText("CLOSE");

		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new BilliardClose();
			}
		});

		startPanel.add(btnExit, BorderLayout.SOUTH);

		add(startPanel);
		setTitle("Start");
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setVisible(true);
	}

	public static int getTableAssign() {
		return tableAssign;
	}

	public static void addTableAssign() {
		StartFrame.tableAssign += 1;
	}

	public static void delTableAssign() {
		StartFrame.tableAssign -= 1;
	}

	public void gameStart() {
		start = true;
		end = false;
		reset = false;
	}

	public void gameEnd() {
		start = false;
		end = true;
		reset = false;
	}

	public void gameReset() {
		start = false;
		end = false;
		reset = true;
	}

	class BTNTable extends JButton {

		private StopWatch tableTimer;
		private JPanel tablePanel;
		private int tableNum;
		private InThread gameThread;
		
		DataOutputStream gameDOS;
		DataInputStream gameDIS;

		public BTNTable(JPanel tablePanel, int tableNum) {
			// TODO Auto-generated constructor stub
			
			this.tablePanel = tablePanel;
			this.tableNum = tableNum;
			setBackground(Color.WHITE);
			setForeground(new Color(0, 104, 56));
			setFont(new Font("mexcellent 3d", Font.PLAIN, 30));
			setText("START");
			setFocusPainted(false);

			gameThread = new InThread();
			gameThread.start();

			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					if (getText().equals("START")) {
						gameStart();
						if(gameDOS!=null) new OutThread(gameDOS).start();
						newTableTimer();
						tablePanel.add(tableTimer.getStopWatchPanel(), BorderLayout.CENTER);
						tableTimer.getStopWatchPanel().setBackground(new Color(0, 104, 56));
						tableTimer.getChargeLabel().setForeground(Color.WHITE);
						tableTimer.getStopWatchLabel().setForeground(Color.WHITE);
						tableTimer.setDaemon(true);
						setText("END");
						tableTimer.start();
					} else if (getText().equals("END")) {
						gameEnd();
						if(gameDOS!=null) new OutThread(gameDOS).start();
						gameCount++;
						setText("RESET");
						tableTimer.setIsRun(false);
						BilliardCount billiardCount = new BilliardCount(gameCount, tableNum,
								tableTimer.getStopWatchLabel().getText(), tableTimer.getCharge());
						tableDatas.add(billiardCount);
					} else {
						gameReset();
						if(gameDOS!=null) new OutThread(gameDOS).start();
						setText("START");
						tableTimer.getStopWatchLabel().setText("");
						tableTimer.getChargeLabel().setText("");
					}
				}

				void newTableTimer() {
					try {
						billiardFileReader = new FileReader("Text/Four.txt");
						tableTimer = new StopWatch(billiardFileReader);

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});
		}
		
		public DataOutputStream getGameDOS() {
			return gameDOS;
		}

		public void setGameDOS(DataOutputStream gameDOS) {
			this.gameDOS = gameDOS;
		}

		public DataInputStream getGameDIS() {
			return gameDIS;
		}

		public void setGameDIS(DataInputStream gameDIS) {
			this.gameDIS = gameDIS;
		}
		
		class InThread extends Thread {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					
					while (true) {
						if(gameDIS!=null) {
							start = gameDIS.readBoolean();
							end = gameDIS.readBoolean();
							reset = gameDIS.readBoolean();
	
							if (start) {
								newTableTimer();
								tablePanel.add(tableTimer.getStopWatchPanel(), BorderLayout.CENTER);
								tableTimer.getStopWatchPanel().setBackground(new Color(0, 104, 56));
								tableTimer.getChargeLabel().setForeground(Color.WHITE);
								tableTimer.getStopWatchLabel().setForeground(Color.WHITE);
								tableTimer.setDaemon(true);
								setText("END");
								tableTimer.start();
							} else if (end) {
								gameCount++;
								setText("RESET");
								tableTimer.setIsRun(false);
								BilliardCount billiardCount = new BilliardCount(gameCount, tableNum,
										tableTimer.getStopWatchLabel().getText(), tableTimer.getCharge());
								tableDatas.add(billiardCount);
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
					billiardFileReader = new FileReader("Text/Four.txt");
					tableTimer = new StopWatch(billiardFileReader);

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	class OutThread extends Thread {
		
		DataOutputStream billiardDOST;
		
		public OutThread(DataOutputStream billiardDOST) {
			// TODO Auto-generated constructor stub
			this.billiardDOST=billiardDOST; 
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				billiardDOST.writeBoolean(start);
				billiardDOST.writeBoolean(end);
				billiardDOST.writeBoolean(reset);
				billiardDOST.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	class BilliardClose extends JFrame {

		public BilliardClose() {
			// TODO Auto-generated constructor stub

			int totalMoney = 0;

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			setIconImage(toolkit.getImage("images/OptionIcon.png"));

			JPanel closePanel = new JPanel();
			closePanel.setLayout(new BorderLayout());
			closePanel.setBackground(new Color(0, 104, 56));

			String[] col = { "No", "테이블", "시간", "가격" };
			DefaultTableModel accountModel = new DefaultTableModel(col, 0);
			JTable accountTable = new JTable(accountModel);
			JScrollPane accountScrollPanel = new JScrollPane(accountTable);
			accountScrollPanel.getViewport().setBackground(new Color(0, 104, 56));
			System.out.println(getWidth() + "" + getHeight());

			for (int i = 0; i < tableDatas.size(); i++) {
				int num = tableDatas.get(i).getNum();
				int tableNum = tableDatas.get(i).getTableNum();
				String time = tableDatas.get(i).getTime();
				int charge = tableDatas.get(i).getCharge();

				totalMoney += charge;

				String[] datas = { num + "", tableNum + "", time, charge + "" };
				accountModel.addRow(datas);
			}

			closePanel.add(accountScrollPanel, BorderLayout.CENTER);

			JLabel closingAccountLabel = new JLabel("총 결산금액 : " + totalMoney + "원");
			closingAccountLabel.setFont(new Font("NanumGothicBold", Font.BOLD, 50));
			closingAccountLabel.setForeground(Color.WHITE);
			closingAccountLabel.setHorizontalAlignment(JLabel.RIGHT);

			closePanel.add(closingAccountLabel, BorderLayout.SOUTH);

			add(closePanel);
			setTitle("Balance Accounts");
			setBounds(100, 100, 800, 600);
			setVisible(true);
		}

	}

	class ServerThread extends Thread {

		public ServerThread() {
			// TODO Auto-generated constructor stub
			try {
				serverSocket = new ServerSocket(10001);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {

			while (true) {
				try {
					System.out.println("대기중");
					client = serverSocket.accept();
					tableAcceptCnt++;
					System.out.println("접속됨" + client);

					InputStream billiardIS = client.getInputStream();
					OutputStream billiardOS = client.getOutputStream();

					billiardDIS = new DataInputStream(billiardIS);
					billiardDOS = new DataOutputStream(billiardOS);
					switch(tableAcceptCnt) {
					case 1: 
						btnTable1.setGameDIS(billiardDIS);
						btnTable1.setGameDOS(billiardDOS);
						break;
					case 2: 
						btnTable2.setGameDIS(billiardDIS);
						btnTable2.setGameDOS(billiardDOS);
						break;
					case 3: 
						btnTable3.setGameDIS(billiardDIS);
						btnTable3.setGameDOS(billiardDOS);
						break;
					case 4: 
						btnTable4.setGameDIS(billiardDIS);
						btnTable4.setGameDOS(billiardDOS);
						break;
					case 5: 
						btnTable5.setGameDIS(billiardDIS);
						btnTable5.setGameDOS(billiardDOS);
						break;
					case 6: 
						btnTable6.setGameDIS(billiardDIS);
						btnTable6.setGameDOS(billiardDOS);
						break;
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

}
