import java.util.Random;

public class Main {	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Random��ü ����
		Random rnd= new Random();
		int n= rnd.nextInt();
		
		//�����(���α׷���)���� class��ü ����
		Second second= new Second();
		second.show();
		
		System.out.println( second.a );
		
		second.a= 10;
		System.out.println( second.a );
		
		Third t= new Third();
		Test test= new Test();
				

	}//main method..

}//Main class...





