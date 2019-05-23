
public class Test {
	
	final int num= 20; //final 멤버변수
	//final int age;//error : 멤버변수는 final하면서 명시적으로 초기화 해줘야 함.	
	
	void aaa() {
		//num=30; //error : final 멤버변수 값 변경 불가!!
		bbb(10);
	}

	void bbb(final int k) { //매개변수에도 final 가능함.
		System.out.println( k );
		//k=50; //error			
	}
	
	//메소드에 final적용 : 오버라이드 불가!!!
	//Test를 상속받는 Sample클래스 설계
	final void show() {
		System.out.println("TEST!!!");	
	}

}








