
public class First {
	
	private int a;
	
	//객체생성시 1번 자동으로 실행되는 메소드 : 생성자 메소드
	public First() {		
		System.out.println("First객체 생성!!");		
	}
	
	//생성자 메소드 오버로딩
	public First(int a) {
		System.out.println("First객체 int 생성!!");
		this.a= a;
	}
	
	
	
	public void showFirst() {
		System.out.println("a : "+ a);
	}

}
