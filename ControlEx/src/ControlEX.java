import java.util.Random;
import java.util.Scanner;

public class ControlEX {
	
	public static void main(String[] args) {
		
		//예전방식의 Random값 얻기
		int a= (int)(Math.random() * 10); //0~9
		
		
		
		//랜덤값을 만들어주는 아저씨(Random객체) 생성
		Random rnd= new Random();
		
		int r= rnd.nextInt(10);//0~9
		
		Scanner scan= new Scanner(System.in);
		
		while(true){
			
			System.out.print("input : ");
			int user= scan.nextInt();
			
			if(user>r) System.out.println(user+"보다 작습니다.");
			else if(user<r) System.out.println(user+"보다 큽니다.");
			else {
				System.out.println("정답입니다.");
				break;
			}
			
		}//while
		
		System.out.println("게임 종료!!");
		
		
		
		
		
		
	}	
}










