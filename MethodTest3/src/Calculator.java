
public class Calculator {
	
	//멤버 메소드
	//더하기 기능
	int sum(int x, int y) {		
		return x+y;
	}
	
	//빼기 기능
	int subtract(int x, int y) {
		return x-y;
	}
	
	//곱셈 기능
	int multiply(int x, int y) {
		return x*y;
	}
	
	//나눗셈 기능
	int divide(int x, int y) {
		return x/y;
	}
	
	
	//double형 사칙연산 기능..
	//오버로딩(Overloading):메소드의 이름은 같고, 파라미터가 다른 메소드..
	double sum(double x, double y) {
		return x+y;		
	}
	
	double subtract(double x, double y) {
		return x-y;		
	}
	
	double multiply(double x, double y) {
		return x*y;
	}
	
	double divide(double x, double y) {
		return x/y;
	}
	
	//숫자 문자열의 산술덧셈
	int sum(String s1, String s2) {
		int n1= Integer.parseInt(s1);
		int n2= Integer.parseInt(s2);
		
		return n1+n2;		
	}
	
	

}

















