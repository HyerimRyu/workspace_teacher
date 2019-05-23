
public class Test {
	
	public int a;        //멤버변수           -- 인스턴스된 객체마다 있으므로 -->다른말로 : 인스턴스 변수
	public static int b; //정적(static) 멤버변수  -- 클래스에 한개 있으므로 -->다른말로 : 클래스 변수
	public static final int c= 50;
	
	//생성자메소드
	public Test() {
		// TODO Auto-generated constructor stub
		a=10;
		b=50;
	}
	
	public Test(int a, int b) {
		// TODO Auto-generated constructor stub
		this.a= a;
		this.b= b;
	}
	
	
	
	//static변수가 되듯이.
	//static메소드도 가능함.
	static void show() {
		//static 메소드 안에서는..........
		//System.out.println("멤버변수 a : "+ a);//인스턴스 변수 사용불가!!
		System.out.println("멤버변수 b : "+ b);//static 변수 사용가능
	}
	
	//instance 메소드(일반메소드)
	void aaaa() {
		System.out.println("멤버변수 a : "+ a);
		System.out.println("멤버변수 b : "+ b);
	}
	

}










