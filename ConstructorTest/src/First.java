
public class First {
	
	//객체가 생성될때 1번 자동으로 실행되는 메소드
	//생성자 메소드(Constructor)
	First(){
		System.out.println("First 생성자!");		
	}
	
	//생성자도 메소드이므로 Overloading(오버로딩)가능
	First(int a){
		System.out.println("First int 생성자! "+ a);		
	} 

}












