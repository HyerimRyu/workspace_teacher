import java.util.Scanner;

public class Variable {
	
	public static void main(String[] args) {	
		
		//키보드 입력을 받아서 자료형에 맞게 바꿔주는 객체생성
		Scanner scan = new Scanner(System.in);	
		
		int a, b;
		
		System.out.print("입력 : ");
		a= scan.nextInt();
		
		System.out.print("입력 : ");
		b= scan.nextInt();
		
		System.out.println();
		System.out.println( a + " + "+ b + " = " + (a+b) );
		
	}

}






