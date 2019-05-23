
public class Second {
	
	int g= 10; //멤버변수
	
	void aaa() {//멤버메소드
		
		final int r= 50; //지역변수 : 다른 지역에서는 사용불가!		
				
		//AAA k= new AAA();//지역클래스는 정의한 후에만 사용가능
		
		//지역클래스( Local ) : 다른 지역에서는 인식불가!!
		class AAA{
			void show() {
				System.out.println("AAA ... show "+ g);
				System.out.println("AAA ... show "+ r);//일반 지역변수사용불가!
				//final 지역변수는 사용가능!!
			}
		}
		
		
		AAA obj= new AAA();
		obj.show();	
		
		AAA obj2= new AAA();
		obj2.show();	
		
		AAA obj3= new AAA();
		obj3.show();	
		
	}//aaa Method
	
	void bbb() {
		
		//AAA obj= new AAA(); //error
		
	}//bbb Method
	
	//Inner class.

}//Second class..




