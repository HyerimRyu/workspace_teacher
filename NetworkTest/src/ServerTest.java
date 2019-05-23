import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//����� �Ϸ��� �ϴ� IP�ּҴ� �˾ƾ���.
		
		//�ڹٿ��� IP�ּҿ� ���õ� ������ ������ �ִ� Ŭ���� : InetAddress
		//������ IP�ּҸ� Ȯ���� �� �ִ� ���
		try {
			System.out.println( InetAddress.getLocalHost().getHostAddress() );
			System.out.println( InetAddress.getLocalHost().getHostName() );
			System.out.println( InetAddress.getLoopbackAddress().toString() );
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//����� �����Ϸ��� 2���� �� �˾ƾ���.
		//1. IP�ּ� - �� ��ǻ���� ������ �ּ�(����): 4�ﰳ
		//2. port��ȣ - �� ��ǻ�� �ȿ����� ���α׷� �з���ȣ(65õ��) 0~65535 : 0~1024������ ������� ������.
		//ex) �λ���(IP�ּ�), 3���ױ�(port��ȣ)
		
		
		//���� ���α׷����μ��� �۾�
		//1. ���������� ����� ���� �۾�!
		
		try {
			ServerSocket serverSocket= new ServerSocket(10001);
			System.out.println("���������� �����Ǿ����ϴ�.");
			
			//2. Ŭ���̾�Ʈ�� ���� ��ٸ���..
			System.out.println("Ŭ���̾�Ʈ�� ������ ��ٶ��ϴ�....");
			Socket socket= serverSocket.accept();//���⼭ Ŀ��(������)�� �����.
			System.out.println( socket.getInetAddress().getHostAddress()  + "Ŭ���̾�Ʈ�� �����ϼ̽��ϴ�.");
			
			//3. �����͸� �ְ���� Stream�����!!
			//�����͸� �Է¹��� ��Ʈ�� ����� : ���Ӵ�(Socket)���� �������ε�(InputStream)�� �����ּ���!!
			//����� client���ϰ� �ٸ� ����!!
			InputStream is= socket.getInputStream();//����Ʈ ��Ʈ��
			InputStreamReader isr= new InputStreamReader(is);//���� ��Ʈ��
			BufferedReader reader= new BufferedReader(isr);//���� ���� ��Ʈ��
			
			//Ŭ���̾�Ʈ�� ����� �ٸ�(Stream)�� ���� �����͸� �о����
			String msg= reader.readLine();//Ŭ���̾�Ʈ�� �����͸� ������ ���پ� �ϱ�...���⼭ Ŭ���̾�Ʈ�� �����͸� ���������� ���....
			System.out.println("���� ������ : " + msg);
			
			reader.close();			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //0~65535
		
		
		
		

	}

}







