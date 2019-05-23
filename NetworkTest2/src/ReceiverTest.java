import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			//Datagram(우편)을 받은 우체통(DatagramSocke) 만들기
			DatagramSocket socket= new DatagramSocket(10003);
			//우편물의 내용( 데이터 )을 받은 박스(DatagramPacket) 만들기
			//데이터를 보관할 byte 배열
			byte[] buf= new byte[100];			
			DatagramPacket packet= new DatagramPacket(buf, buf.length);
			
			System.out.println("메세지를 기다립니다.");
			socket.receive(packet); //메세지를 받아서 packet안에 buf안에 넣어줌, 메세지를 받을 때까지 대기.....
			
			//byte[]을 String으로 변환
			String s= new String(buf);			
			System.out.println("받은 메세지 : "+ s);
			
			
		}catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
