
//Outter class : 이너 클래스를 가지고 있는 클래스!
public class Test {
	
	int a; //멤버변수
	
	//멤버메소드
	void show() {
		System.out.println("Test..." + a);
		//이너클래스의 멤버를 마음대로 사용할 수 없음.
		//k=30;//error
	}
	
	//이너클래스를 만들어주는 기능
	Nice makeInnerClass() {
		//이너클래스 객체생성 가능!
		Nice n= new Nice();		
		return n;
	}
	
	
	//Inner class : 클래스 안에 다른 클래스의 설계를 정의!
	//이너클래스의 특징
	//1. 외부(다른 클래스)에서 아웃터클래스명 없이 인식불가!!
	//2. 외부에서 아웃터명을 이용하여 인식하더라도..객체생성 불가!!
	//3. 이너 클래스는 아웃터클래스안에서만 생성할 수 있음.
	
	//4. 이너클래스안에서는 아웃터의 멤버를 마음대로 사용할 수 있음.
	//4-1. 아웃터는 이너의 멤버를 마음대로 쓸수 없음.
	class Nice{
		
		int k=10;//멤버변수
		
		//멤버메소드
		void aaa() {
			a=50;//아웃터의 멤버변수..사용
			System.out.println("Nice.... k: "+ k);
			System.out.println("Nice.... a: "+ a);
			
			//아웃터의 멤머메소드 가능
			show();	
			
		}
		
	}//Nice class
	

}//Test class..















