
public class Variable {
	
	//멤버변수(Field) : 객체가 생성될때!!(new 될때), 객체가 소멸될때!! 변수없어짐.
	int a;
	int b;
	
	int k;
	
	//메소드안에 변수 선언
	void aaa() {
		//지역변수는 메소드가 호출될때 만들어짐.메소드가 종료되면 지역변수 제거!
		int k; //지역변수 : 자동초기화 되어 있지 않음.!!!
		
		System.out.println( a );//0
		//System.out.println( k );//error
		c=50;
		
		bbb();//OK
	}
	
	int c;//메소드 사이에 멤버변수 선언!!
	
	//다른 메소드
	void bbb() {
		//멤버변수는 이 클래스 안에 어떤 메소드에서도 인식가능!!
		a= 30;
		//aaa() 메소드의 지역변수 k는 다른 메소드에서는 인식불가능!!
		//k=30;//error
		
		//멤버변수와 같은 이름을 가진 지역변수가 있을 수 있을까?? OK!!
		int a;//지역변수
		a= 50;		
		
	}
	
	//파리미터(매개변수)는 지역변수의 일종
	void ccc(int x, int a) {//멤버변수와 같은 이름의 매개변수 가능함!!
		
		a= 50; //지역변수 a을 의미함.
		
		
	}
	
	void ddd() {
//		k=50;
//		int k;
		ddd(); //재귀호출: 가능!!
	}
	
	int d;

}







