
//추상 클래스 : 그냥 사용하는 것이 아니라 반드시 상속해서 사용해야 함!!
public abstract class Test {
	
	int a;//인스턴스 변수
	static int b=10; //static 변수
	
	//생성자메소드
	public Test() {
		System.out.println("Test 생성자!!");
	}
	
	//인스터스 메소드
	void show() {
		System.out.println("show..");
	}
	
	//추상 메소드
	abstract void aaa();
	abstract void ccc();
	//abstract static void ddd(); //에러: abstract와 static은 동시에 사용불가
	
	//static메소드
	static void bbb() {
		System.out.println("static..."+ b);
	}

}







