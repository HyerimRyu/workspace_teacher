import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerFrame extends JFrame{
	
	JTextArea textArea;//��� ��������
	JTextField tfMsg;
	JButton btnSend;
	
	ServerSocket serverSocket;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	
	public ServerFrame() {
		// TODO Auto-generated constructor stub
		setTitle("Server");
		setBounds(450, 50, 500, 300);
		
		textArea= new JTextArea();
		textArea.setEditable(false);//�������!!
		JScrollPane scrollPane= new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel msgPanel= new JPanel();
		msgPanel.setLayout(new BorderLayout());
		
		tfMsg= new JTextField();
		btnSend= new JButton("send");
		
		msgPanel.add(tfMsg, BorderLayout.CENTER);
		msgPanel.add(btnSend, BorderLayout.EAST);
		
		add(msgPanel, BorderLayout.SOUTH);
		
		//send��ư Ŭ���� �����ϴ� ������ �߰�
		btnSend.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sendMessage();
			}
		});
		
		//����Ű�� ������ �� �����ϱ�!! 
		tfMsg.addKeyListener(new KeyAdapter() {
			//Ű���忡�� Ű �ϳ��� �������� �ڵ����� ����Ǵ� �޼ҵ�..: �ݹ�޼ҵ�
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				
				//�Է¹��� Ű�� �������� �˾Ƴ���.
				//�Ķ���ͷ� ���޵� KeyEvent��ü�� Ű�� ���� ������ ������ ����.
				int keyCode= e.getKeyCode();
				
				switch(keyCode) {
				case KeyEvent.VK_ENTER:
					sendMessage();
					break;
				}
				
			}
		});		
		
		setVisible(true);
		tfMsg.requestFocus();
		
		
		//������ ������ �� �ֵ��� ���������� ����� ����� �� �ִ� �غ��۾�!
		// ��Ʈ��ũ�۾��� Main Thread�� �ϰ��ϸ� �ٸ� �۾�(Ű�����Է�, Ŭ�� ��..)���� ���� �� �� ����.��, ���α׷��� ����
		//�׷���  Main�� UI�۾��� �����ϵ��� �ϰ�..
		//�ٸ� �۾���(�����ɸ���)�� ������ Thread���� �����ϴ� ���� ������.
		ServerThread serverThread= new ServerThread();
		serverThread.setDaemon(true);
		serverThread.start();
		
		
		addWindowListener(  new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				
				try {
					if(dos!=null) dos.close();
					if(dis!=null) dis.close();
					if(socket!=null) socket.close();
					if(serverSocket!=null) serverSocket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
	}//������ �޼ҵ�...
	
	//�̳� Ŭ����
	//���������� �����ϰ� Ŭ���̾�Ʈ�� ������ ����ϸ�....
	//������ �Ǿ��� �� �޼����� ���������� �޴� ���� ����...
	class ServerThread extends Thread{
		@Override
		public void run() {
			
			try {
				//�������� ����
				serverSocket= new ServerSocket(10001);
				textArea.append("���������� �غ�Ǿ����ϴ�...\n");				
				textArea.append("Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�...\n");
				socket= serverSocket.accept();//Ŭ���̾�Ʈ�� ������ �� ���� Ŀ��(Thread)�� ���⼭ ���!!
				textArea.append( socket.getInetAddress().getHostAddress() + "���� �����ϼ̽��ϴ�...\n"); //������ IP�ּҰ� ������.
				
				//����� ���� ��Ʈ������
				dis= new DataInputStream( socket.getInputStream() );
				dos= new DataOutputStream( socket.getOutputStream() );
				
				while(true) {
					//������ ������ �����͸� �б�..
					String msg= dis.readUTF();//������ ������ ���� ���!!
					textArea.append("[ CLIENT ] : " + msg +"\n");
					textArea.setCaretPosition(textArea.getText().length());
				}		
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				textArea.append("Ŭ���̾�Ʈ�� �������ϴ�.");
			}
		}
	}
	
	
	//�޼����� �����ϴ� ��ɸ޼ҵ� - send��ưŬ������ �� �� �۾�
	void sendMessage() {
		//TextField�� ���ִ� �۾��� ������
		String msg= tfMsg.getText();
		tfMsg.setText("");
		
		//1. TextArea(ä��â)�� ǥ��
		textArea.append( "[ SERVER ] : " + msg + "\n" );
		textArea.setCaretPosition(textArea.getText().length());
		
		//2. ����(Client)���� �޼���(������ ���� �۾�)�� ����
		Thread t= new Thread() {
			@Override
			public void run() {
				try {
					dos.writeUTF(msg);
					dos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};		
		t.start();
	}
	

}//ServerFrame class..









