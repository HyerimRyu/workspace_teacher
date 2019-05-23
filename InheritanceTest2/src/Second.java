
public class Second extends First{
	//그냥보면 하나도 없는 것처럼 보이지만 상속받은 First클래스의 
	//멤버를 보유하게됨.
	
	//멤버변수 추가.
	int b;
	
	//멤버값 대입하는 기능
	void setMembers(int a, int b) {
		//super.a= a; //부모객체의 값은 부모객체가 알아서!!!
		setA( a );//부모클래스이 대입하는 기능!!
		this.b= b;
	}
	
	
	//본인 멤버변수를 출력하는 기능!
	void showSecond() {
		System.out.println("b : "+ b);		
	}
	
	//상속받은 클래스의 멤버까지 출력하는 기능!
	void show() {
		//System.out.println("a : "+ a);//객체멤버출력은 그 객체가 직접!!
		showFirst();
		System.out.println("b : "+ b);
		System.out.println();
	}
	

}








