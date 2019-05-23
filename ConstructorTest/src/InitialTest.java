
public class InitialTest {
	//1. 기본값 초기화 - 0
	int a=10; //2.명시적 초기화
	static int b;
	
	//3.0 static 초기화 블럭 : 객체가 처음 만들어질때 1번 실행(객체 개수상관없이)
	static
	{
		//a=10;//일반 멤버변수는 초기화 못함. error
		b= 40;//static 멤버변수만 초기화 할 수 있음.
		System.out.println("static 초기화 블럭!!");
	}
		
	//3.1 초기화 블럭(Region) : 인스턴스 초기화블럭 :객체 생성때마다 실행
	{
		//생성자 메소드 전에 실행되는 영역
		a= 20;
		a++;
		System.out.println( a );
		//이런 실행문조차 가능한 영역!!
		if(a<25) {
			a--;
		}
	}
	
	//4. 생성자 메소드
	public InitialTest() {
		// TODO Auto-generated constructor stub
		a=50;
	}

}







