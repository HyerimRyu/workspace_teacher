import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//상대방 게이머인 컴퓨터 객체 생성!!
		Computer com= new Computer();
		
		//컴퓨터 객체에게 정답값을 랜덤하게 만들어 내라!!
		com.makeNumbers();		
		
		Scanner scanner= new Scanner(System.in);
		while(true) {
			//키보드 입력받기!!			
			String userNumber= scanner.next();
			
			//컴퓨터에게 내가 입력받은 값을 전달해주고 응답을 출력하도록!!
			boolean result= com.checkAnswer(userNumber);
			
			//정답이면 반복 종료!!
			if(result) break;			
			
		}//while
		
		//한판더?!!!		
		

	}

}






