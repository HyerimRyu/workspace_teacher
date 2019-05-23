
public class Second extends First{
	
	private int b; 
	
	//생성자 메소드 
	public Second() {
		//super();부모클래스(First) 생성자를 호출했다!!!
		System.out.println("Second객체 생성!!");
	}	
	
	//생성자 오버로딩
	public Second(int a, int b) {
		super(a); //First(부모클래스)생성자 명시적 호출
		//super() 생성자 호출은 반드시 첫번째 문자으로 있어야함.!!		
		this.b= b;	
		System.out.println("Second객체 int, int 생성!!");
	}
	
	
	public void showSecond() {
		System.out.println("b : "+ b);		
	}
	
	public void show() {
		showFirst();
		System.out.println("b : "+ b);		
		System.out.println();
	}

}
