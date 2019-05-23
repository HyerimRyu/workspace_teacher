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
		
		//통신을 하려면 일단 IP주소는 알아야함.
		
		//자바에서 IP주소에 관련된 정보를 가지고 있는 클래스 : InetAddress
		//본인의 IP주소를 확인할 수 있는 방법
		try {
			System.out.println( InetAddress.getLocalHost().getHostAddress() );
			System.out.println( InetAddress.getLocalHost().getHostName() );
			System.out.println( InetAddress.getLoopbackAddress().toString() );
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//통신을 구현하려면 2가지 용어를 알아야함.
		//1. IP주소 - 그 컴퓨터의 고유한 주소(숫자): 4억개
		//2. port번호 - 그 컴퓨터 안에서의 프로그램 분류번호(65천개) 0~65535 : 0~1024까지는 사용하지 마세요.
		//ex) 부산항(IP주소), 3번항구(port번호)
		
		
		//서버 프로그램으로서의 작업
		//1. 서버소켓을 만들어 놓는 작업!
		
		try {
			ServerSocket serverSocket= new ServerSocket(10001);
			System.out.println("서버소켓이 생성되었습니다.");
			
			//2. 클라이언트의 접속 기다리기..
			System.out.println("클라이언트의 접속을 기다랍니다....");
			Socket socket= serverSocket.accept();//여기서 커서(스레드)가 대기함.
			System.out.println( socket.getInetAddress().getHostAddress()  + "클라이언트가 접속하셨습니다.");
			
			//3. 데이터를 주고받을 Stream만들기!!
			//데이터를 입력받은 스트림 만들기 : 해임달(Socket)에게 무지개로드(InputStream)을 열어주세요!!
			//연결된 client소켓과 다리 연결!!
			InputStream is= socket.getInputStream();//바이트 스트림
			InputStreamReader isr= new InputStreamReader(is);//문자 스트림
			BufferedReader reader= new BufferedReader(isr);//보조 문자 스트림
			
			//클라이언트와 연결된 다리(Stream)을 통해 데이터를 읽어오기
			String msg= reader.readLine();//클라이언트가 데이터를 보내면 한줄씩 일기...여기서 클라이언트가 데이터를 보낼때까지 대기....
			System.out.println("받은 데이터 : " + msg);
			
			reader.close();			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //0~65535
		
		
		
		

	}

}







