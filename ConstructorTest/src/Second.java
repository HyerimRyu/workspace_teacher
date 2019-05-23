
public class Second {
	
	int a;
	int b;
	
	//생성사 메소드
	public Second() {
		//다른 생성자 호출 가능함!!
		//Second(10, 20); <--이건 문법적으로 안됨.
		this(10, 20);
	}
	
	public Second(int a) {
		//System.out.println("aaa");//error		
		this(a, a);	//첫번째 실행문으로만 가능함.
		System.out.println("aaa");//OK
	}
	
	public Second(int a, int b) {
		this.a= a;
		this.b= b;
	}
	
	
	//일반 메소드
	void aaa() {
		bbb();//다른 메소드 호출 가능!!
	}
	
	void bbb() {
		
	}

}












