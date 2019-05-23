import java.util.Random;

public class Main {	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Random객체 생성
		Random rnd= new Random();
		int n= rnd.nextInt();
		
		//사용자(프로그래머)정의 class객체 생성
		Second second= new Second();
		second.show();
		
		System.out.println( second.a );
		
		second.a= 10;
		System.out.println( second.a );
		
		Third t= new Third();
		Test test= new Test();
				

	}//main method..

}//Main class...





