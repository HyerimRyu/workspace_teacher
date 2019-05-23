import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClientRoom {
	
	
	WaitingRoom waitingRoom;
	
	JTextArea textArea;
	JTextField tfMsg;
	JButton btnSend;
	
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	
	ClientThread clientThread;
	Main main;
	
	int readyToRumble=0;
	
	
	
	public ClientRoom(Main main) {
		// TODO Auto-generated constructor stub
		waitingRoom = new WaitingRoom();
		this.main=main;
		
	
	}
	
	class WaitingRoom extends JFrame{
		
		public WaitingRoom() {
			// TODO Auto-generated constructor stub
			textArea = new JTextArea();
			textArea.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(textArea);
			add(scrollPane,BorderLayout.CENTER);
			
			JPanel msgpanel = new JPanel();
			msgpanel.setLayout(new BorderLayout());
			tfMsg = new JTextField();
			msgpanel.add(tfMsg,BorderLayout.CENTER);
			btnSend = new JButton("SEND");
			msgpanel.add(btnSend,BorderLayout.EAST);
			add(msgpanel, BorderLayout.SOUTH);
			setTitle("Waiting Room");
			setBounds(450,50,400,350);
			setVisible(true);
			
			clientThread = new ClientThread();
			clientThread.start();
			
			tfMsg.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyReleased(KeyEvent k) {
			
				}
				
				@Override
				public void keyPressed(KeyEvent k) {
					if(k.getKeyCode() == 10) {
						btnSend.doClick();
					}
				}
			});
			btnSend.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					sendMsg();
				}
			});
		}
		void sendMsg() {
			
			String msg = tfMsg.getText();
			tfMsg.setText("");
			//내 메세지창에 글 추가
			textArea.append("[나] : "+msg+"\n");
			textArea.setCaretPosition(textArea.getText().length());
			
			//상대방에게 메세지 전송. 
			new Thread() {
				@Override
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
		
	}
	
	
	
	class ClientThread extends Thread{
		@Override
		public void run() {
			
			try {
				socket = new Socket("127.0.0.1", 20002);
				textArea.append("서버에 접속했습니다...\n");
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				
				while(true) {
					String msg = dis.readUTF();
					
					if (msg.equals("1000100111100110111000111001111000111000111022231548744662288774142264484521164841213454423")) {
						

						
						//waitingRoom.setVisible(false);
						readyToRumble = 99;
						
						
						waitingRoom.setVisible(false);
						
						main.getContentPane().removeAll();
						
						main.multiPlay = new MultiPlay();
						main.add(main.multiPlay);
							
						main.revalidate();
							
						main.repaint();
							
						break;
					}
					textArea.append(msg);
					textArea.setCaretPosition(textArea.getText().length());

				}
				
				
			}catch(Exception e) {
				textArea.append("연결 실패 or 연결 종료");
			
				textArea.setCaretPosition(textArea.getText().length());

			}
			
			
			
			
		}
	}
	
	
}
