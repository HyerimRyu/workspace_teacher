
public class Second extends First{
	
	private int b;
	//int a=50;//변수도 override가 되지만 가급적 사용하지 않음.
	
	public Second(){
		super();
	}
	
	public void show() {		
		//First의 a를 대신 출력해줘야죠...
		super.show();//First클래스의 show()호출
		System.out.println("b : "+ b);
		
	}
	

}
