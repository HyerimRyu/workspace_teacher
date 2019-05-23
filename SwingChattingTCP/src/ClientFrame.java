import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFrame extends JFrame{
	
	JTextArea textArea;//��� ��������
	JTextField tfMsg;
	JButton btnSend;
	
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	
	public ClientFrame() {
		// TODO Auto-generated constructor stub
		setTitle("Client");
		setBounds(450, 380, 500, 300);
		
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
		
		
		//������ �����ϴ� ��Ʈ��ũ �۾� �����尴ü ���� �� ����
		ClientThread clientThread= new ClientThread();
		clientThread.setDaemon(true);
		clientThread.start();
		
		//Ŭ���̾�Ʈ�����ӿ� window(â)���� ������ �߰�
		addWindowListener(  new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				
				try {
					if(dos!=null) dos.close();
					if(dis!=null) dis.close();
					if(socket!=null) socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
	}//������ �޼ҵ�
	
	//�̳�Ŭ����
	//������ �����ϴ� ��Ʈ��ũ �۾� ������
	class ClientThread extends Thread{
		@Override
		public void run() {
			try {
				socket= new Socket("127.0.0.1", 10001);
				textArea.append("������ �����߽��ϴ�...\n");
				
				//������ ������ ���� ��Ʈ������(����¸��)
				InputStream is= socket.getInputStream();
				OutputStream os= socket.getOutputStream();
				
				//������Ʈ������ ���� ���������� �۾��� ���ϰ� ....
				dis= new DataInputStream(is);
				dos= new DataOutputStream(os);
				
				while(true) {
					//���� ������ �Է¹ޱ�
					String msg= dis.readUTF();
					textArea.append("[ SERVER ] : "+ msg + "\n");
					textArea.setCaretPosition(textArea.getText().length());
				}
				
				
				
			} catch (UnknownHostException e) {
				textArea.append("�����ּҰ� �̻��մϴ�.\n");				
			} catch (IOException e) {
				textArea.append("������ ������ ���������ϴ�.\n");
			}
		}		
	}
	
	//�޼����� �����ϴ� ��ɸ޼ҵ� - send��ưŬ������ �� �� �۾�
	void sendMessage() {
		//TextField�� ���ִ� �۾��� ������
		String msg= tfMsg.getText();
		tfMsg.setText("");
			
		//1. TextArea(ä��â)�� ǥ��
		textArea.append( "[ CLIENT ] : " + msg + "\n" );
		textArea.setCaretPosition(textArea.getText().length());
			
		//2. ����(Server)���� �޼���(������ ���� �۾�)�� ����
		// �ƿ�ǲ ��Ʈ���� ���� ���濡 ����������
		// ��Ʈ��ũ �۾��� ������ Thread�� �ϴ� ���� ����.
		
		Thread t= new Thread() {
			@Override
			public void run() {
				try {
					dos.writeUTF(msg);//�ѱ۵� ������ �ʰ��ϱ� ����..
					dos.flush();			
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		t.start();
		
		
	}

}//ClientFrame class...











