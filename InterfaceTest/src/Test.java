//인터페이스의 정의 모습 : 클래스 정의 모습 동일함.
//인터페이스는 객체 생성불가!!(Like. 추상클래스)
public interface Test {
	
	//interface의 특징들
	//1. 인터페이스 안에서는 인스턴스, static 변수, 인스턴스메소드를 만들 수 없음.
	//2. 인터페이스 안에서는 추상메소드, static메소드, 멤버필드는 public static final만 가능함.
	//3. 인터페이스 안에있는 멤버는 전원 자동 public임!!
	//4. 인터페이스는 기능(메소드)구현이 완성된 것이 아니기에 그냥 사용할 수는 없고 반드시 기능을 구현해야만 사용 가능함.
	//5. 인터페이스를 사용하려면 새로운 클래스를 정의하면서 implements 키워드로 구현해야 만 함.
	//6. 인터페이스도 일종의 상속개념이므로 UP Casting이 가능함.
	//7. 인터페이스는 다중구현(다중상속)이 가능함. //AAA,BBB 인터페이스, Sample클래스
	//8. 인터페이스도 다른 인터페이스를 상속받을 수 있음.!! //KKK, SSS인터페이스
	//9. 인터페이스 안에 이너클래스(Inner class)를 정의하면 자동 public static이 됨.
	
	
	//멤버변수 사용불가!
	//int a;
	//static int b;
	
	//final멤버필드 사용가능
	public static final int a=10; 
	int b=20; //자동 public static final이 되었음! : 명시적초기화가 되어 있을때만!!
	
//	private static final int c=50;
//	protected static final int d=50;
	
	//인스턴스 메소드 에러!!
//	void show() {
//		//에러
//	}
	
	
	//접근제한자는 무조건 public: 안써도 자동 public
	public abstract void aaa(); //이름만 있는 메소드 : 추상 메소드!!
	void ddd();//자동 public abstract
	
//	protected abstract void ccc();
	
	//static메소드 : (JDK 1.8버전 부터 가능함) : 자동 public
	static void bbb() {
		System.out.println("bbb");
	}
	
	
	
	//이너 클래스 설계 : 자동 public static
	class Hello{
		void show() {
			System.out.println("Hello show...");
		}
	}
	
	

}//Test interface











